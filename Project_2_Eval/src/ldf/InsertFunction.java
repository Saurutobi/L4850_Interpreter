package ldf;

import java.util.ArrayList;
import util.ListValue;
import util.Value;

//Insert arg[0] at [0] in arg[1]
public class InsertFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			ArrayList<Value> list = ((ListValue)arguments.get(1)).get();
			list.add(0, arguments.get(0));
			return new ListValue(list);
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