package abstractSyntaxTree;

import visitors.Visitor;

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