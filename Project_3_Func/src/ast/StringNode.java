/**
 * 
 */
package ast;

import patterns.Visitor;
import util.L485Error;

/**
 * @author carr
 *
 */
public class StringNode implements ASTNode {
	private String str;

	/**
	 * @param str
	 */
	public StringNode(String str) {
		super();
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}
	
}
