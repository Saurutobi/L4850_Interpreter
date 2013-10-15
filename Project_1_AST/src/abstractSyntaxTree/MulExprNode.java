package abstractSyntaxTree;

public class MulExprNode extends BinaryNode{

	public MulExprNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode, rightNode);
	}
	@Override
	public void acceptDepthFirst(Visitor v) {
		leftNode.acceptDepthFirst(v);
		v.visit(this);
		rightNode.acceptDepthFirst(v);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}
