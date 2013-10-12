package abstractSyntaxTree;

public class ClassDefNode extends TrinaryNode
{
	public ClassDefNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super(leftNode, centerNode, rightNode);
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
		return v.visit(this);
	}
}

