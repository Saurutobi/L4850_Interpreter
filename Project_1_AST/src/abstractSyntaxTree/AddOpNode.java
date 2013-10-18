package abstractSyntaxTree;

public class AddOpNode implements ASTNode{
	
	String PlusMinus;
	
	public AddOpNode(String Token)
	{
		PlusMinus = Token;
	}

//	@Override
//	public void acceptDepthFirst(Visitor v) {
//		v.visit(this);
//	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	public String getToken()
	{
		return PlusMinus;
	}
}
