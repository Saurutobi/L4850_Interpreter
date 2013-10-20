package abstractSyntaxTree;

public class VariableDefsNode extends BinaryNode
{
	public VariableDefsNode(String token, ASTNode rightNode)
	{
		super(token, rightNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
