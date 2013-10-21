package abstractSyntaxTree;

public class CallNode extends UnaryNode
{
	public CallNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
