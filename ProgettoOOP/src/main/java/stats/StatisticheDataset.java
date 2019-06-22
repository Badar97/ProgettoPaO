package stats;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Vector;

public class StatisticheDataset
{
	private Vector<?> vettore;
	public StatisticheDataset(Vector<?> vettore)
	{
		this.vettore=vettore;
	}
	public StatisticheDati getStatistiche(String attributo)
	{
		StatisticheDati obj=new StatisticheDati(toArray(attributo));
		if(toArray(attributo).get(0) instanceof Double)
		{
			obj.Media();
			obj.Minimo();
			obj.Massimo();
			obj.DeviazioneStandard();
			obj.Somma();
			obj.Count();
		}
		if(toArray(attributo).get(0) instanceof String)
			obj.Occorrenze();
		return obj;
	}
	private ArrayList<Object> toArray(String attributo)  
	{
		ArrayList<Object> valori=new ArrayList<Object>();
		Method m=null;
		try 
		{
			m=this.vettore.get(0).getClass().getMethod("get"+attributo);
		} 
		catch (NoSuchMethodException e) 
		{
			e.printStackTrace();
		} 
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		for(int i=0;i<this.vettore.size();i++)
		{
			try
			{
				valori.add(m.invoke(this.vettore.get(i)));
			} 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
			{
				e.printStackTrace();
			} 
		}
			return valori;
	}
}
