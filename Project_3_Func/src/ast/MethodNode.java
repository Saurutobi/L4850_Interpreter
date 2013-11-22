/**
 * 
 */
package ast;

import java.util.ArrayList;

import patterns.Visitor;

import util.L485Error;

/**
 * @author carr
 *
 */
public class MethodNode implements ASTNode {

	private String name;
	private ArrayList<String> params;
	private ASTNode body;
	
	/**
	 * @param name
	 * @param params
	 * @param body
	 */
	public MethodNode(String name, ArrayList<String> params, ASTNode body) {
		super();
		this.name = name;
		this.params = params;
		this.body = body;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the params
	 */
	public ArrayList<String> getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(ArrayList<String> params) {
		this.params = params;
	}

	/**
	 * @return the body
	 */
	public ASTNode getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(ASTNode body) {
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
