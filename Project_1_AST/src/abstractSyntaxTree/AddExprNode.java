package abstractSyntaxTree;

public class AddExprNode extends BinaryNode{
	
	public AddExprNode(ASTNode leftNode, ASTNode rightNode)
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
