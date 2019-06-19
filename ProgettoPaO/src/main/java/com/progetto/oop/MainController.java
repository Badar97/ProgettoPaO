package com.progetto.oop;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController 
{
	@RequestMapping ( "/dati" )
	@ResponseBody
	public String dati() throws IOException
	{
		return test("dati");
	}
	@RequestMapping ( "/statistiche" )
	@ResponseBody
	public String statistiche() throws IOException  
	{
		return test("statistiche","Permanenza lunga");
	}
	@RequestMapping ( "/filtri" )
	@ResponseBody
	public String filtri()
	{
		return "My Quick Blog2";
	}
	@RequestMapping ( "/metadati" )
	@ResponseBody
	public String metadati()
	{
		return "My Quick Blog2";
	}
	public String test(String oggetto, String...attributo) throws IOException
	{
		AnalisiDati test=new AnalisiDati();
		return test.OttieniJson(oggetto,attributo);
	}
}
