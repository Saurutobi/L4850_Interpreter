/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * This class represents a function call
 * @author carr
 *
 */
public class CallNode implements ASTNode {

	private ASTNode func; /* the function to be called */
	private ArgumentListNode args; /* the list of arguments to the function */
	
	public CallNode(ASTNode func, ArgumentListNode args) {
		this.func = func;
		this.args = args;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

	/**
	 * @return the function being called
	 */
	public ASTNode getFunc() {
		return func;
	}
	
	/**
	 * @return the list of arguments to the function
	 */
	public ArgumentListNode getArgs() {
		return args;
	}

}
