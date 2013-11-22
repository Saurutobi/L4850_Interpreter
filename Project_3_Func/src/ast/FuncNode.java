/**
 * 
 */
package ast;

import java.util.ArrayList;

import patterns.Visitor;

import util.L485Error;

/**
 * This class represents a name-less function (lambda expression in lisp terms)
 * @author carr
 *
 */
public class FuncNode implements ASTNode {

	private ArrayList<String> params; /* the formal parameters to the function */
	private ASTNode body; /* the body of the function */
	
	/**
	 * @param params the formal parameters to the function
	 * @param body the body of the function
	 */
	public FuncNode(ArrayList<String> params, ASTNode body) {
		super();
		this.params = params;
		this.body = body;
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
