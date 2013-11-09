package ldf;

import java.util.ArrayList;
import util.IntValue;
import util.FloatValue;
import util.BooleanValue;
import util.Value;

public class NumberPFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			if(arguments.get(0) instanceof IntValue)
			{
				return new BooleanValue(true);
			}
			else if (arguments.get(0) instanceof FloatValue)
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