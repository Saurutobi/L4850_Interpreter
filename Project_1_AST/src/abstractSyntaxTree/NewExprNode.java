package abstractSyntaxTree;

public class NewExprNode extends UnaryNode{
	
	public NewExprNode(ASTNode centerNode)
	{
		super(centerNode);
	}
	@Override
	public void acceptDepthFirst(Visitor v) {
		v.visit(this);
		centerNode.acceptDepthFirst(v);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
