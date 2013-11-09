package abstractSyntaxTree;

import java.util.List;

import Visitors.*;
public class ExpressionListNode extends UnaryNode
{
	public ExpressionListNode(List<ASTNode> centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
