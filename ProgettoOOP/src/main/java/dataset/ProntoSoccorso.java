package dataset;

public class ProntoSoccorso extends Ospedale
{
	private int TotaleAccessi;
	private double MedianaTempoDiAttesa;
	
	ProntoSoccorso(String NomeStruttura,String Comune) 
	{
		super(NomeStruttura, Comune);		
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
}
