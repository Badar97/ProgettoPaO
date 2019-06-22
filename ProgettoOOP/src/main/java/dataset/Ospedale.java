package dataset; 
/**
 * La classe modella alcune caratteristiche di un ospedale.
 */
public class Ospedale 
{
	private String NomeStruttura;
	private String Comune;
	/**
	 * @param NomeStruttura Nome dell'ospedale
	 * @param Comune Nome del comune in cui è situato l'ospedale
	 */
	Ospedale(String NomeStruttura,String Comune) 
	{
		this.NomeStruttura=NomeStruttura;
		this.Comune=Comune;
	}
	/**
	 * @return Il metodo restituisce il nome dell'ospedale
	 */
	public String getNomeStruttura() 
	{
		return NomeStruttura;
	}
	/**
	 * @return Il metodo restituisce il nome del comune in cui è situato l'ospedale
	 */
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
