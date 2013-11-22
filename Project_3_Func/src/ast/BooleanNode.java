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
public class BooleanNode implements ASTNode {

	private boolean value;
	
	/**
	 * 
	 */
	public BooleanNode(boolean value) {
		this.value = value;
	}

	/**
	 * @return the constant
	 */
	public boolean getVal() {
		return value;
	}

	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
