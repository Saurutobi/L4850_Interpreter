package abstractSyntaxTree;

public class LogOpNode implements ASTNode
{
	private String andOr;
	
	public LogOpNode(String Token)
	{
		this.andOr = Token;
	}

	public String getToken()
	{
		return andOr;
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
