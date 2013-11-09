package util;

public class BooleanValue extends Value{
	
	private boolean val;
	
	public BooleanValue(boolean val)
	{
		this.val = val;
	}
	
	public BooleanValue() {
		// TODO Auto-generated constructor stub
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
