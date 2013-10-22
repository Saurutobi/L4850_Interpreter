package abstractSyntaxTree;

import Visitors.Visitor;

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
