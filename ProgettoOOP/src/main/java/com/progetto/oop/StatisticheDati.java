package com.progetto.oop;

import java.util.Vector;

public class StatisticheDati implements Statistiche
{
	private Object vettore;
	private double media;
	private double minimo;
	private double massimo;
	private double deviazione_standard;
	private double somma;
	private int count;
	private Vector<Parola> parole;
	public StatisticheDati(Object vettore)
	{
		this.vettore=vettore;
		Somma();
		Count();
		Media();
		Minimo();
		Massimo();
		DeviazioneStandard();
	}
	@Override
	public void Media() 
	{
		media=somma/count;
	}

	@Override
	public void Minimo() 
	{
		double vettore[]=(double[])this.vettore;
		double min=vettore[0];
		for(int i=0;i<vettore.length;i++)
		{
			if(vettore[i]<min)
				min=vettore[i];
		}
		minimo=min;
	}

	@Override
	public void Massimo() 
	{
		double vettore[]=(double[])this.vettore;
		double max=vettore[0];
		for(int i=0;i<vettore.length;i++)
		{
			if(vettore[i]>max)
				max=vettore[i];
		}
		massimo=max;
	}

	@Override
	public void DeviazioneStandard()
	{
		double vettore[]=(double[])this.vettore;
		double varianza=0;
		for(int i=0;i<vettore.length;i++)
		{
			varianza+=(vettore[i]-media)*(vettore[i]-media);
		}
		deviazione_standard=Math.sqrt(varianza/count);
	}

	@Override
	public void Somma()
	{
		double vettore[]=(double[])this.vettore;
		double somma=0;
		for(int i=0;i<vettore.length;i++)
		{
			somma+=vettore[i];
		}
		this.somma=somma;
	}

	@Override
	public void Count()
	{
		double vettore[]=(double[])this.vettore;
		int i;
		for(i=0;i<vettore.length;i++);
		count=i;
	}

	@Override
	public void Occorrenze() 
	{
		String vettore[]=(String[])this.vettore;
		boolean flag;
		Vector<Parola> parole = new Vector<Parola>();
		parole.add(new Parola(vettore[0]));
		for(int i=1,j;i<vettore.length;i++)
		{
			flag=false;
			j=0;
			while(!flag)
			{
				if(vettore[i]==parole.get(j).getParola())
				{
					parole.get(j).incrementaOccorrenze();
					flag=true;
				}
				j++;
			}
			if(!flag)
				parole.add(new Parola(vettore[i]));
		}
		this.parole=parole;
	}	
	public double getMedia()
	{
		return media;
	}
	public double getMinimo()
	{
		return minimo;
	}
	public double getMassimo()
	{
		return massimo;
	}
	public double getDeviazioneStandard()
	{
		return deviazione_standard;
	}
	public double getSomma()
	{
		return somma;
	}
	public int getCount()
	{
		return count;
	}
	public Vector<Parola> getOccorrenze()
	{
		return parole;
	}
}