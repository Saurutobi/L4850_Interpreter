/**
 * 
 */
package ast;

import java.util.ArrayList;

import patterns.Visitor;

import util.L485Error;

/**
 * This class represent a list of values in L485
 * @author carr
 *
 */
public class ListNode implements ASTNode {

	private ArrayList<ASTNode> theList; /* the list of values *?

	/**
	 * @param the list of values
	 */
	public ListNode(ArrayList<ASTNode> theList) {
		super();
		this.theList = theList;
	}

	/**
	 * @return the list of values
	 */
	public ArrayList<ASTNode> getTheList() {
		return theList;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
