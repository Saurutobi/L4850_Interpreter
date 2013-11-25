/**
 * 
 */
package util;

import java.util.HashMap;
import java.util.List;

/**
 * @author carr
 *
 */
public class Environment extends HashMap<String,Value>{

	/**
	 * 
	 */
	private Environment enclosing;
	private static final long serialVersionUID = -8991149306084765376L;
	
	public Environment(List<String> vars, List<Value> vals, Environment enclosingEnv) {
		super();
		
		addToMap(vars,vals);
		enclosing = enclosingEnv;
		
	}
	
	public Value get(String var) throws L485Error {
		if (containsKey(var)) 
			return super.get(var);
		else
			return enclosing.get(var);
	}
	
	public Value put(String var,Value val) {
		super.put(var, val);
		return val;
	}
	
	protected void addToMap(List<String> vars, List<Value> vals) {
		
		for (int i = 0; i < vals.size(); i++)
			put(vars.get(i), vals.get(i));
		
	}
}
