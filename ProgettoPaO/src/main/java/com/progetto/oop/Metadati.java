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
	public String get1()
	{
		return Alias;
	}
	public String get2()
	{
		return SourceField;
	}
	public String get3()
	{
		return Type;
	}
	
}
