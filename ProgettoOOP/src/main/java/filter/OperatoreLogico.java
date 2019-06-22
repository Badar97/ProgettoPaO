package filter; 

import java.util.Vector;

import dataset.Ospedale;
import dataset.OsservazioneBreveIntensiva;
import dataset.Permanenza;
import dataset.ProntoSoccorso;
/**
 * 
 *La classe si occupa di effettuare operazioni logiche tra vettori
 *
 */
public class OperatoreLogico
{
	private Vector<Object> vettoreOut;
	/**
	 * Il metodo seleziona la funzione logica adatta in relazione all'operatore passato per parametro
	 * @param Operatore operatore logico
	 * @param vettore1 argomento della funzione logica
	 * @param vettore2 argomento della funzione logica
	 * @return restituisce il risultato dell'operazione logica
	 */
	public Vector<Object> Confronto(String Operatore,Vector<Object> vettore1,Vector<Object> vettore2)
	{
		switch(Operatore)
		{
		case "$and":
			and(vettore1,vettore2);
			break;
		case "$or":
			or(vettore1,vettore2);
			break;
		}
		return vettoreOut;
	}
	/**
	 * Il metodo seleziona la funzione logica adatta in relazione all'operatore passato per parametro
	 * @param Operatore operatore logico
	 * @param vettore1 argomento della funzione logica
	 * @return restituisce il risultato dell'operazione logica
	 */
	public Vector<Object> Confronto(String Operatore,Vector<Object> vettore)
	{
		if(Operatore=="$not")
			not(vettore);
		return vettoreOut;
	}
	/**
	 * Funzione logica and. Ottiene come risultato un vettore contenente l'intersezione tra i vettori passati come argomenti.
	 * Il vettore risultante contiene gli elementi in comune tra i i due vettori
	 * @param vettore1 argomento della funzione logica
	 * @param vettore2 argomento della funzione logica
	 */
	private void and(Vector<Object> vettore1,Vector<Object> vettore2)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore1.size();i++)
		{
			Object temp=vettore1.get(i);	//temp diventa un riferimento a un elemento del vettore 1
			if(contains(vettore2,temp))	//Se vettore 2 contiene temp, temp viene aggiiunto al vettore in uscita
				vettoreOut.add(temp);
		}
	}
	/**
	 * Funzione logica or. Ottiene come risultato un vettore contenente l'unione tra i vettori passati come argomenti.
	 * Il vettore risultante contiene l'unione degli elementi presenti nei due vettori
	 * @param vettore1 argomento della funzione logica
	 * @param vettore2 argomento della funzione logica
	 */
	private void or(Vector<Object> vettore1,Vector<Object> vettore2)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore1.size();i++)
		{
			Object temp=vettore1.get(i);
			vettoreOut.add(temp);	//Aggiunge gli elementi del primo vettore al vettore in uscita
		}
		for(int i=0;i<vettore2.size();i++)
		{
			Object temp=vettore2.get(i);
			if(!contains(vettoreOut,temp))	//Se l'elemento a cui fa riferimento temp non è contenuto nel vettore in uscita viene aggiunto
				vettoreOut.add(temp);
		}	
	}
	/**
	 * Funzione logica not. Ottiene come risultato un vettore complementare a quello passato come argomento.
	 * Il vettore risultante contiene gli elementi del dataset che non sono presenti nel vettore passato per argomento
	 * @param vettore1 argomento della funzione logica
	 */
	public void not(Vector<Object> vettore)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore.size();i++)
		{
			Object temp=vettore.get(i);
			if(!contains(vettore,temp))	//Se il vettore non contiene il valore a cui fa riferimento temp esso viene aggiunto al vettore in uscita
				vettoreOut.add(temp);
		}
	}
	/**
	 * La funzione verifica se l'oggetto obj è contenuto nel vettore
	 * @param vettore vettore 
	 * @param obj oggetto di cui verificare la presenza nel vettore
	 * @return
	 */
	private boolean contains(Vector<Object> vettore,Object obj)
	{
		if((obj instanceof Ospedale)&&!(obj instanceof ProntoSoccorso)&&!(obj instanceof Permanenza)&&!
				(obj instanceof OsservazioneBreveIntensiva))
		{
			Ospedale temp=(Ospedale) obj;
			for(int i=0;i<vettore.size();i++)
			{
				if(vettore.get(i)==temp)
					return true;
			}
			return false;
		}
		if((obj instanceof ProntoSoccorso)&&!(obj instanceof Permanenza)&&!
				(obj instanceof OsservazioneBreveIntensiva))
		{
			ProntoSoccorso temp=(ProntoSoccorso) obj;
			for(int i=0;i<vettore.size();i++)
			{
				if(vettore.get(i)==temp)
					return true;
			}
			return false;
		}
		if((obj instanceof Permanenza)&&!(obj instanceof OsservazioneBreveIntensiva))
		{
			Permanenza temp=(Permanenza) obj;
			for(int i=0;i<vettore.size();i++)
			{
				if(temp==vettore.get(i))
					return true;
			}
			return false;
		}
		if(obj instanceof OsservazioneBreveIntensiva)
		{
			OsservazioneBreveIntensiva temp=(OsservazioneBreveIntensiva) obj;
			for(int i=0;i<vettore.size();i++)
			{
				if(vettore.get(i)==temp)
					return true;
			}
			return false;
		}
		return false;
	}
}
