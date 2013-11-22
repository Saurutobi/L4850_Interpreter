/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * @author carr
 *
 */
public interface ASTNode {
	/**
	 * This is the accept method for the visitor pattern. It has been modified to return a value to allow the implementation of 
	 * an interpreter. The modified visitor pattern was used so that the interpreter is not spread over all of the AST files as would
	 * be the case using an interpreter pattern.
	 * 
	 * @param visitor - a visitor for an AST
	 * @return an Object
	 * @throws L485Error TODO
	 */
	public Object accept(Visitor visitor) throws L485Error;
}
