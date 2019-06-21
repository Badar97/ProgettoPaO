package com.progetto.oop;

public class Metadati 
{
	private String Alias;
	private String SourceField;
	private String Type;
	public Metadati(String Alias,String SourceField,String Type)
	{
		this.Alias=Alias;
		this.SourceField=SourceField;
		this.Type=Type;
	}
	public String getAlias()
	{
		return Alias;
	}
	public String getSourceField()
	{
		return SourceField;
	}
	public String getType()
	{
		return Type;
	}
}
