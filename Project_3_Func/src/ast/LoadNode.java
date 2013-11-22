/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * This class represents an expression to load an L485 file from disk
 * @author carr
 *
 */
public class LoadNode implements ASTNode {

	private String fileName; /* the name of the file */
	
	/**
	 * @param fileName the name of the file
	 */
	public LoadNode(String fileName) {
		super();
		this.fileName = fileName;
	}

	/**
	 * @return the name of the file
	 */
	public String getFileName() {
		return fileName;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
