package com.progetto.oop;

import java.util.ArrayList;
import java.util.Vector;

public class StatisticheDati implements Statistiche
{
	private Double ArrayNumber[];
	private String ArrayString[];
	private double media;
	private double minimo;
	private double massimo;
	private double deviazione_standard;
	private double somma;
	private int count;
	private Vector<Parola> parole;
	public StatisticheDati(ArrayList<Object> vettore)
	{
		if(vettore.get(0) instanceof Double)
		{
			ArrayNumber=vettore.toArray(new Double[vettore.size()]);
			Somma();
			Count();
			Media();
			DeviazioneStandard();
			Minimo();
			Massimo();
		}
		if(vettore.get(0) instanceof String)
		{
			ArrayString=vettore.toArray(new String[vettore.size()]);
			Occorrenze();
		}
	}
	@Override
	public void Media() 
	{
		media=somma/count;
	}

	@Override
	public void Minimo() 
	{
		double min=ArrayNumber[0];
		for(int i=0;i<ArrayNumber.length;i++)
		{
			if(ArrayNumber[i]<min)
				min=ArrayNumber[i];
		}
		minimo=min;
	}

	@Override
	public void Massimo() 
	{
		double max=ArrayNumber[0];
		for(int i=0;i<ArrayNumber.length;i++)
		{
			if(ArrayNumber[i]>max)
				max=ArrayNumber[i];
		}
		massimo=max;
	}

	@Override
	public void DeviazioneStandard()
	{
		double varianza=0;
		for(int i=0;i<ArrayNumber.length;i++)
		{
			varianza+=(ArrayNumber[i]-media)*(ArrayNumber[i]-media);
		}
		deviazione_standard=Math.sqrt(varianza/count);
	}

	@Override
	public void Somma()
	{
		double somma=0;
		for(int i=0;i<ArrayNumber.length;i++)
		{
			somma+=ArrayNumber[i];
		}
		this.somma=somma;
	}

	@Override
	public void Count()
	{
		int i;
		for(i=0;i<ArrayNumber.length;i++);
		count=i;
	}

	@Override
	public void Occorrenze() 
	{
		boolean flag;
		Vector<Parola> parole = new Vector<Parola>();
		parole.add(new Parola(ArrayString[0]));
		for(int i=1,j;i<ArrayString.length;i++)
		{
			flag=false;
			j=0;
			while(!flag)
			{
				if(ArrayString[i]==parole.get(j).getParola())
				{
					parole.get(j).incrementaOccorrenze();
					flag=true;
				}
				j++;
			}
			if(!flag)
				parole.add(new Parola(ArrayString[i]));
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