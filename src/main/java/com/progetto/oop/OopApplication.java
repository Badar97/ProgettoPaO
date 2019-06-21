package com.progetto.oop;

import java.io.IOException;
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
		((OsservazioneBreveIntensiva)(dataset.getData().get(0))).getCampi();
		String[] a=((OsservazioneBreveIntensiva)(dataset.getData().get(0))).getAlias();
		String[] b=((OsservazioneBreveIntensiva)(dataset.getData().get(0))).getSourceField();
		String[] c=((OsservazioneBreveIntensiva)(dataset.getData().get(0))).getType();
		Vector<Metadati> d=new Vector<Metadati>();
		for(int i=0;i<a.length;i++)
		{
			d.add(new Metadati(a[i],b[i],c[i]));
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println(d.get(i).getAlias());
			System.out.println(d.get(i).getSourceField());
			System.out.println(d.get(i).getType());
			System.out.println("OK");
		}
	}

}
