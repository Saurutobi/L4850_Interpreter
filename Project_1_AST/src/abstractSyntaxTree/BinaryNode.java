package abstractSyntaxTree;

import java.util.List;

public abstract class BinaryNode implements ASTNode
{
	protected ASTNode leftNode;
	protected ASTNode rightNode;
	protected List<ASTNode> extraNodes;
	protected List<String> leftStrings;
	protected String leftString;
	protected String rightString;
	
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
	
	public BinaryNode(String leftString, ASTNode rightNode)
	{
		this.leftString = leftString;
		this.rightNode = rightNode;
	}
	
	public BinaryNode(ASTNode leftNode, String rightString)
	{
		this.leftNode = leftNode;
		this.rightString = rightString;
	}
	
	public BinaryNode(List<String> leftStrings, List<ASTNode> rightNodes)
	{
		this.leftStrings = leftStrings;
		this.extraNodes = rightNodes;
	}
	
	public ASTNode getLeftNode()
	{
		return leftNode;
	}
	
	public ASTNode getRightNode()
	{
		return rightNode;
	}
	
	public List<ASTNode> getExtraNodes()
	{
		return extraNodes;
	}
	
	public List<String> getLeftStrings()
	{
		return leftStrings;
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
