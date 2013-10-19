package abstractSyntaxTree;

public class ExpressionBinaryNode extends TrinaryNode
{
	
	public ExpressionBinaryNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super(leftNode, centerNode, rightNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
