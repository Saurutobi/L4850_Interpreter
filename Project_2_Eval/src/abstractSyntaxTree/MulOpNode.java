package abstractSyntaxTree;

import Visitors.Visitor;

public class MulOpNode implements ASTNode
{
	private String timesDivide;
	
	public MulOpNode(String Token)
	{
		this.timesDivide = Token;
	}

	public String getToken()
	{
		return timesDivide;
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
