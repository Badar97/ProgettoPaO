package dataset;

public class Permanenza extends ProntoSoccorso
{
	private double MedianaTempoDiPermanenza;
	private double BrevePermanenza;
	private double MediaPermanenza;
	private double LungaPermanenza;
	
	Permanenza(String NomeStruttura,String Comune)
	{
		super(NomeStruttura, Comune);
	}
	public void setPermanenza(double MedianaTempoDiPermanenza) 
	{
		this.MedianaTempoDiPermanenza=MedianaTempoDiPermanenza;
	}
	public void setPermanenza(double BrevePermanenza,double MediaPermanenza,double LungaPermanenza) 
	{
		this.BrevePermanenza=BrevePermanenza;
		this.MediaPermanenza=MediaPermanenza;
		this.LungaPermanenza=LungaPermanenza;
	}
	public double getPermanenza() 
	{
		return MedianaTempoDiPermanenza;
	}
	public double getBrevePermanenza() 
	{
		return BrevePermanenza;
	}
	public double getMediaPermanenza() 
	{
		return MediaPermanenza;
	}
	public double getLungaPermanenza() 
	{
		return LungaPermanenza;
	}
	@Override
	public String toString()
	{
		String Descrizione;
		Descrizione=super.toString()+"Mediana tempo di permanenza="+MedianaTempoDiPermanenza
				+";\nIl "+BrevePermanenza+"% dei pazienti resta nel pronto soccorso per meno di 12 ore."
				+ "\nIl "+MediaPermanenza+"% dei pazienti resta nel pronto soccorso tra le 12 ore e le 48 ore."
				+"\nIl "+LungaPermanenza+"% dei pazienti resta nel pronto soccorso per più di 48 ore.";
				return Descrizione;		
	}
	@Override
	public boolean equals(Object obj) 
	{
		Permanenza temp=(Permanenza)obj;
		if((MedianaTempoDiPermanenza==temp.getPermanenza())&&(BrevePermanenza==temp.getBrevePermanenza())&&
				(MediaPermanenza==temp.getMediaPermanenza())&&(LungaPermanenza==temp.getLungaPermanenza()))
			return true;
		else
			return false;
	}
}
