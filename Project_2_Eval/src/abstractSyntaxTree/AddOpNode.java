package abstractSyntaxTree;

import Visitors.*;

public class AddOpNode extends UnaryNode
{
	public AddOpNode(String symbol)
	{
		super(symbol);
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
