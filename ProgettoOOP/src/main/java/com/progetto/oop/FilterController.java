package com.progetto.oop;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FilterController
{
	@RequestMapping ( "/filter/{attributo}/{ciao}" )
	@ResponseBody
	public String dati(@PathVariable String attributo,@PathVariable String ciao) throws IOException 
	{
		return ciao+attributo;
		//return OttieniJson(attributo);
	}
	public String OttieniJson(String attributo) throws IOException
	{
		AnalisiDati obj=new AnalisiDati();
		OperatoreCondizionale filter=new OperatoreCondizionale(obj.getDataset().getData());
		obj.MarshallingJson(filter.OperatoreCond("$gt", attributo, 10));
		return obj.LeggiJson();
	}
}
