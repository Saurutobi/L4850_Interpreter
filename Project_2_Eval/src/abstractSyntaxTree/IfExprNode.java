package abstractSyntaxTree;

import visitors.Visitor;

public class IfExprNode extends TrinaryNode{
	
	public IfExprNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super(leftNode, centerNode, rightNode);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
