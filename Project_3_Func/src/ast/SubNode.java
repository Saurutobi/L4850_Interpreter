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
public class SubNode extends BinaryNode {

	/**
	 * @param leftOperand
	 * @param rightOperand
	 */
	public SubNode(ASTNode leftOperand, ASTNode rightOperand) {
		super(leftOperand, rightOperand);
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(patterns.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
