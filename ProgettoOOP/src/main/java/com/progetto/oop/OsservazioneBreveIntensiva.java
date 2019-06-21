package com.progetto.oop;

public class OsservazioneBreveIntensiva extends Permanenza 
{
	private double PermanenzaObi;
	
	OsservazioneBreveIntensiva(String NomeStruttura,String Comune)
	{
		super(NomeStruttura, Comune);
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
		String Descrizione;
		if(PermanenzaObi<0.000001)
			Descrizione=super.toString()+"\nIl pronto soccorso non prevede la permanenza dei pazienti in osservazione breve intensiva.";
		else
			Descrizione=super.toString()+"\nIl "+PermanenzaObi+"% dei pazienti ricoverati nel pronto soccorso sono stati in osservazione breve intensiva.";
				return Descrizione;		
	}
	@Override
	public boolean equals(Object obj) 
	{
		OsservazioneBreveIntensiva temp=(OsservazioneBreveIntensiva)obj;
		if(PermanenzaObi==temp.getPermanenzaObi())
			return true;
		else
			return false;
	}
}
