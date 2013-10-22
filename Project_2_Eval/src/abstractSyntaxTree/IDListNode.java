package abstractSyntaxTree;

import java.util.List;

import Visitors.Visitor;

public class IDListNode extends BinaryNode
{	
	public IDListNode(String id, List<String> ids)
	{
		super(id, ids);
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
