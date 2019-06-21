package com.progetto.oop;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MetaDataController 
{
	@RequestMapping ( "/metadata" )
	@ResponseBody
	public String metadati() throws IOException 
	{
		return OttieniJson();
	}
	public String OttieniJson() throws IOException
	{
		AnalisiDati obj=new AnalisiDati();
		obj.MarshallingJson(obj.getDataset().getMetadati());
		return obj.LeggiJson();
	}
}
