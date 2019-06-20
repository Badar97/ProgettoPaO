package com.progetto.oop;

import java.util.Vector;

public class OperatoreLogico
{
	Vector<Object> vettoreOut;
	public OperatoreLogico(String Operatore,Vector<Object> vettore1,Vector<Object> vettore2)
	{
		switch(Operatore)
		{
		case "$and":
			and(vettore1,vettore2);
			break;
		case "$or":
			or(vettore1,vettore2);
			break;
		}
	}
	public OperatoreLogico(String Operatore,Vector<Object> vettore)
	{
		if(Operatore=="$not")
			not(vettore);
	}
	private void and(Vector<Object> vettore1,Vector<Object> vettore2)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore1.size();i++)
		{
			Object temp=vettore1.get(i);
			if(contains(vettore2,temp))
				vettoreOut.add(temp);
		}
	}
	private void or(Vector<Object> vettore1,Vector<Object> vettore2)
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
	}
	public void not(Vector<Object> vettore)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore.size();i++)
		{
			Object temp=vettore.get(i);
			if(!contains(vettore,temp))
				vettoreOut.add(temp);
		}
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
	/*public Vector<Object> Uguale(String attributo,double valore)
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
						if (temp==valore)
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
						if (temp==valore)
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
						if (temp==valore)
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
						if (temp==valore)
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
						if (temp==valore)
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
			case "Permanenza lunga":
				if(this.vettore.get(0) instanceof Permanenza) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						Permanenza obj=(Permanenza)vettore.get(i);
						double temp=obj.getLungaPermanenza();
						if (temp==valore)
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break;
				
			case "Permanenza obi":
				if(this.vettore.get(0) instanceof OsservazioneBreveIntensiva) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						OsservazioneBreveIntensiva obj=(OsservazioneBreveIntensiva)vettore.get(i);
						double temp=obj.getPermanenzaObi();
						if (temp==valore)
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
		}
		return null;
	}
	public Vector<Object> Uguale(String attributo,String stringa)
	{
		vettoreOut=new Vector<Object>();
		switch(attributo)
		{
			
			case "Nome Struttura":
				if(this.vettore.get(0) instanceof Ospedale) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						Ospedale obj=(Ospedale)vettore.get(i);
						String temp=obj.getNomeStruttura();
						if (temp==stringa)
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break; 
				
			case "Comune":
				if(this.vettore.get(0) instanceof Ospedale) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						Ospedale obj=(Ospedale)vettore.get(i);
						String temp=obj.getComune();
						if (temp.equals(stringa))
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break;
				
			case "Regione":
				if(this.vettore.get(0) instanceof Ospedale) 
				{
					for (int i=0; i<vettore.size(); i++)
					{
						Ospedale obj=(Ospedale)vettore.get(i);
						String temp=obj.getRegione();
						if (temp==stringa)
							vettoreOut.add(obj);
					}
					return vettoreOut;
				}
				break;
		}
		return vettoreOut;
	}*/
}
