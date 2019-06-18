package com.progetto.oop;

public class ProntoSoccorso extends Ospedale implements Statistiche
{
	private int TotaleAccessi;
	private double MedianaTempoDiAttesa;
	private String Descrizione;
	
	ProntoSoccorso(String NomeStruttura,String Comune,String Regione) 
	{
		super(NomeStruttura, Comune, Regione);		
	}
	public void setTotaleAccessi(int TotaleAccessi) 
	{
		this.TotaleAccessi=TotaleAccessi;
	}
	
	public void setTempoDiAttesa(double MedianaTempoDiAttesa) 
	{
		this.MedianaTempoDiAttesa=MedianaTempoDiAttesa;
	}
	public int getTotaleAccessi() 
	{
		return TotaleAccessi;
	}
	public double getTempoDiAttesa() 
	{
		return MedianaTempoDiAttesa;
	}
	@Override
	public String toString()
	{
		Descrizione=super.toString()+"Totale accesi="+TotaleAccessi+";\nMediana tempo di attesa="+MedianaTempoDiAttesa+";\n";
		return Descrizione;		
	}
	@Override
	public double Media(Object o)
	{
		return 0;
	}
	@Override
	public double Minimo(Object o) 
	{
		return 0;
	}
	@Override
	public double Massimo(Object o) 
	{
		return 0;
	}
	@Override
	public double Somma(Object o) 
	{
		return 0;
	}
	@Override
	public double DeviazioneStandard(Object o)
	{
		return 0;
	}
	@Override
	public double Count(Object o) 
	{
		return 0;
	}
}
