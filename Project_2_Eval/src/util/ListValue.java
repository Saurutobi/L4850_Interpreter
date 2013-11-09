package util;

import java.util.ArrayList;

public class ListValue extends Value{

	private ArrayList<Value> values;
	
	public ListValue(ArrayList<Value> arrayList)
	{
		this.values = arrayList;
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
		//idk if we want brackets here or not yet so we shall see
		String temp = "[";
		for(int i = 0; i < values.size() - 1; i++)
		{
			temp += values.get(i).toString() + ", ";
		}
		return temp + values.get(values.size() -1).toString() + "]";
	}
}
