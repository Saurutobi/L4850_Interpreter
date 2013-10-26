package abstractSyntaxTree;

import visitors.Visitor;

public class LoadFileNode extends UnaryNode
{
	public LoadFileNode(String centerString)
	{
		super(centerString);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
