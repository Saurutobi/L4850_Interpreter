package abstractSyntaxTree;

public class MulExprNode extends TrinaryNode{

	public MulExprNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super(leftNode, centerNode, rightNode);
	}


	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}
