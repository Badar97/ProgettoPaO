package dataset; 
/**
 * 
 * La classe modella una specifica caratteristica di un pronto soccorso,
 * la permanenza dei pazienti. L'attributo breve permanenza rappresenta la
 * percentuale di pazienti che restano nel pronto soccorso per meno di 12 ore.
 * L'attributo media permanenza rappresenta la percentuale di pazienti
 * che restano nel pronto soccorso per un periodo di tempo compreso tra le 12 e le 48 ore.
 * L'attributo lunga permanenza rappresenta la percentuale di pazienti 
 * che restano nel pronto soccorso per più di due giorni.
 *
 */
public class Permanenza extends ProntoSoccorso
{
	private double BrevePermanenza;
	private double MediaPermanenza;
	private double LungaPermanenza;
	/**
	 * Invoca il costruttore della super classe
	 * @param NomeStruttura nome della struttura in cui sono ricoverati i pazienti
	 * @param Comune comune dove è situata la struttura in cui sono ricoverati i pazienti
	 */
	Permanenza(String NomeStruttura,String Comune)
	{
		super(NomeStruttura, Comune);
	}
	/**
	 * Il metodo imposta le percentuali che descrivono la durata della permanenza dei pazienti ricoverati 
	 * @param BrevePermanenza percentuale di pazienti ricoverati per meno di 12 ore
	 * @param MediaPermanenza percentuale di pazienti ricoverati per un periodo tra le 12 e le 48 ore
	 * @param LungaPermanenza percentuale di pazienti ricoverati per più di due giorni
	 */
	public void setPermanenza(double BrevePermanenza,double MediaPermanenza,double LungaPermanenza) 
	{
		this.BrevePermanenza=BrevePermanenza;
		this.MediaPermanenza=MediaPermanenza;
		this.LungaPermanenza=LungaPermanenza;
	}
	/**
	 * @return restituisce la percuntuale di pazienti che resta per breve tempo nel pronto soccorso
	 */
	public double getBrevePermanenza() 
	{
		return BrevePermanenza;
	}
	/**
	 * @return restituisce la percuntuale di pazienti che resta nel pronto soccorso per più di mezza giornata e meno di due giorni
	 */
	public double getMediaPermanenza() 
	{
		return MediaPermanenza;
	}
	/**
	 * @return restituisce la percuntuale di pazienti che resta per più di due giorni nel pronto soccorso
	 */
	public double getLungaPermanenza() 
	{
		return LungaPermanenza;
	}
	@Override
	public String toString()
	{
		String Descrizione;
		Descrizione=super.toString()+"Il "+BrevePermanenza+"% dei pazienti resta nel pronto soccorso per meno di 12 ore."
				+ "\nIl "+MediaPermanenza+"% dei pazienti resta nel pronto soccorso tra le 12 ore e le 48 ore."
				+"\nIl "+LungaPermanenza+"% dei pazienti resta nel pronto soccorso per più di 48 ore.";
				return Descrizione;		
	}
	@Override
	public boolean equals(Object obj) 
	{
		Permanenza temp=(Permanenza)obj;
		if((BrevePermanenza==temp.getBrevePermanenza())&&(MediaPermanenza==temp.getMediaPermanenza())
				&&(LungaPermanenza==temp.getLungaPermanenza()))
			return true;
		else
			return false;
	}
}
