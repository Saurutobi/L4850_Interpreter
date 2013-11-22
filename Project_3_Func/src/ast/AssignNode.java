/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * This class represents an assigmnent expression
 * @author carr
 *
 */
public class AssignNode implements ASTNode{


	private String lhs; /* the expression on the left hand side of an assignment */
	private ASTNode rhs; /* the expression on the right hand side of an assignment */
	
	
	public AssignNode(String lhs, ASTNode rhs) {
		super();
		this.setLhs(lhs);
		this.setRhs(rhs);
	}
	
	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	public Object accept(Visitor v) throws L485Error { 
		return v.visit(this); 
	}

	/**
	 * @return the left hand side of an assignment
	 */
	public String getLhs() {
		return lhs;
	}

	/**
	 * @param lhs the left hand side of an assignment to set
	 */
	public void setLhs(String lhs) {
		this.lhs = lhs;
	}

	/**
	 * @return the right hand side of an assignment
	 */
	public ASTNode getRhs() {
		return rhs;
	}

	/**
	 * @param rhs the right hand side of an assignment to set
	 */
	public void setRhs(ASTNode rhs) {
		this.rhs = rhs;
	}


}
