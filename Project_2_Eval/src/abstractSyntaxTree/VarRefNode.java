package abstractSyntaxTree;

import Visitors.Visitor;

public class VarRefNode implements ASTNode
{
	private String leftString = null;
	private String rightString = null;
	
	public VarRefNode(String leftString, String rightString)
	{
		this.leftString = leftString;
		this.rightString = rightString;
	}
	
	public String getLeftString()
	{
		return leftString;
	}
	
	public String getRightString()
	{
		return rightString;
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}

