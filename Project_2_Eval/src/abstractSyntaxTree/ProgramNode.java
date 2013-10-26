package abstractSyntaxTree;

import visitors.Visitor;

public class ProgramNode extends UnaryNode
{
	public ProgramNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
