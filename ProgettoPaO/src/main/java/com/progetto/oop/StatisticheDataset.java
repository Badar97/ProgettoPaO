package com.progetto.oop;

import java.util.Vector;

public class StatisticheDataset
{
	private Vector<?> vettore;
	public StatisticheDataset(Vector<?> vettore)
	{
		this.vettore=vettore;
	}
	private Object toArray(String attributo) 
	{
		switch(attributo)
		{
			case "Nome struttura":
				if(this.vettore.get(0) instanceof Ospedale )
				{
					String vettore[]=new String[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((Ospedale) this.vettore.get(i)).getNomeStruttura();
					}
					return vettore;
				}
				break;
			case "Comune":
				if(this.vettore.get(0) instanceof Ospedale )
				{
					String vettore[]=new String[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((Ospedale) this.vettore.get(i)).getComune();
					}
					return vettore;
				}
				break;
			case "Regione":
				if(this.vettore.get(0) instanceof Ospedale )
				{
					String vettore[]=new String[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((Ospedale) this.vettore.get(i)).getRegione();
					}
					return vettore;
				}
				break;
			case "Mediana tempo di permanenza":
				if(this.vettore.get(0) instanceof Permanenza )
				{
					double vettore[]=new double[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((Permanenza) this.vettore.get(i)).getPermanenza();
					}
					return vettore;
				}
				break;
			case "Mediana tempo di attesa":
				if(this.vettore.get(0) instanceof ProntoSoccorso )
				{
					double vettore[]=new double[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((ProntoSoccorso) this.vettore.get(i)).getTempoDiAttesa();
					}
					return vettore;
				}
				break;
			case "Totale accessi":
				if(this.vettore.get(0) instanceof ProntoSoccorso )
				{
					double vettore[]=new double[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((ProntoSoccorso) this.vettore.get(i)).getTotaleAccessi();
					}
					return vettore;
				}
				break;
			case "Permanenza breve":
				if(this.vettore.get(0) instanceof Permanenza )
				{
					double vettore[]=new double[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((Permanenza) this.vettore.get(i)).getBrevePermanenza();
					}
					return vettore;
				}
				break;
			case "Permanenza media":
				if(this.vettore.get(0) instanceof Permanenza )
				{
					double vettore[]=new double[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((Permanenza) this.vettore.get(i)).getMediaPermanenza();
					}
					return vettore;
				}
				break;
			case "Permanenza lunga":
				if(this.vettore.get(0) instanceof Permanenza )
				{
					double vettore[]=new double[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((Permanenza) this.vettore.get(i)).getLungaPermanenza();
					}
					return vettore;
				}
				break;
			case "Permanenza obi":
				if(this.vettore.get(0) instanceof OsservazioneBreveIntensiva )
				{
					double vettore[]=new double[this.vettore.size()];
					for(int i=0;i<this.vettore.size();i++)
					{
						vettore[i]=((OsservazioneBreveIntensiva) this.vettore.get(i)).getPermanenzaObi();
					}
					return vettore;
				}
				break;
		}
		return null;
	}
	public StatisticheDati getStatistiche(String attributo)
	{
		Object vettore=toArray(attributo);
		StatisticheDati obj=new StatisticheDati(vettore);
		if(vettore instanceof double[])
		{
			obj.Media();
			obj.Minimo();
			obj.Massimo();
			obj.DeviazioneStandard();
			obj.Somma();
			obj.Count();
		}
		if(vettore instanceof String[])
			obj.Occorrenze();
		return obj;
	}
}
