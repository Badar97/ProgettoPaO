package com.progetto.oop;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OopApplication 
{
	public static void main(String[] args) throws IOException
	{
		//SpringApplication.run(OopApplication.class, args);
		String URL="https://www.dati.gov.it/api/3/action/package_show?id=f9198f21-02b8-4479-bccc-eff18564fa8f";
		Dataset dataset=new Dataset(URL);
		Metadati x[]=dataset.getMetadati();
		for(Metadati o:x)
		{
			   System.out.println(o.getAlias());
			   System.out.println(o.getSourceField());
			   System.out.println(o.getType());
		}
	}

}
