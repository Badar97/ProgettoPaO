package com.progetto.oop;

public class Parola
{
	private String parola;
	private int occorrenze;
	Parola(String parola)
	{
		this.parola=parola;
		occorrenze=1;
	}
	String getParola()
	{
		return parola;	
	}
	int getOccorrenze()
	{
		return occorrenze;
	}
	void incrementaOccorrenze()
	{
		this.occorrenze++;
	}
}
