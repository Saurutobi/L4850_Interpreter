package ldf;

import java.util.ArrayList;
import util.ListValue;
import util.Value;

//returns the first element of a list
public class FirstFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			return ((ListValue) arguments.get(0)).get().get(0);
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