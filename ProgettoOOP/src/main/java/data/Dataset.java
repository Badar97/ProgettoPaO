package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.progetto.oop.Indice;

/**
 * @author Ali Waqar Badar && Pierigè Giacomo
 */

public class Dataset implements Indice	//La Classe Dataset implementa l'Interfaccia indice che contiene delle costanti
{
	//Attributi
	
	private Vector<Object> Dataset=new Vector<Object>();
	private String NomeFile;
	private String URL;
	private Metadati Metadati[];	
	
	//Metodi
	/**
	 * Viene istanziato il Dataset effettuando il paring di un file CSV.
	 * Se il file non esiste viene prima effettuato il download
	 * @param URL Contiene l'indirizzo da cui viene effettuato il download del dataset
	 * @throws IOException Eccezione lanciata in caso di errori nella scrittura del CSV
	 */
	Dataset(String URL) throws IOException
	{
		NomeFile="dati";
		File file=new File(NomeFile+".csv");
		this.URL=URL;
		if(file.exists())
		{	
			ParsingCsv();
			SaveToFile();
		}
		else
			ImportaDataset();
			SaveToFile();
	}
	
	/**
	 * La procedura ricava l'URL da cui scaricare il dataset effettuando il parsing di un file json.
	 * Una volta ottenuto il link viene effettuato il download del file e il parsing,
	 * aggiungendo i record del dataset in oggetti che ne modellano la struttura.
	 * @throws MalformedURLException Eccezione lanciata se non esiste l'URL
	 * @throws IOException Eccezione lanciata in caso di errori nella scrittura del CSV
	 */
	private void ImportaDataset() throws MalformedURLException, IOException 
	{
		URL=SetUrlDataset(DownloadJson());
		DownloadDataset();
		ParsingCsv();
	}
	
	/**
	 * 
	 * @return Viene restituita una stringa in fomato json contenente l'url da cui ricavare i dati
	 */
	private String DownloadJson()
	{
		String dati=new String();
		try 
		{
			URLConnection openConnection = new URL(URL).openConnection();	//Viene aperta una connessione con l'indirizzo specificato
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in = openConnection.getInputStream();	//Viene aperto un flusso di input per ottenere i dati json dalla pagina web
			String riga = "";
			 try
			 {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buffer = new BufferedReader( inR );
			   while ( ( riga = buffer.readLine() ) != null ) //Attraverso il ciclo i dati nel flusso sono copiai in una stringa
			   {
				   dati+= riga;
			   }
			 } finally 
			   {
				 in.close();
			   }
		} catch(Exception e) 
		  {
			e.printStackTrace();
		  }
		return dati;
	}
	
	/**
	 * Il metodo effettua il parsing del json per ottenere l'URL da cui effettuare il download
	 * @param info Rappresenta una stringa contenente i dati in formato json
	 * @return Viene restituito l'indirizzo da cui effettuare il download del dataset
	 */
	private String SetUrlDataset(String info)
	{
		String URL=new String();
		try
		{
			JSONObject json = (JSONObject) JSONValue.parseWithException(info); 
			JSONObject result = (JSONObject) (json.get("result"));	//Creiamo un oggetto json che fa riferimento al campo "result"
			JSONArray resources = (JSONArray) (result.get("resources"));	//Creiamo un vettore di oggetti json che fa riferimento al campo "resources"
			
			for(Object o: resources)	//Il ciclo scorre il vettore ed individua l'URL da restituire
			{
			    if ( o instanceof JSONObject )
			    {
			    	JSONObject temp=(JSONObject) o;
			        String format = (String)temp.get("format");
			        if(format.equals("csv")) 
			        	URL= (String)temp.get("url");
			    }
			}
		} catch(ParseException e)	//Cattura un'eventuale eccezione durante il parsing
		  {
			e.printStackTrace();
		  }
		return URL;
	}
	
	/**
	 * Il metodo effettua il download del file CSV contenente i record del dataset
	 * @throws MalformedURLException	Eccezione lanciata in caso l'indirizzo sia corrotto
	 * @throws IOException	Eccezione lanciata in caso di errore nella scrittura del file scaricato
	 */
	private void DownloadDataset() throws MalformedURLException, IOException
	 {
	    try (InputStream in = URI.create(URL).toURL().openStream()) 
	    {
	        Files.copy(in, Paths.get(NomeFile + ".csv"));
	    }
	}
	
	/**
	 * Il metodo effettua il parsing del file in formato CSV e dispone i records all'interno delle apposite classi
	 * @throws IOException Eccezione lanciata in caso di errore nella lettura del file scaricato in precedenza
	 */
	private void ParsingCsv() throws IOException
	{
		FileReader file=new FileReader(NomeFile+".csv");	//Viene creato un riferimento al file csv
		String riga;
		String Dati[];
		String SourceField[];	//Vettore di stringhe contenente i nomi dei vari attributi dei records
		ArrayList<Field> Alias;	//Vettore di field contenente i nomi utilizzati all'interno del programma
								//per riferirsi ai vari attributi dei records
		char StringaIn[];
		char StringaOut[];
		try
		{
			BufferedReader buffer=new BufferedReader(file);
			riga = buffer.readLine();
			SourceField=riga.split(",");	//La prima riga del file contiene il nome degli attributi separati da virgole
			while ( ( riga = buffer.readLine() ) != null ) 
		    {
			   StringaIn=riga.toCharArray();	//Otteniamo un array di caratteri dalla stringa contenente una riga di records
			   StringaOut=new char[riga.length()];
			   //Con questo ciclo for il programma sostituisce le virgole contenute nei numeri decimali con dei punti
			   //ed elimina le virgolette che delimitano i vari records. Il risultato dell'operazione è contenuto
			   //nell'array di caratteri StringaOut
			   for(int i=0,j=0;i<riga.length()-1;i++,j++)
			   {
				   if(StringaIn[i]=='\"')	
				   { 
					   i++;
					   do 
					   {
						   if(StringaIn[i]==',')
						   {
							   StringaOut[j++]='.';
							   i++;
						   }
						   else
							   StringaOut[j++]=StringaIn[i++];  
					   } while(StringaIn[i]!='\"');
					   
				   }
				   else
				   {
					   StringaOut[j]=StringaIn[i];
				   }
			   }
			   riga=new String(StringaOut);
			   Dati=riga.split(",");
			   OsservazioneBreveIntensiva elemento=DisponiDati(Dati);
			   Dataset.add(elemento);
		    }
		} finally 
	      {
			file.close();
	      }
		   Alias=new ArrayList<Field>(Arrays.asList(Ospedale.class.getDeclaredFields()));
		   ArrayList<Field> temp=new ArrayList<Field>(Arrays.asList(ProntoSoccorso.class.getDeclaredFields()));
		   Alias.addAll(temp);
		   temp=new ArrayList<Field>(Arrays.asList(Permanenza.class.getDeclaredFields()));
		   Alias.addAll(temp);
		   temp=new ArrayList<Field>(Arrays.asList(OsservazioneBreveIntensiva.class.getDeclaredFields()));
		   Alias.addAll(temp);
		   Object AliasName[]=Alias.toArray();
		   Metadati=new Metadati[SourceField.length];
		   for(int i=0;i<SourceField.length;i++)
		   {
			   Metadati[i]=new Metadati((Field)AliasName[i],SourceField[i]);
		   }
	}
	private void SaveToFile() throws IOException
	{
		FileWriter file=new FileWriter(NomeFile+".txt");
		BufferedWriter buffer=new BufferedWriter(file);
		buffer.write(toString());
	}
	private OsservazioneBreveIntensiva DisponiDati(String Dati[])
	{
		OsservazioneBreveIntensiva elemento=new OsservazioneBreveIntensiva(Dati[NOME_STRUTTURA],Dati[COMUNE]);
		   try
		   {
			   elemento.setTotaleAccessi(Integer.parseInt(Dati[TOTALE_ACCESSI]));
		   } catch(NumberFormatException e)
			 {
			   elemento.setTotaleAccessi(0);
			   e.printStackTrace();
			 }
		   try
		   {
			   elemento.setTempoDiAttesa(Double.parseDouble(Dati[MEDIANA_TEMPO_DI_ATTESA]));
		   } catch(NumberFormatException e)
			 {
			   elemento.setTempoDiAttesa(0);
			   e.printStackTrace();
			 }
		   try
		   {
			   elemento.setPermanenza(Double.parseDouble(Dati[MEDIANA_TEMPO_DI_PERMANENZA]));
		   } catch(NumberFormatException e)
			 {
			   elemento.setPermanenza(0);
			   e.printStackTrace();
			 }
		   try
		   {
			   elemento.setPermanenza(Double.parseDouble(Dati[PERMANENZA_BREVE]),Double.parseDouble(Dati[PERMANENZA_MEDIA]),Double.parseDouble(Dati[PERMANENZA_LUNGA]));
		   } catch(NumberFormatException e)
			 {
			   elemento.setPermanenza(0,0,0);
			   e.printStackTrace();
			 }
		   try
		   {
			   elemento.setPermanenzaObi(Double.parseDouble(Dati[PERMANENZA_OBI]));
		   } catch(NumberFormatException e)
			 {
			   elemento.setPermanenzaObi(0);
			   e.printStackTrace();
			 }
		   return elemento;
	}
	public String getNomeFile()
	{
		return NomeFile;
	}
	public Vector<Object> getData()
	{
		return Dataset;
	}
	public Metadati[] getMetadati()
	{
		return Metadati;
	}
	@Override
	public String toString()
	{
		String Stringa=new String();
		for(Object o:Dataset)
		{
			Stringa+=o;
			Stringa+="\n\n";
		}
		return Stringa;
	}
}


