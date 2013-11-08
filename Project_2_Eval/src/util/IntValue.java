package util;

public class IntValue extends Value{
	
	private int val;
	
	public IntValue()
	{
		
	}
	
	public IntValue(int val)
	{
		this.val = val;
	}
	
	public int getVal()
	{
		return val;
	}
	
	public void setVal(int val)
	{
		this.val = val;
	}
	
	public String toString()
	{
		return "" + val;
	}
}

