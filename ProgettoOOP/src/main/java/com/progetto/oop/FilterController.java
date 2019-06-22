package com.progetto.oop;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import filter.OperatoreCondizionale;

@Controller
public class FilterController
{
	String attributo;
	String segno;
	String valore;
	@RequestMapping ( "/filter/{filtro}" )
	@ResponseBody
	public String dati(@PathVariable String filtro) throws IOException 
	{
		//OttieniFiltro(filtro);
		return OttieniJson();
	}
	public String OttieniJson() throws IOException
	{
		AnalisiDati obj=new AnalisiDati();
		OperatoreCondizionale filter=new OperatoreCondizionale(obj.getDataset().getData());
		obj.MarshallingJson(filter.Confronto("$gt","MediaPermanenza",10));
		return obj.LeggiJson();
	}
	private void OttieniFiltro(String filtro)
	{
		filtro=filtro.replaceAll("{","");
		filtro=filtro.replaceAll("}","");
		System.out.println(filtro);
		String vettore[]=filtro.split(":");
		attributo=vettore[0];
		segno=vettore[1];
		valore=vettore[2];
	}
}
