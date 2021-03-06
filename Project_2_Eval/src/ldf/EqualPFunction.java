package ldf;

import java.util.ArrayList;
import util.BooleanValue;
import util.Value;

//return true if arg[0] = arg[1]
public class EqualPFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			if(arguments.get(0) == arguments.get(1))
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