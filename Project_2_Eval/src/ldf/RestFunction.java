package ldf;

import java.util.ArrayList;

import util.ListValue;
import util.Value;

//returns list without first item
public class RestFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			ArrayList<Value> fakoff = ((ListValue) arguments.get(0)).get();
			fakoff.remove(0);
			return new ListValue(fakoff);
		}
		catch (ClassCastException e)
		{
			System.out.println(e.getMessage());
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("List must contain at least one value to call first");
		}
		return null;
	}
}