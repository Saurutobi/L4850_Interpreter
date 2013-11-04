package abstractSyntaxTree;

import Visitors.*;

public class FunctionDefNode extends TrinaryNode
{
	public FunctionDefNode(String id, ASTNode center, ASTNode right)
	{
		super(id, center, right);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
