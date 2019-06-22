package dataset; 
/**
 * 
 *La classe modella una specifica caratteristica di un pronto soccorso,
 *la permanenza dei pazienti in osservazione breve intensiva. L'attributo PermanenzaObi
 *rappresenta la percentuale dei pazienti con malattie che non necessitano di ricovero immediato,
 *ma di una terapia con osservazione e di un approfondimento diagnostico
 */
public class OsservazioneBreveIntensiva extends Permanenza 
{
	private double PermanenzaObi;
	/**
	 * Invoca il costruttore della super classe
	 * @param NomeStruttura nome della struttura in cui i pazienti sono in osservazione
	 * @param Comune comune dove è situata la struttura in cui i pazienti sono in osservazione
	 */
	public OsservazioneBreveIntensiva(String NomeStruttura,String Comune)
	{
		super(NomeStruttura, Comune);
	}
	/**
	 * Il metodo imposta la percentuale dei pazienti in osservazione
	 * @param PermanenzaObi percentuale dei pazienti in osserrvazione
	 */
	public void setPermanenzaObi(double PermanenzaObi) 
	{
		this.PermanenzaObi=PermanenzaObi;
	}
	/**
	 * @return restituisce la percentuale di pazienti in osservazione
	 */
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
