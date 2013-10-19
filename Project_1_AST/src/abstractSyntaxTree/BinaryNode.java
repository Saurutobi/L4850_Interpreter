package abstractSyntaxTree;

import java.util.List;

public abstract class BinaryNode implements ASTNode
{
	protected ASTNode leftNode;
	protected ASTNode rightNode;
	protected String leftString;
	protected String rightString;
	protected List<ASTNode> extraNodes;
	
	public BinaryNode(String leftString, String rightString)
	{
		this.leftString = leftString;
		this.rightString = rightString;
	}
	public BinaryNode(ASTNode leftNode, List<ASTNode> extraNodes)
	{
		this.leftNode = leftNode;
		this.extraNodes = extraNodes;
	}
	public BinaryNode(ASTNode leftNode, ASTNode rightNode)
	{
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
	
	public List<ASTNode> getExtraNodes()
	{
		return extraNodes;
	}
}
