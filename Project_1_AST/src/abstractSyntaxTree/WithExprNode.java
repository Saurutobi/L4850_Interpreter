package abstractSyntaxTree;

public class WithExprNode extends BinaryNode
{
	public WithExprNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode,rightNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
