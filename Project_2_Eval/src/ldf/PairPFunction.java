package ldf;

import java.util.ArrayList;
import util.BooleanValue;
import util.ListValue;
import util.Value;

//returns true if list has stuff in it
public class PairPFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			if(((ListValue) arguments.get(0)).get().size() > 0)
			{
				return new BooleanValue(true);
			}
			else
			{
				return new BooleanValue(false);
			}
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