package abstractSyntaxTree;

import java.util.List;

public class ExpressionBinaryNode extends BinaryNode
{
	public ExpressionBinaryNode(ASTNode leftNode, List<ASTNode> extraNodes)
	{
		super(leftNode, extraNodes);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
