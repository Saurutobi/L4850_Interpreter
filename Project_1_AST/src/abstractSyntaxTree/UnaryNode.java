package abstractSyntaxTree;

import java.util.List;

public abstract class UnaryNode implements ASTNode
{
	protected ASTNode centerNode;
	protected List<ASTNode> centerList;
	
	public UnaryNode(List<ASTNode> centerList)
	{
		this.centerList = centerList;
	}
	
	public UnaryNode(ASTNode centerNode)
	{
		super();
		this.centerNode = centerNode;
	}
	
	public ASTNode getCenterNode()
	{
		return centerNode;
	}
	
	public List<ASTNode> getCenterList()
	{
		return centerList;
	}
}
