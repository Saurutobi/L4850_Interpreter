package abstractSyntaxTree;

import Visitors.Visitor;

public class ExpressionUnaryNode extends UnaryNode
{

	public ExpressionUnaryNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}