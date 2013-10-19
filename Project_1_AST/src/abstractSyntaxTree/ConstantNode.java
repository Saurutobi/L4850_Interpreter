package abstractSyntaxTree;

public class ConstantNode implements ASTNode
{
	private String Token;
	
	public ConstantNode(String name)
	{
		Token = name;
	}
	public String getToken()
	{
		return Token;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}