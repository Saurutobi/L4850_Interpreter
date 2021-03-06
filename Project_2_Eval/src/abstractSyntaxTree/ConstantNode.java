package abstractSyntaxTree;

import Visitors.*;

public class ConstantNode extends UnaryNode
{
	public ConstantNode(String name)
	{
		super(name);
	}
	
	public ConstantNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}