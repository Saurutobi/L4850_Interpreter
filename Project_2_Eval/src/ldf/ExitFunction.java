package ldf;

import java.util.ArrayList;
import util.Value;

public class ExitFunction extends BuiltInFunction
{
	@Override
	public Value invoke(Environment env, ArrayList<Value> arguments)
	{
		try
		{
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println("YOU SHALL NOT EXIT!!!!");
		}
		return null;
	}
}