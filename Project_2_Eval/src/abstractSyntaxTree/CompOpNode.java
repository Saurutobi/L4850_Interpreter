package abstractSyntaxTree;

import Visitors.Visitor;

public class CompOpNode implements ASTNode
{
	private String compOp;
	
	public CompOpNode(String Operation)
	{
		this.compOp = Operation;
	}
	
	public String getCompOp()
	{
		return compOp;
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}