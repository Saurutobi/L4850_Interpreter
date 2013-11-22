/**
 * 
 */
package ast;

import java.util.ArrayList;

import patterns.Visitor;

import util.L485Error;

/**
 * This class represent a list of arguments in a function call.
 * 
 * @author carr
 *
 */
public class ArgumentListNode implements ASTNode {

	private ArrayList<ASTNode> arguments; /* a list of arguments to a function */
	
	public ArgumentListNode() {
		arguments = new ArrayList<ASTNode>();
	}
	
	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}
	
	/**
	 * @return the list of arguments
	 */
	public ArrayList<ASTNode> getArguments() {
		return arguments;
	}

	/**
	 * Add an argument to the list
	 * @param arg an argmument to a function call
	 */
	public void add(ASTNode arg) {
		arguments.add(arg);
	}
}
