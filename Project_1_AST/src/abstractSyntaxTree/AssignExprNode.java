package abstractSyntaxTree;

public class AssignExprNode extends BinaryNode{
	
	public AssignExprNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode, rightNode);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}
