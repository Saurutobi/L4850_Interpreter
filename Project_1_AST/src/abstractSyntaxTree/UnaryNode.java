package abstractSyntaxTree;

import java.util.List;

public abstract class UnaryNode implements ASTNode
{
	protected ASTNode centerNode;
	protected List<ASTNode> centerList;
	protected String centerString;
	
	public UnaryNode(List<ASTNode> centerList)
	{
		this.centerList = centerList;
	}
	
	public UnaryNode(String centerString)
	{
		this.centerString = centerString;
	}
	
	public UnaryNode(ASTNode centerNode)
	{
		this.centerNode = centerNode;
	}
	
	public ASTNode getCenterNode()
	{
		return centerNode;
	}
	
	public String getCenterString()
	{
		return centerString;
	}
	
	public List<ASTNode> getCenterList()
	{
		return centerList;
	}
}
