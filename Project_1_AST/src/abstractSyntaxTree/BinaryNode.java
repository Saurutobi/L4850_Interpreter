package abstractSyntaxTree;

public abstract class BinaryNode implements ASTNode
{
	protected ASTNode leftNode;
	protected ASTNode rightNode;
	
	public BinaryNode(ASTNode leftNode, ASTNode rightNode)
	{
		super();
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public ASTNode getLeftNode()
	{
		return leftNode;
	}
	
	public ASTNode getRightNode()
	{
		return rightNode;
	}

	public void acceptDepthFirst(Visitor v) {
		// TODO Auto-generated method stub
		
	}
}
