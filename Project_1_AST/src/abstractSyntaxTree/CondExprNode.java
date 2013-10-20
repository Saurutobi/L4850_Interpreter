package abstractSyntaxTree;

public class CondExprNode extends UnaryNode
{
	public CondExprNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
