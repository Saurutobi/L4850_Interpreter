package abstractSyntaxTree;

import visitors.Visitor;

public class OperandNode extends UnaryNode
{
	private boolean isExpression = false;
	
	public OperandNode(ASTNode centerNode, boolean isExpression)
	{
		super(centerNode);
		this.isExpression = isExpression;
	}
	public OperandNode(ASTNode centerNode)
	{
		super(centerNode);
	}
	
	public boolean isExpression()
	{
		return isExpression;
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
