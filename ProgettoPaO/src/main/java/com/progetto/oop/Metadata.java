package com.progetto.oop;

import java.lang.reflect.Field;

public class Metadata 
{
	private Field Alias[]=this.getClass().getDeclaredFields();
	public String[] getFields()
	{
		String nome[]=new String[Alias.length];
		for(int i=0;i<Alias.length;i++)
		{
			nome[i]=Alias[i].getName();
		}
		return nome;
	}
	public String[] getType()
	{
		String nome[]=new String[Alias.length];
		for(int i=0;i<Alias.length;i++)
		{
			nome[i]=Alias[i].getType().getSimpleName();
		}
		return nome;
	}
}
