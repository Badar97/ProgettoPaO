package filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

public class Filtro
{
	private Vector<Object> vettore;
	private Vector<Object> vettoreOut;
	public Filtro(Vector<Object> vettore,String filtro)
	{
		this.vettore=vettore;
		if(filtro.contains("$and")||filtro.contains("$or")||filtro.contains("$not"))
			vettoreOut=OttieniFiltroLogico(filtro);
		else
			vettoreOut=OttieniFiltroCondizionale(filtro);
	}
	private Vector<Object> OttieniFiltroCondizionale(String filtro)
	{
		String attributo;
		String segno;
		String valore;
		filtro=filtro.replace("{","");
		filtro=filtro.replace("}","");
		filtro=filtro.replace("\"","");
		filtro=filtro.replace(" ","");
		String vettore[]=filtro.split(":");
		attributo=vettore[0];
		segno=vettore[1];
		valore=vettore[2];
		OperatoreCondizionale filter=new OperatoreCondizionale(this.vettore);
		if(segno.equals("$bt"))
		{
			valore=valore.replace("(","");
			valore=valore.replace(")","");
			vettore=valore.split(",");
			String valoreMin=vettore[0];
			String valoreMax=vettore[1];
			return filter.Confronto(segno,attributo,Double.parseDouble(valoreMin),Double.parseDouble(valoreMax));
		}
		else
			return filter.Confronto(segno,attributo,Double.parseDouble(valore));
	}
	private Vector<Object> OttieniFiltroLogico(String filtro)
	{
		Vector<Object> vettore1;
		Vector<Object> vettore2;
		String segno;
		filtro=filtro.replace("(","%");
		String vettore[]=filtro.split("%");
		segno=vettore[0];
		segno=segno.replace("{","");
		segno=segno.replace(":","");
		segno=segno.replace("\"","");
		segno=segno.replace(" ","");
		filtro=vettore[1];
		if(segno.equals("$not"))
		{
			OperatoreLogico filter=new OperatoreLogico();
			return filter.Confronto(segno,OttieniFiltroUguaglianza(filtro));
		}
		filtro=filtro.replace(")","");
		vettore=filtro.split(",");
		if(vettore[0].contains("$"))
			vettore1=OttieniFiltroCondizionale(vettore[0]);
		else
			vettore1=OttieniFiltroUguaglianza(vettore[0]);
		if(vettore[1].contains("$"))
			vettore2=OttieniFiltroCondizionale(vettore[1]);
		else
			vettore2=OttieniFiltroUguaglianza(vettore[1]);
		OperatoreLogico filter=new OperatoreLogico();
		return filter.Confronto(segno,vettore1,vettore2);
	}
	private Vector<Object> OttieniFiltroUguaglianza(String filtro)
	{
		System.out.println(filtro);
		Vector<Object> vettoreOut=new Vector<Object>();
		String attributo;
		String valore;
		filtro=filtro.replace("{","");
		filtro=filtro.replace("}","");
		filtro=filtro.replace("\"","");
		filtro=filtro.replace(" ","");
		String vettore[]=filtro.split(":");
		attributo=vettore[0];
		valore=vettore[1];
		System.out.println(attributo);
		System.out.println(valore);
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
				if(m.invoke(this.vettore.get(i)).equals(valore))
					vettoreOut.add(this.vettore.get(i));
			} 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
			{
				e.printStackTrace();
			} 
		}
		return vettoreOut;
	}
	public Vector<Object> getData()
	{
		return vettoreOut;
	}
}
