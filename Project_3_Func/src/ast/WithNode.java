/**
 * 
 */
package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import patterns.Visitor;
import util.L485Error;

/**
 * This class represents a with expression in L485
 * 
 * @author carr
 *
 */
public class WithNode implements ASTNode {

	private HashMap<String,ASTNode> varDefs; /* a mapping from variable to their defining expression */
	private ASTNode body; /* the body of the with expression */
	/**
	 * 
	 */
	public WithNode(HashMap<String,ASTNode> varDefs,ASTNode body) {
		this.varDefs = varDefs;
		this.body = body;
	}
	
	/**
	 * @return the mapping from variable names to to their defining expressions
	 */
	public HashMap<String,ASTNode> getVarDefs() {
		return varDefs;
	}
	
	/**
	 * @return the set of variables defined in this with node
	 */
	public Set<String> getVariables() {
		return varDefs.keySet();
	}
	
	/**
	 * @param var a variable name
	 * @return the defining expression for var
	 */
	public ASTNode getVarExpr(String var) {
		return varDefs.get(var);
	}

	/**
	 * @return the body of the with expression
	 */
	public ASTNode getBody() {
		return body;
	}

	/* (non-Javadoc)
	 * @see ast.ASTNode#accept(patterns.Visitor)
	 */
	@Override
	public Object accept(Visitor visitor) throws L485Error {
		return visitor.visit(this);
	}

}
