package dataset;

public class Ospedale 
{
	private String NomeStruttura;
	private String Comune;
	
	Ospedale(String NomeStruttura,String Comune) 
	{
		this.NomeStruttura=NomeStruttura;
		this.Comune=Comune;
	}
	public String getNomeStruttura() 
	{
		return NomeStruttura;
	}
	public String getComune() 
	{
		return Comune;
	}
	@Override
	public String toString()
	{
		String Descrizione;
		Descrizione="NomeStruttura="+NomeStruttura+";\nComune="+Comune+";\nRegione=Lazio\n";
		return Descrizione;		
	}
	@Override
	public boolean equals(Object obj) 
	{
		Ospedale temp=(Ospedale)obj;
		if((NomeStruttura==temp.getNomeStruttura())&&(Comune==temp.getComune()))
			return true;
		else
			return false;
	}
}
