package util;

import java.util.ArrayList;

import patterns.EvalVisitor;
import ast.ASTNode;

public class Closure extends Function{

	private String name;
	private ArrayList<String> parameters;
	private ASTNode body;
	private Environment env;
	
	public Closure(String name, ArrayList<String> parameters, ASTNode body, Environment env){
			this.name = name;
			this.parameters = parameters;
			this.body = body;
			this.env = env;
	}

	public ArrayList<String> getParameters()
	{
		return this.parameters;
	}
	
	@Override
	public Value invoke(Environment paramenv, ArrayList<Value> args) throws L485Error {
		//something needs to go here
		
		Closure holder = (Closure) env.get(name);
		paramenv.addToMap(parameters, args);
		
		if(args.size() == ((Closure)env.get(name)).getParameters().size())
		{
			return (Value) body.accept(new EvalVisitor(paramenv));
		}
		else
		{
			throw new L485Error("Use the correct number of parameters please");
		}
	}

	@Override
	public String toString() {
		return this.name;
	}
}
