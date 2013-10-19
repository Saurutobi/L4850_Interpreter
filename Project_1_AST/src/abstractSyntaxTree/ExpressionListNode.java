package abstractSyntaxTree;

public class ExpressionListNode extends UnaryNode
{

	public ExpressionListNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
