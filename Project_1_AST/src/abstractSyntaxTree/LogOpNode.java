package abstractSyntaxTree;

public class LogOpNode implements ASTNode{
	
	String AndOr;
	
	public LogOpNode(String Token)
	{
		AndOr = Token;
	}

	public String getToken()
	{
		return AndOr;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
