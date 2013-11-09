package ldf;

import java.util.ArrayList;
import util.Value;

public abstract class BuiltInFunction extends Value
{
	public abstract Value invoke(Environment env, ArrayList<Value> args);

	public String toString()
	{
		return "#builtin";
	}
}
