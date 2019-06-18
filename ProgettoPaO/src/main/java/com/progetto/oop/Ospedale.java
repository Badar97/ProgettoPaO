package com.progetto.oop;

public class Ospedale 
{
	private String NomeStruttura;
	private String Comune;
	private String Regione;
	private String Descrizione;
	
	Ospedale(String NomeStruttura,String Comune, String Regione) 
	{
		this.NomeStruttura=NomeStruttura;
		this.Comune=Comune;
		this.Regione=Regione;
	}
	public String getNomeStruttura() 
	{
		return NomeStruttura;
	}
	public String getComune() 
	{
		return Comune;
	}
	public String getRegione() 
	{
		return Regione;
	}
	@Override
	public String toString()
	{
		Descrizione="NomeStruttura="+NomeStruttura+";\nComune="+Comune+";\nRegione="+Regione+";\n";
		return Descrizione;		
	}
}
