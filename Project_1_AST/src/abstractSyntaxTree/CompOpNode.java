package abstractSyntaxTree;

public class CompOpNode implements ASTNode{
	
	String CompOp;
	
	public CompOpNode(String Operation)
	{
		CompOp = Operation;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	public String getCompOp()
	{
		return CompOp;
	}
	

}
