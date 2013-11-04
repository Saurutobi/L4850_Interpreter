package abstractSyntaxTree;

import Visitors.*;

public class NewExprNode extends UnaryNode
{
	public NewExprNode(String token)
	{
		super(token);
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
