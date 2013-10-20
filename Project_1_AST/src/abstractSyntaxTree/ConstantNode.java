package abstractSyntaxTree;

public class ConstantNode implements ASTNode
{
	private String Token;
	private ASTNode centerNode;
	
	public ConstantNode(String name)
	{
		Token = name;
	}
	
	public ConstantNode(ASTNode centerNode)
	{
		this.centerNode = centerNode;
	}
	
	public String getToken()
	{
		return Token;
	}
	
	public ASTNode getCenterNode()
	{
		return centerNode;
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}