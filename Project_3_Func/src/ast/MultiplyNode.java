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
public class MultiplyNode extends BinaryNode {

	/**
	 * @param leftOperand
	 * @param rightOperand
	 */
	public MultiplyNode(ASTNode leftOperand, ASTNode rightOperand) {
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
