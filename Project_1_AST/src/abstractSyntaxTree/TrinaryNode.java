package abstractSyntaxTree;

public abstract class TrinaryNode implements ASTNode
{
	protected ASTNode leftNode;
	protected ASTNode centerNode;
	protected ASTNode rightNode;
	
	public TrinaryNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super();
		this.leftNode = leftNode;
		this.centerNode = centerNode;
		this.rightNode = rightNode;
	}
	
	public ASTNode getLeftNode()
	{
		return leftNode;
	}
	
	public ASTNode getCenterNode()
	{
		return centerNode;
	}
	
	public ASTNode getRightNode()
	{
		return rightNode;
	}
}
