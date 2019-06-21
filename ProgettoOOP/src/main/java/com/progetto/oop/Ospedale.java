package com.progetto.oop;

import java.lang.reflect.Field;

public class Ospedale extends Metadata
{
	private String NomeStruttura;
	private String Comune;
	private String Regione;
	
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
		String Descrizione;
		Descrizione="NomeStruttura="+NomeStruttura+";\nComune="+Comune+";\nRegione="+Regione+";\n";
		return Descrizione;		
	}
	@Override
	public boolean equals(Object obj) 
	{
		Ospedale temp=(Ospedale)obj;
		if((NomeStruttura==temp.getNomeStruttura())&&(Comune==temp.getComune())&&(Regione==temp.getRegione()))
			return true;
		else
			return false;
	}
	@Override
	public Field[] getCampi()
	{
		return this.getClass().getFields();
	}
}
