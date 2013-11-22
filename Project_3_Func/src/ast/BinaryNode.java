/**
 * 
 */
package ast;

/**
 * @author carr
 *
 */
public abstract class BinaryNode implements ASTNode {

	private ASTNode leftOperand;
	private ASTNode rightOperand;

	/**
	 * @param leftOperand
	 * @param rightOperand
	 */
	public BinaryNode(ASTNode leftOperand, ASTNode rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	/**
	 * @return the leftOperand
	 */
	public ASTNode getLeftOperand() {
		return leftOperand;
	}
	/**
	 * @param leftOperand the leftOperand to set
	 */
	public void setLeftOperand(ASTNode leftOperand) {
		this.leftOperand = leftOperand;
	}
	/**
	 * @return the rightOperand
	 */
	public ASTNode getRightOperand() {
		return rightOperand;
	}
	/**
	 * @param rightOperand the rightOperand to set
	 */
	public void setRightOperand(ASTNode rightOperand) {
		this.rightOperand = rightOperand;
	}


}
