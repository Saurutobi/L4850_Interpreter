/**
 * 
 */
package ast;

import java.util.ArrayList;

import patterns.Visitor;

import util.L485Error;

/**
 * This node represents a function definition
 * @author carr
 *
 */
public class DefuncNode implements ASTNode {

	private String name; /* the name of the function */
	private ArrayList<String> params; /* the formal parameters to the function */
	private ASTNode body; /* the body of the function */
	
	/**
	 * @param name the name of the function
	 * @param params the formal parameters to the function
	 * @param body the body of the function
	 */
	public DefuncNode(String name, ArrayList<String> params, ASTNode body) {
		super();
		this.name = name;
		this.params = params;
		this.body = body;
	}

	/**
	 * @return the name of the function
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the formal parameters to the function
	 */
	public ArrayList<String> getParams() {
		return params;
	}

	/**
	 * @return the body of the function
	 */
	public ASTNode getBody() {
		return body;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
