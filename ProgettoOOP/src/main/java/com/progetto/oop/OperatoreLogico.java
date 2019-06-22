package com.progetto.oop;

import java.util.Vector;

public class OperatoreLogico
{
	Vector<Object> vettoreOut;
	public OperatoreLogico(String Operatore,Vector<Object> vettore1,Vector<Object> vettore2)
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
	}
	public OperatoreLogico(String Operatore,Vector<Object> vettore)
	{
		if(Operatore=="$not")
			not(vettore);
	}
	private void and(Vector<Object> vettore1,Vector<Object> vettore2)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore1.size();i++)
		{
			Object temp=vettore1.get(i);
			if(contains(vettore2,temp))
				vettoreOut.add(temp);
		}
	}
	private void or(Vector<Object> vettore1,Vector<Object> vettore2)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore1.size();i++)
		{
			Object temp=vettore1.get(i);
			vettoreOut.add(temp);
		}
		for(int i=0;i<vettore2.size();i++)
		{
			Object temp=vettore2.get(i);
			if(!contains(vettoreOut,temp))
				vettoreOut.add(temp);
		}	
	}
	public void not(Vector<Object> vettore)
	{
		vettoreOut=new Vector<Object>();
		for(int i=0;i<vettore.size();i++)
		{
			Object temp=vettore.get(i);
			if(!contains(vettore,temp))
				vettoreOut.add(temp);
		}
	}
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
