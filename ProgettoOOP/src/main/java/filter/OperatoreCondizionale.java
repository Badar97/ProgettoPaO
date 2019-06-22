package filter; 

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;
/**
 * 
 * La classe si occupa di effettuare operazioni relazionali
 */
public class OperatoreCondizionale
{
	private Vector<?> vettore;
	public OperatoreCondizionale(Vector<Object> vettore)
	{
		this.vettore=vettore;
	}
	public Vector<Object> Confronto(String segno, String attributo, double...valore) 
	{
		Vector<Object> vettoreOut=new Vector<Object>();
		Method m=null;
		try 
		{
			m=this.vettore.get(0).getClass().getMethod("get"+attributo);
		} 
		catch (NoSuchMethodException | SecurityException e)
		{
			e.printStackTrace();
		}
		for (int i=0; i<vettore.size(); i++)
		{
			double temp=0;
			try 
			{
				temp = (double) m.invoke(vettore.get(i));
			} 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
			{
				e.printStackTrace();
			}
			if (Segno(segno,temp,valore))
				vettoreOut.add(vettore.get(i));
		}
		return vettoreOut;
	}
	private boolean Segno(String segno,double val, double...valore)
	{
		switch(segno)
		{
		case "$gt":
			if(val>valore[0])
				return true;
			else
				return false;
		case "$gte":
			if(val>=valore[0])
				return true;
			else
				return false;
		case "$it":
			if(val<valore[0])
				return true;
			else
				return false;
		case "$ite":
			if(val<=valore[0])
				return true;
			else
				return false;
		case "$bt":
			if((valore[0]<=val)&&(valore[1]>=val))
				return true;
			else
				return false;
		}
		return false;
	}		
}
