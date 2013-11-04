package util;

import java.util.ArrayList;

public class ListValue extends Value{

	private ArrayList<Value> values;
	
	public ListValue(ArrayList<Value> values)
	{
		this.values = values;
	}
	
	public ArrayList<Value> get()
	{
		return values;
	}
	
	public void set(ArrayList<Value> newValues)
	{
		this.values = newValues;
	}
	public String toString()
	{
		String temp = "";
		for(int i = 0; i < values.size(); i++)
		{
			temp += values.get(i).toString() + " ";
		}
		return temp;
	}
}
