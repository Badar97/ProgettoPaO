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

public class AnalisiDati 
{
	Vector<?> vettore;
	public AnalisiDati() throws IOException
	{
		String URL="https://www.dati.gov.it/api/3/action/package_show?id=f9198f21-02b8-4479-bccc-eff18564fa8f";
		Dataset dataset=new Dataset(URL);
		vettore=dataset.getData();
	}
	public String OttieniJson(String oggetto,String...attributo) throws IOException
	{
		Object vettore;
		switch(oggetto)
		{
			case "dati":
				vettore=this.vettore;
				break;
			case "statistiche":
				StatisticheDataset obj=new StatisticheDataset(this.vettore);
				vettore=obj.getStatistiche(attributo[0]);
				break;
			case "filtri":
				Filtri objt=new Filtri(this.vettore);
				//vettore=objt.OperatoreCond("$gt",attributo[0], 15);
				break;
			case "metadati":
				vettore=null;
				break;
			default:
				vettore=null;
		}
		//MarshallingJson(vettore);
		return LeggiJson();
	}
	private void MarshallingJson(Object obj) throws IOException
	{
		FileWriter file=new FileWriter("temp.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
            mapper.writeValue(file, obj);
        }
        catch (JsonGenerationException e) 
		{
            e.printStackTrace();
        }
        catch (JsonMappingException e) 
		{
            e.printStackTrace();
        }
        catch (IOException e)
		{
            e.printStackTrace();
            file.close();
        }
		file.close();
	}
	private String LeggiJson() throws FileNotFoundException,IOException
	{
		FileReader file=new FileReader("temp.json");
		BufferedReader reader = new BufferedReader(file);
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

}

