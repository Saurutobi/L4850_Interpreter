package util;

public class BooleanValue extends Value{
	
	private boolean val;
	
	public BooleanValue(boolean val)
	{
		this.val = val;
	}
	
	public boolean getVal()
	{
		return val;
	}
	
	public void setVal(boolean val)
	{
		this.val = val;
	}
	
	public String toString()
	{
		return "" + val;
	}
}
