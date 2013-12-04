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
	
	public Environment(HashMap<String,ASTNode> vals, Environment enclosingEnv) throws L485Error
	{
		//See withnode
		// WARNING
		// WARNING
		// WARNING
		// WARNING
		// WARNING			this may or may not work but im pushing for good luck dinner time
		// WARNING
		// WARNING
		// WARNING
		// WARNING
		// WARNING
		// WARNING
		HashMap<String,Value> tempHashMap = null;
		ArrayList<ASTNode> astNodes;
		String[] tempVals = (String[]) vals.keySet().toArray();
		
		for(int i = 0; i < tempVals.length; i++)
		{
			tempHashMap.put(tempVals[i], (Value)vals.get(tempVals[i]).accept(new EvalVisitor(enclosingEnv)));
		}		
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
