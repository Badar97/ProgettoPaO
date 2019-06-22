package data;

import java.lang.reflect.Field;

public class Metadati 
{
	private String Alias;
	private String SourceField;
	private String Type;
	public Metadati(Field Alias,String SourceField)
	{
		this.Alias=Alias.getName();
		this.SourceField=SourceField;
		this.Type=Alias.getType().getSimpleName();
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
