package abstractSyntaxTree;

public class ExpressionUnaryNode extends UnaryNode
{

	public ExpressionUnaryNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public void acceptDepthFirst(Visitor v)
	{
		v.visit(this);
		centerNode.acceptDepthFirst(v);
	}

	@Override
	public Object accept(Visitor v)
	{
		return null;
	}
}