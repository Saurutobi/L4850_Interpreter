package abstractSyntaxTree;

public class NewExprNode extends UnaryNode{
	
	public NewExprNode(ASTNode centerNode)
	{
		super(centerNode);
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
