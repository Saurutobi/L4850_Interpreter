package abstractSyntaxTree;

public class FunctionDefNode extends TrinaryNode
{
	public FunctionDefNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super(leftNode, centerNode, rightNode);
	}

	@Override
	public void acceptDepthFirst(Visitor v)
	{
		
	}

	@Override
	public Object accept(Visitor v)
	{
		return null;
	}
}
