package abstractSyntaxTree;

public class FactorNode extends BinaryNode
{
	public FactorNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode, rightNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}	
}