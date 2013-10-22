package abstractSyntaxTree;

public class FuncExprNode extends BinaryNode
{
	public FuncExprNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode, rightNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
