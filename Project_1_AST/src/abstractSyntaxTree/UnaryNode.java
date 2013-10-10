package abstractSyntaxTree;

public abstract class UnaryNode implements ASTNode
{
	protected ASTNode centerNode;
	
	public UnaryNode(ASTNode centerNode)
	{
		super();
		this.centerNode = centerNode;
	}
	
	public ASTNode getCenterNode()
	{
		return centerNode;
	}
}
