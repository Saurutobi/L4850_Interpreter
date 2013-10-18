package abstractSyntaxTree;

public class MulOpNode implements ASTNode{
	
	private String TimesDivide;
	
	public MulOpNode(String Token)
	{
		TimesDivide = Token;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	public String getToken()
	{
		return TimesDivide;
	}
}
