package abstractSyntaxTree;

import Visitors.Visitor;

public class CompOpNode extends UnaryNode
{
	public CompOpNode(String symbol)
	{
		super(symbol);
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}