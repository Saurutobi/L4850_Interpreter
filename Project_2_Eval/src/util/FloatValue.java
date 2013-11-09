package util;

public class FloatValue extends Value{
	
	private float val;
	
	public FloatValue(float val)
	{
		this.val = val;
	}
	
	public FloatValue() {
		// TODO Auto-generated constructor stub
	}

	public float getVal()
	{
		return val;
	}
	
	public void setVal(float val)
	{
		this.val = val;
	}
	
	public String toString()
	{
		return "" + val;
	}
}
