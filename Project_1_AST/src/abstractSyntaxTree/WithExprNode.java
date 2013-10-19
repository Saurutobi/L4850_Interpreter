package abstractSyntaxTree;

public class WithExprNode extends BinaryNode{

	WithExprNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode,rightNode);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
