package util;

import java.util.ArrayList;

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
	public Value invoke(Environment env, ArrayList<Value> args) throws L485Error {
		//something needs to go here
		return null;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
