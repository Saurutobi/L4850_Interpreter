package abstractSyntaxTree;

public class AddOpNode implements ASTNode
{
	String plusMinus;
	
	public AddOpNode(String Token)
	{
		plusMinus = Token;
	}
	
	public String getToken()
	{
		return plusMinus;
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
