package com.progetto.oop;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OopApplication 
{
	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException 
	{
		//SpringApplication.run(OopApplication.class, args);
		String URL="https://www.dati.gov.it/api/3/action/package_show?id=f9198f21-02b8-4479-bccc-eff18564fa8f";
		Dataset dataset=new Dataset(URL);	
		for(Metadati o:dataset.OttieniMetadati(dataset.getData().get(0)))
		{
			System.out.println(o.get1());
			System.out.println(o.get2());
			System.out.println(o.get3());
		}
		
	}

}
