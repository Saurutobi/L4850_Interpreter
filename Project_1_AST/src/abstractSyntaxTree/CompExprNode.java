package abstractSyntaxTree;

public class CompExprNode extends TrinaryNode{
	
	public CompExprNode(ASTNode left, ASTNode center, ASTNode right)
	{
		super(left,center,right);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}
