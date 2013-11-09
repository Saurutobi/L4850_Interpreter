package ldf;

import java.util.ArrayList;
import util.ListValue;
import util.Value;

//take args and make a list bitch!
public class ListFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			ArrayList<Value> list = new ArrayList<Value>();
			for(Value val : arguments)
			{
				list.add(val);
			}
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