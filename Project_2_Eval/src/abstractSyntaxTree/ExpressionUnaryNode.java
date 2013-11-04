package abstractSyntaxTree;

import Visitors.*;

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