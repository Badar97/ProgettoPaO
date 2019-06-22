package com.progetto.oop; 

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import stats.StatisticheDataset;

@Controller
public class StatsController 
{
	@RequestMapping ( "/stats/{attributo}" )
	@ResponseBody
	public String dati(@PathVariable String attributo) throws IOException 
	{
		return OttieniJson(attributo);
	}
	public String OttieniJson(String attributo) throws IOException
	{
		AnalisiDati obj=new AnalisiDati();
		StatisticheDataset stat=new StatisticheDataset(obj.getDataset().getData());
		obj.MarshallingJson(stat.getStatistiche(attributo));
		return obj.LeggiJson();
	}
}
