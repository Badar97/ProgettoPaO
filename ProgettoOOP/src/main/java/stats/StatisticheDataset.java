package stats; 

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Vector;
/**
 * La classe calcola le statistiche degli elementi contenuti nel Vector passato come parametro.
 * @author Utente
 *
 */
public class StatisticheDataset
{
	private Vector<?> vettore;
	/**
	 * Crea un oggetto con cui si possono calcolare
	 * le statistiche degli elementi contenuti nel vettore passato per parametro
	 * @param vettore vettore di cui si vogliono calcolare le statistiche
	 */
	public StatisticheDataset(Vector<?> vettore)
	{
		this.vettore=vettore;
	}
	/**
	 * Il metodo calcola le statistiche dei vari attributi del vettore passato come parametro durante l'istanziamento della classe
	 * @param attributo record del dataset da cui calcolare le statistiche
	 * @return restituisce un oggetto di tipo StatisticheDati contenente le statistiche 
	 * dei vari attributi del vettore passato come parametro durante l'istanziamento della classe
	 */
	public StatisticheDati getStatistiche(String attributo)
	{
		StatisticheDati obj=new StatisticheDati(toArray(attributo));	/*Costruisce un oggetto di tipo statistiche dati passando
		come parametro il vettore contenente i valori della colonna corrispondendente all'attributo specificato*/
		if(toArray(attributo).get(0) instanceof Double)	//Se il vettore è di tipo numerico vengono calcolate le seguenti statistiche
		{
			obj.Media();
			obj.Minimo();
			obj.Massimo();
			obj.DeviazioneStandard();
			obj.Somma();
			obj.Count();
		}
		if(toArray(attributo).get(0) instanceof String)	//Se il vettore è di tipo stringa vengono calcolate le occorrenze delle stringhe nel vettore
			obj.Occorrenze();
		return obj;
	}
	/**
	 *La funzione va ad estrapolare la colonna del dataset corrispondente all'attributo
	 * @param attributo attributo di cui calcolare le statistiche
	 * @return restituisce un vettore contenente i valori contenuti nella colonna
	 */
	private ArrayList<Object> toArray(String attributo)  
	{
		ArrayList<Object> valori=new ArrayList<Object>();
		Method m=null;
		try 
		{
			m=this.vettore.get(0).getClass().getMethod("get"+attributo);	//Crea un oggetto di tipo metodo.Tale metodo restituisce l'attributo specificato
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
				valori.add(m.invoke(this.vettore.get(i)));	//Aggiunge i valori della colonna in un vettore
			} 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
			{
				e.printStackTrace();
			} 
		}
			return valori;
	}
}
