/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * This class represents a clause in a cond epxression
 * @author carr
 *
 */
public class CondClauseNode implements ASTNode {

	private ASTNode testExpr; /* the expression to test */
	private ASTNode resultExpr; /* the expression to evaluate if the test is true */
	
	/**
	 * @param testExpr the expression to test
	 * @param resultExpr the value to return if the test is true
	 */
	public CondClauseNode(ASTNode testExpr, ASTNode resultExpr) {
		super();
		this.testExpr = testExpr;
		this.resultExpr = resultExpr;
	}

	/**
	 * @return the expression to test for truth
	 */
	public ASTNode getTestExpr() {
		return testExpr;
	}

	/**
	 * @return the expression to evaluate if the test is true
	 */
	public ASTNode getResultExpr() {
		return resultExpr;
	}

	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
