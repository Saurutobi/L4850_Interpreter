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
public class GreaterEqualNode extends BinaryNode {

	/**
	 * @param leftOperand
	 * @param rightOperand
	 */
	public GreaterEqualNode(ASTNode leftOperand, ASTNode rightOperand) {
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
