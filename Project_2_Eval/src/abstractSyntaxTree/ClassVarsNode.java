package abstractSyntaxTree;

import visitors.Visitor;

public class ClassVarsNode extends UnaryNode
{
	public ClassVarsNode(ASTNode centerNode)
	{
		super(centerNode);
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}