package com.progetto.oop;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class Filtri 
{
	Vector<?> vettore;
	Vector<Object> vettoreOut=new Vector<Object>();
	
	public Filtri(Vector<?> vettore)
	{
		this.vettore = vettore;
	}
	/*private String UnmarshallingJson(String Json)
	{
		if(Json.contains("$gt"))
		try
		{
			JSONObject json = (JSONObject) JSONValue.parseWithException(json); 
			JSONObject $gt = (JSONObject) (json.get($gt));
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
	public void OperatoreCondizionale(String Json)
	{
		if(Json.contains("$gt"))
		{
			JSONObject json = (JSONObject) JSONValue.parseWithException(json); 
			JSONObject $gt = (JSONObject) (json.get($gt));
		}
	}*/
}
