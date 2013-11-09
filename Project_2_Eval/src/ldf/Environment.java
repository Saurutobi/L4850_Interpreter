package ldf;

import java.util.HashMap;
import util.Value;

public class Environment extends HashMap<String, Value>
{
	private static final long serialVersionUID = 7421707026750954296L;

	public Environment()
	{
		this.put("first", new FirstFunction());
		this.put("rest", new RestFunction());
		this.put("insert", new InsertFunction());
		this.put("list", new ListFunction());
		this.put("emptyp", new EmptyPFunction());
		this.put("pairp", new PairPFunction());
		this.put("listp", new ListPFunction());
		this.put("equalp", new EqualPFunction());
		this.put("length", new LengthFunction());
		this.put("numberp", new NumberPFunction());
		this.put("exit", new ExitFunction());
	}

	public Environment(int initialCapacity)
	{
		super(initialCapacity);
	}

	public Environment(int initialCapacity, float loadFactor)
	{
		super(initialCapacity, loadFactor);
	}
}