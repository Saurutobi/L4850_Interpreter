package abstractSyntaxTree;

import Visitors.*;

public class MethodsNode extends TrinaryNode
{
	public MethodsNode(String id, ASTNode center, ASTNode right)
	{
		super(id, center, right);
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}

