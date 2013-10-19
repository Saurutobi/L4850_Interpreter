package abstractSyntaxTree;

import java.util.List;

public abstract class BinaryNode implements ASTNode
{
	protected ASTNode leftNode;
	protected ASTNode rightNode;
	protected String leftString;
	protected String rightString;
	
	public BinaryNode(){}
	
	public BinaryNode(String leftString, String rightString)
	{
		this.leftString = leftString;
		this.rightString = rightString;
	}
	public BinaryNode(ASTNode leftNode, List<ASTNode> extraNodes)
	{
		
	}
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
	
	public String getLeftString()
	{
		return leftString;
	}
	
	public String getRightString()
	{
		return rightString;
	}
}
