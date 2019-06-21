package com.progetto.oop;

import java.lang.reflect.Field;

public class ProntoSoccorso extends Ospedale
{
	private int TotaleAccessi;
	private double MedianaTempoDiAttesa;
	
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
		String Descrizione;
		Descrizione=super.toString()+"Totale accesi="+TotaleAccessi+";\nMediana tempo di attesa="+MedianaTempoDiAttesa+";\n";
		return Descrizione;		
	}
	@Override
	public boolean equals(Object obj) 
	{
		ProntoSoccorso temp=(ProntoSoccorso)obj;
		if((TotaleAccessi==temp.getTotaleAccessi())&&(MedianaTempoDiAttesa==temp.getTempoDiAttesa()))
			return true;
		else
			return false;
	}	
	@Override
	public Field[] getCampi()
	{
		Field FieldsSuper[]=super.getCampi();
		Field FieldsThis[]=this.getClass().getDeclaredFields();
		Field Fields[]=new Field[FieldsSuper.length+FieldsThis.length];
		for(int i=0;i<(FieldsSuper.length+FieldsThis.length);i++)
		{
			if(i<FieldsSuper.length)
				Fields[i]=FieldsSuper[i];
			else
				Fields[i]=FieldsThis[i-FieldsSuper.length];
		}
		if(this.getClass().getSuperclass().getName().equals("Metadata"))
			Fields=this.getClass().getFields();
		System.out.println("Ok");
		return Fields;
	}
}
