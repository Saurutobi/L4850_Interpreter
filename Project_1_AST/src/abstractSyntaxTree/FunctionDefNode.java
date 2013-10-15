package abstractSyntaxTree;

public class FunctionDefNode implements ASTNode
{
	protected String id;
	protected ASTNode centerNode;
	protected ASTNode rightNode;
	
	public FunctionDefNode(String id, ASTNode center, ASTNode right)
	{
		this.id = id;
		this.centerNode = center;
		this.rightNode = right;
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
