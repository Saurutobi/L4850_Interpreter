/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * This class represents a cond expression
 * @author carr
 *
 */
public class CondNode implements ASTNode {

	private ASTNodeList clauses; /* a list of clauses */
	
	/**
	 * @param clauses
	 */
	public CondNode(ASTNodeList clauses) {
		super();
		this.clauses = clauses;
	}

	/**
	 * @return the clauses
	 */
	public ASTNodeList getClauses() {
		return clauses;
	}

	/**
	 * @param clauses the clauses to set
	 */
	public void setClauses(ASTNodeList clauses) {
		this.clauses = clauses;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
