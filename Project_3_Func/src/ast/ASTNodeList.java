/**
 * 
 */
package ast;

import java.util.ArrayList;

import patterns.Visitor;

import util.L485Error;

/**
 * This class represents a sequence of ASTNodes.
 * @author carr
 *
 */
public class ASTNodeList implements ASTNode {
	
	private ArrayList<ASTNode> nodeList; /* a sequence of ASTNodes */
	
	public ASTNodeList() {
		nodeList = new ArrayList<ASTNode>();
	}
	
	/**
	 * Add a node to the lsit
	 * @param n an ASTNode
	 */
	public void add(ASTNode n) {
		nodeList.add(n);
	}
	
	/**
	 * @return the list of ASTNodes
	 */
	public ArrayList<ASTNode> getNodeList() {
		return nodeList;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}