package com.progetto.oop;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ali Waqar Badar && Pierigè Giacomo
 * 
 */

@Controller
public class DataController
{
	@RequestMapping ( "/data" )
	@ResponseBody
	public String dati() throws IOException 
	{
		return OttieniJson();
	}
	public String OttieniJson() throws IOException
	{
		AnalisiDati obj=new AnalisiDati();
		obj.MarshallingJson(obj.getDataset().getData());
		return obj.LeggiJson();
	}
}
