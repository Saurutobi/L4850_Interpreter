package abstractSyntaxTree;

import Visitors.Visitor;

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
