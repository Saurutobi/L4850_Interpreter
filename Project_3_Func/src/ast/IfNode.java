/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * This class repsresents an if-expression
 * @author carr
 *
 */
public class IfNode implements ASTNode {

	private ASTNode testExpr; /* the test expression */
	private ASTNode thenExpr; /* the expression to evaluate if test is true */
	private ASTNode elseExpr; /* the expression to evaluate if test if false */
	
	/**
	 * @param testExpr the test expression
	 * @param thenExpr the expression to evaluate if test is true
	 * @param elseExpr the expression to evaluate if test if false
	 */
	public IfNode(ASTNode testExpr, ASTNode thenExpr, ASTNode elseExpr) {
		super();
		this.testExpr = testExpr;
		this.thenExpr = thenExpr;
		this.elseExpr = elseExpr;
	}

	/**
	 * @return the test expression
	 */
	public ASTNode getTestExpr() {
		return testExpr;
	}

	/**
	 * @return the expression to evaluate if test is true
	 */
	public ASTNode getThenExpr() {
		return thenExpr;
	}

	/**
	 * @return the expression to evaluate if test if false
	 */
	public ASTNode getElseExpr() {
		return elseExpr;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
