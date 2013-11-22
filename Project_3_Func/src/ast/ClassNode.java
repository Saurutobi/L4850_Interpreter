/**
 * 
 */
package ast;

import java.util.ArrayList;

import patterns.Visitor;

import util.L485Error;

/**
 * This class reprsents the definition of a class in L485
 * @author carr
 *
 */
public class ClassNode implements ASTNode {

	private String name; /* the name of the class */
	private ArrayList<String> classVars; /* the variables defined in the class */
	private ASTNodeList methods; /* the methods in the class */
	
	/**
	 * @param name the name of the class
	 * @param classVars the variables defined in the class
	 * @param methods the methods defined in the class
	 */
	public ClassNode(String name, ArrayList<String> classVars,
			ASTNodeList methods) {
		super();
		this.name = name;
		this.classVars = classVars;
		this.methods = methods;
	}

	/**
	 * @return the name of the class
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the variables defined in the class
	 */
	public ArrayList<String> getClassVars() {
		return classVars;
	}

	/**
	 * @return the methods defined in the class
	 */
	public ASTNodeList getMethods() {
		return methods;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(visitor.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
