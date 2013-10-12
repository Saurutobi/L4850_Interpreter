package abstractSyntaxTree;

public class ExpressionListNode extends UnaryNode
{

	public ExpressionListNode(ASTNode centerNode)
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
