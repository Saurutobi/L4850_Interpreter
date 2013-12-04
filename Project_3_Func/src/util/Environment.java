/**
 * 
 */
package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import patterns.EvalVisitor;
import patterns.Visitor;
import ast.ASTNode;

/**
 * @author carr AND JASON!!!
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
	
	public Environment(HashMap<String,Value> vals, Environment enclosingEnv) throws L485Error
	{
		// IT WORKS SCIENCE!!!!!!!!!!!!!!!!!!!!!!
		super(vals);
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
