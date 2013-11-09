package abstractSyntaxTree;

import Visitors.*;

public class ListNode extends UnaryNode
{
	public ListNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
