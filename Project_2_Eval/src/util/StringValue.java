package util;

public class StringValue extends Value{
	
	private String val;
	
	public StringValue(String val)
	{
		this.val = val;
	}
	
	public String getVal()
	{
		return val;
	}
	
	public void setVal(String val)
	{
		this.val = val;
	}
	
	public String toString()
	{
		return "" + val;
	}
}
