package abstractSyntaxTree;

public abstract class TrinaryNode implements ASTNode
{
	private String id;
	private ASTNode centerNode;
	private ASTNode rightNode;
	
	public TrinaryNode(String id, ASTNode center, ASTNode right)
	{
		super();
		this.id = id;
		this.centerNode = center;
		this.rightNode = right;
	}
	
	public String getID()
	{
		return id;
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
