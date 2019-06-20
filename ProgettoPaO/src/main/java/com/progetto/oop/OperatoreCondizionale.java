package com.progetto.oop;

import java.util.Vector;

public class OperatoreCondizionale
{
	Vector<?> vettore;
	Vector<Object> vettoreOut;
	public OperatoreCondizionale(Vector<Object> vettore)
	{
		this.vettore=vettore;
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
				{
					for (int i=0; i<vettore.size(); i++)
					{
						Permanenza obj=(Permanenza)vettore.get(i);
						double temp=obj.getLungaPermanenza();
						if (Segno(segno,temp,valore))
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
}
