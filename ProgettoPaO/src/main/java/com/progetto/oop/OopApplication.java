package com.progetto.oop;


import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OopApplication {

	public static void main(String[] args) throws MalformedURLException, IOException
	{
		String URL="https://www.dati.gov.it/api/3/action/package_show?id=f9198f21-02b8-4479-bccc-eff18564fa8f";
		Dataset dataset=new Dataset(URL);
		SpringApplication.run(OopApplication.class, args);
		Filtri test=new Filtri(dataset.getData());
		test.test();
	}

}
