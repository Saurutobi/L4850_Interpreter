package ast;
import patterns.Visitor;
import util.L485Error;

/**
 * 
 */

/**
 * This class represents a floating-point constant
 * @author carr
 *
 */
public class FloatNode implements ASTNode {

	private float val; /* the constant */
	
	/**
	 * @param val the constant
	 */
	public FloatNode(float val) {
		super();
		this.val = val;
	}

	/**
	 * @return the constant
	 */
	public float getVal() {
		return val;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
