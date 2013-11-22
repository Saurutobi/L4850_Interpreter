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
public class MethodrefNode implements ASTNode {

	private String objectName;
	private String methodName;
	
	/**
	 * @param objectName
	 * @param methodName
	 */
	public MethodrefNode(String objectName, String methodName) {
		super();
		this.objectName = objectName;
		this.methodName = methodName;
	}

	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * @param objectName the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
