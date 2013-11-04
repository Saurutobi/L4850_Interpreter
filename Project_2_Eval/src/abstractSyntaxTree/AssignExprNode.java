package abstractSyntaxTree;

import Visitors.*;

public class AssignExprNode extends BinaryNode
{
	public AssignExprNode(ASTNode leftNode, String token)
	{
		super(leftNode, token);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
