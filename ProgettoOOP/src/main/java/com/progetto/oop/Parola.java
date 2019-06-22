package com.progetto.oop;

public class Parola
{
	private String parola;
	private int occorrenze;
	public Parola(String parola)
	{
		this.parola=parola;
		occorrenze=1;
	}
	public String getParola()
	{
		return parola;	
	}
	int getOccorrenze()
	{
		return occorrenze;
	}
	public void incrementaOccorrenze()
	{
		this.occorrenze++;
	}
}
