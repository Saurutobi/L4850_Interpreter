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

	@Override
	public Value invoke(Environment paramenv, ArrayList<Value> args) throws L485Error {
		//something needs to go here
		
		Closure holder = (Closure) env.get(name);
		// There needs to be some error checking here to make
		//	sure that the correct number of parameters are sent to this function
		paramenv.addToMap(parameters, args);
		return (Value) body.accept(new EvalVisitor(paramenv));
	}

	@Override
	public String toString() {
		return this.name;
	}
}
