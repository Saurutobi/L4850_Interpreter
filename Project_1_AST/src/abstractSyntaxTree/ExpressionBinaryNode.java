package abstractSyntaxTree;

public class ExpressionBinaryNode extends BinaryNode
{
	public ExpressionBinaryNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode, rightNode);
	}
	
	@Override
	public void acceptDepthFirst(Visitor v)
	{
		leftNode.acceptDepthFirst(v);
		v.visit(this);
		rightNode.acceptDepthFirst(v);
	}

	@Override
	public Object accept(Visitor v)
	{
		return null;
	}
}
