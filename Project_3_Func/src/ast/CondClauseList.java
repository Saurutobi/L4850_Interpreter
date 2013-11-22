/**
 * 
 */
package ast;

import java.util.ArrayList;

import patterns.Visitor;
import util.L485Error;

/**
 * This class represents a list of cond clauses
 * @author carr
 *
 */
public class CondClauseList implements ASTNode {

	private ArrayList<CondClauseNode> clauses; /* a list of cond clauses */
	
	public CondClauseList() {
		clauses = new ArrayList<CondClauseNode>();
	}
	/**
	 * @return the list of clauses
	 */
	public ArrayList<CondClauseNode> getClauses() {
		return clauses;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(patterns.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
