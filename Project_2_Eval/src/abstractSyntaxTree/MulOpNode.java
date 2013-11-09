package abstractSyntaxTree;

import Visitors.*;

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
