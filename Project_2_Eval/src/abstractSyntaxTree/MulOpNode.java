package abstractSyntaxTree;

import visitors.Visitor;

public class MulOpNode extends UnaryNode
{
	public MulOpNode(String symbol)
	{
		super(symbol);
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
