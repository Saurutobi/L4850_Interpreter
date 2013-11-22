/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * This class represents and integer constant
 * @author carr
 *
 */
public class IntegerNode implements ASTNode {

	private int val; /* the constant */
	
	/**
	 * @param val the constant
	 */
	public IntegerNode(int val) {
		super();
		this.val = val;
	}

	/**
	 * @return the constant
	 */
	public int getVal() {
		return val;
	}

	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
