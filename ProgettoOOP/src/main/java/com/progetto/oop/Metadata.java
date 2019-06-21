package com.progetto.oop;

import java.lang.reflect.Field;

public abstract class Metadata 
{
	private String[] SourceField;
	private Field[] Fields;
	public abstract Field[] getCampi();
	public String[] getAlias()
	{
		Fields=getCampi();
		String[] nome=new String[Fields.length];
		for(int i=0;i<nome.length;i++)
		{
			nome[i]=Fields[i].getName();
		}
		return nome;
	}
	public String[] getSourceField()
	{
		return SourceField;
	}
	public String[] getType()
	{
		String[] nome=new String[Fields.length];
		for(int i=0;i<nome.length;i++)
		{
			nome[i]=Fields[i].getType().getSimpleName();
		}
		return nome;
	}
	public void setSourceField(String SourceField[])
	{
		this.SourceField=SourceField;
	}
}
