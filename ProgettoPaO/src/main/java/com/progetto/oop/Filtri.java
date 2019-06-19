package com.progetto.oop;

import java.util.Vector;

public class Filtri {
	Vector<?> vettore;
	Vector<Object> vettoreOut=new Vector<Object>();
	
	public Filtri(Vector<?> vettore)
	{
		this.vettore = vettore;
	}

	public Vector<Object> OperatoreCond(String segno, String attributo, double...valore) 
	{
		vettoreOut=new Vector<Object>();
		switch(attributo)
		{
			
			case "Mediana tempo di permanenza":
				if(this.vettore.get(0) instanceof Permanenza) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						Permanenza obj=(Permanenza)vettore.get(i);
						double temp=obj.getPermanenza();
						if (Segno(segno,temp,valore))
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
			case "Mediana tempo di attesa":
				if(this.vettore.get(0) instanceof ProntoSoccorso) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						ProntoSoccorso obj=(ProntoSoccorso)vettore.get(i);
						double temp=obj.getTempoDiAttesa();
						if (Segno(segno,temp,valore))
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
			case "Totale accessi":
				if(this.vettore.get(0) instanceof ProntoSoccorso) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						ProntoSoccorso obj=(ProntoSoccorso)vettore.get(i);
						double temp=obj.getTotaleAccessi();
						if (Segno(segno,temp,valore))
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
			case "Permanenza breve":
				if(this.vettore.get(0) instanceof Permanenza) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						Permanenza obj=(Permanenza)vettore.get(i);
						double temp=obj.getBrevePermanenza();
						if (Segno(segno,temp,valore))
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
			case "Permanenza media":
				if(this.vettore.get(0) instanceof Permanenza) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						Permanenza obj=(Permanenza)vettore.get(i);
						double temp=obj.getMediaPermanenza();
						if (Segno(segno,temp,valore))
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
			case "Permanenza lunga":
				if(this.vettore.get(0) instanceof Permanenza) 
					for (int i=0; i<vettore.size(); i++)
					{
						Permanenza obj=(Permanenza)vettore.get(i);
						double temp=obj.getLungaPermanenza();
						if (Segno(segno,temp,valore))
							vettoreOut.add(obj);
					}
				break;
				
			case "Permanenza obi":
				if(this.vettore.get(0) instanceof OsservazioneBreveIntensiva) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						OsservazioneBreveIntensiva obj=(OsservazioneBreveIntensiva)vettore.get(i);
						double temp=obj.getPermanenzaObi();
						if (Segno(segno,temp,valore))
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
		}
		return null;
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
	public Vector<Object> and(Vector<Object> vettore1,Vector<Object> vettore2)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore1.size();i++)
		{
			Object temp=vettore1.get(i);
			if(contains(vettore2,temp))
				vettoreOut.add(temp);
		}
		return vettoreOut;	
	}
	public Vector<Object> or(Vector<Object> vettore1,Vector<Object> vettore2)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore1.size();i++)
		{
			Object temp=vettore1.get(i);
			vettoreOut.add(temp);
		}
		for(int i=0;i<vettore2.size();i++)
		{
			Object temp=vettore2.get(i);
			if(!contains(vettoreOut,temp))
				vettoreOut.add(temp);
		}
		return vettoreOut;	
	}
	public Vector<Object> not(Vector<Object> vettore)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore.size();i++)
		{
			Object temp=this.vettore.get(i);
			if(!contains(vettore,temp))
				vettoreOut.add(temp);
		}
		return vettoreOut;	
	}
	private boolean contains(Vector<Object> vettore,Object obj)
	{
		if((obj instanceof Ospedale)&&!(obj instanceof ProntoSoccorso)&&!(obj instanceof Permanenza)&&!
				(obj instanceof OsservazioneBreveIntensiva))
		{
			Ospedale temp=(Ospedale) obj;
			for(int i=0;i<vettore.size();i++)
			{
				if(vettore.get(i)==temp)
					return true;
			}
			return false;
		}
		if((obj instanceof ProntoSoccorso)&&!(obj instanceof Permanenza)&&!
				(obj instanceof OsservazioneBreveIntensiva))
		{
			ProntoSoccorso temp=(ProntoSoccorso) obj;
			for(int i=0;i<vettore.size();i++)
			{
				if(vettore.get(i)==temp)
					return true;
			}
			return false;
		}
		if((obj instanceof Permanenza)&&!(obj instanceof OsservazioneBreveIntensiva))
		{
			Permanenza temp=(Permanenza) obj;
			for(int i=0;i<vettore.size();i++)
			{
				if(temp==vettore.get(i))
					return true;
			}
			return false;
		}
		if(obj instanceof OsservazioneBreveIntensiva)
		{
			OsservazioneBreveIntensiva temp=(OsservazioneBreveIntensiva) obj;
			for(int i=0;i<vettore.size();i++)
			{
				if(vettore.get(i)==temp)
					return true;
			}
			return false;
		}
		return false;
	}
	public void test()
	{
		Vector<Object> test=not(OperatoreCond("$e","Permanenza media",3.58));
		System.out.println(test.size());
		for(int i=0;i<test.size();i++)
		{
			System.out.println(test.get(i));
		}
	}
}
