package dataset; 
/**
 * 
 * La classe modella alcune caratteristiche di un pronto soccorso come il numero degli accessi,
 * il tempo di permanenza dei pazienti e il tempo di attesa prima di essere visitati
 *
 */
public class ProntoSoccorso extends Ospedale
{
	private double TotaleAccessi;
	private double Permanenza;
	private double TempoDiAttesa;
	/**
	 * Invoca il costruttore della super classe
	 * @param NomeStruttura Nome dell'ospedale
	 * @param Comune Nome del comune in cui è situato l'ospedale
	 */
	ProntoSoccorso(String NomeStruttura,String Comune) 
	{
		super(NomeStruttura, Comune);		
	}
	/**
	 * Imposta il numero degli accessi al pronto soccorso
	 * @param d numero totale di accessi al pronto soccorso
	 */
	public void setTotaleAccessi(double d) 
	{
		this.TotaleAccessi=d;
	}
	/**
	 * Imposta un indicatore del tempo di attesa
	 * @param MedianaTempoDiAttesa mediana del tempo di attesa nel pronto soccorso
	 */
	public void setTempoDiAttesa(double TempoDiAttesa) 
	{
		this.TempoDiAttesa=TempoDiAttesa;
	}
	/**
	 * Imposta un indicatore del tempo di permanenza
	 * @param MedianaTempoDiPermanenza mediana del tempo di permanenza nel pronto soccorso
	 */
	public void setPermanenza(double Permanenza) 
	{
		this.Permanenza=Permanenza;
	}
	/**
	 * @return restituisce il numero degli accessi al rponto soccorso
	 */
	public double getTotaleAccessi() 
	{
		return TotaleAccessi;
	}
	/**
	 * @return restituisce un indicatore del tempo di attesa
	 */
	public double getTempoDiAttesa() 
	{
		return TempoDiAttesa;
	}
	/**
	 * @return restituisce un indicatore del tempo di permanenza
	 */
	public double getPermanenza() 
	{
		return Permanenza;
	}
	@Override
	public String toString()
	{
		String Descrizione;
		Descrizione=super.toString()+"Mediana tempo di permanenza="+Permanenza+
				";\nTotale accesi="+TotaleAccessi+";\nMediana tempo di attesa="+TempoDiAttesa+";\n";
		return Descrizione;		
	}
	@Override
	public boolean equals(Object obj) 
	{
		ProntoSoccorso temp=(ProntoSoccorso)obj;
		if((Permanenza==temp.getPermanenza())&&(TotaleAccessi==temp.getTotaleAccessi())
				&&(TempoDiAttesa==temp.getTempoDiAttesa()))
			return true;
		else
			return false;
	}	
}
