package abstractSyntaxTree;

import java.util.List;

public abstract class TrinaryNode implements ASTNode
{
	private String id;
	private ASTNode leftNode;
	private ASTNode centerNode;
	private ASTNode rightNode;
	
	public TrinaryNode(ASTNode left, ASTNode center, ASTNode right)
	{
		this.leftNode = left;
		this.centerNode = center;
		this.rightNode = right;
	}
	public TrinaryNode(String id, ASTNode center, ASTNode right)
	{
		this.id = id;
		this.centerNode = center;
		this.rightNode = right;
	}
	
	public String getID()
	{
		return id;
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
