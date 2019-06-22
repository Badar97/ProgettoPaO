package com.progetto.oop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.Dataset;

/**
 * @author Ali Waqar Badar && Pierigè Giacomo
 */

public class AnalisiDati 
{
	//Attributi
	
	private Dataset dataset;	//Questa variabile andrà a contenere il dataset 
	
	//Metodi
	
	/**
	 * Costruttore della classe AnalisiDati. Quando viene istanziato un oggetto
	 * il programma effettua il download del dataset dall'URL di riferimento e
	 * crea un oggetto di tipo Dataset.
	 * @throws IOException Eccezione lanciata in caso di errori nel download del
	 * file in formato CSV, da cui si ottiene il Dataset
	 */
	public AnalisiDati() throws IOException
	{
		String URL="https://www.dati.gov.it/api/3/action"
				+ "/package_show?id=f9198f21-02b8-4479-bccc-eff18564fa8f";	//Url di riferimento 
		dataset=new Dataset(URL);  //Viene istanziato il dataset 
	}
	
	/**
	 * La procedura effettua il marshalling in Json dell'oggetto passato come parametro
	 * @param obj Oggetto da convertire in formato Json
	 * @throws IOException Eccezione lanciata in caso di errori nella scrittura del Json
	 */
	public void MarshallingJson(Object obj) throws IOException
	{
		FileWriter file=new FileWriter("temp.json");	//Crea un file per memorizzare l'oggetto obj in formato Json
		ObjectMapper mapper = new ObjectMapper();	
		try {
            mapper.writeValue(file, obj);	//Scrive l'oggetto sul file
        }
        catch (JsonGenerationException e)	//Eccezione lanciata in caso di errore nella conversione di obj in formato Json
		{
            e.printStackTrace();
        }
        catch (JsonMappingException e)	//Eccezione lanciata in caso di errore nel mapping dell'oggetto
		{
            e.printStackTrace();
        }
        catch (IOException e)	//Eccezione lanciata in caso di errori nella scrittura del Json
		{
            e.printStackTrace();
            file.close();
        }
		file.close();
	}
	/**
	 * Il metodo legge il file "temp.json" e restituisce una stringa contenete il Json
	 * @return Restituisce una stringa contenete il Json
	 * @throws FileNotFoundException Eccezione lanciata in caso il file non venisse trovato
	 * @throws IOException Eccezione lanciata in caso di errori nella lettura del Json
	 */
	public String LeggiJson() throws FileNotFoundException,IOException
	{
		FileReader file=new FileReader("temp.json");	//Crea un riferimento al file temp.json
		BufferedReader reader = new BufferedReader(file);	//Lettura del file Json
        String line = reader.readLine();
        String Json=new String();
        while(line!=null) 
        {
          	Json+=line;
            line = reader.readLine();
        }
        file.close();
        return Json;
    }
	/**
	 * 
	 * @return Restituisce il dataset importato istanziando la classe AnalisiDati
	 */
	public Dataset getDataset()
	{
		return dataset;
	}

}

