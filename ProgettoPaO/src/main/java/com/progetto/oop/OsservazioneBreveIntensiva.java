package com.progetto.oop;

public class OsservazioneBreveIntensiva extends Permanenza implements Statistiche
{
	private double PermanenzaObi;
	private String Descrizione;
	
	OsservazioneBreveIntensiva(String NomeStruttura,String Comune,String Regione)
	{
		super(NomeStruttura, Comune, Regione);
	}
	public void setPermanenzaObi(double PermanenzaObi) 
	{
		this.PermanenzaObi=PermanenzaObi;
	}
	public double getPermanenzaObi() 
	{
		return PermanenzaObi;
	}
	@Override
	public String toString()
	{
		if(PermanenzaObi<0.000001)
			Descrizione=super.toString()+"\nIl pronto soccorso non prevede la permanenza dei pazienti in osservazione breve intensiva.";
		else
			Descrizione=super.toString()+"\nIl "+PermanenzaObi+"% dei pazienti ricoverati nel pronto soccorso sono stati in osservazione breve intensiva.";
				return Descrizione;		
	}
}
