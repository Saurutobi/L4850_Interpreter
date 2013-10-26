package util;

import java.util.HashMap;
import java.util.Map;

public class Environment extends HashMap<String, Value>{

	private static final long serialVersionUID = 7421707026750954296L;
	
	public Environment()
	{
		
	}
	
	public Environment(int startCapacity)
	{
		super(startCapacity);
	}
	
	public Environment(Map m)
	{
		super(m);
	}
	
	public Environment(int startCapacity, float loadFactor)
	{
		super(startCapacity, loadFactor);
	}
}
