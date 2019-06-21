package com.progetto.oop;

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

public class Dataset implements Indice
{
	private Vector<Object> Dataset=new Vector<Object>();
	private String NomeFile;
	private String URL;
	private Metadati Metadati[];	
	
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
	private void ImportaDataset() throws MalformedURLException, IOException 
	{
		URL=SetUrlDataset(DownloadJson());
		DownloadDataset();
		ParsingCsv();
	}
	private String DownloadJson()
	{
		String dati=new String();
		try 
		{
			URLConnection openConnection = new URL(URL).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in = openConnection.getInputStream();
			String riga = "";
			 try
			 {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buffer = new BufferedReader( inR );
			   while ( ( riga = buffer.readLine() ) != null ) 
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
	private String SetUrlDataset(String info)
	{
		String URL=new String();
		try
		{
			JSONObject json = (JSONObject) JSONValue.parseWithException(info); 
			JSONObject result = (JSONObject) (json.get("result"));
			JSONArray resources = (JSONArray) (result.get("resources"));
			
			for(Object o: resources)
			{
			    if ( o instanceof JSONObject )
			    {
			    	JSONObject temp=(JSONObject) o;
			        String format = (String)temp.get("format");
			        if(format.equals("csv")) 
			        	URL= (String)temp.get("url");
			    }
			}
		} catch(ParseException e)
		  {
			e.printStackTrace();
		  }
		return URL;
	}
	private void DownloadDataset() throws MalformedURLException, IOException
	 {
	    try (InputStream in = URI.create(URL).toURL().openStream()) 
	    {
	        Files.copy(in, Paths.get(NomeFile + ".csv"));
	    }
	}
	private void ParsingCsv() throws IOException
	{
		FileReader file=new FileReader(NomeFile+".csv");
		String riga;
		String Dati[];
		String SourceField[];
		ArrayList<Field> Alias;
		char StringaIn[];
		char StringaOut[];
		try
		{
			BufferedReader buffer=new BufferedReader(file);
			riga = buffer.readLine();
			SourceField=riga.split(",");
			while ( ( riga = buffer.readLine() ) != null ) 
		    {
			   StringaIn=riga.toCharArray();
			   StringaOut=new char[riga.length()];
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


