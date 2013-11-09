package ldf;

import java.util.ArrayList;
import util.ListValue;
import util.IntValue;
import util.Value;

//return length of the list
public class LengthFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			return new IntValue(((ListValue)arguments.get(0)).get().size());
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