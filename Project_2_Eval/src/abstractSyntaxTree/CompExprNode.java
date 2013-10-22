package abstractSyntaxTree;

import java.util.List;

import Visitors.Visitor;

public class CompExprNode extends BinaryNode
{
	public CompExprNode(ASTNode leftNode, List<ASTNode> extraNodes)
	{
		super(leftNode, extraNodes);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
