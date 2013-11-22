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
public class NotNode implements ASTNode {

	private ASTNode operand;
	/**
	 * @param operand
	 */
	public NotNode(ASTNode operand) {
		this.operand = operand;
	}
	/**
	 * 
	 */

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(patterns.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
	/**
	 * @return the operand
	 */
	public ASTNode getOperand() {
		return operand;
	}
	/**
	 * @param operand the operand to set
	 */
	public void setOperand(ASTNode operand) {
		this.operand = operand;
	}

}
