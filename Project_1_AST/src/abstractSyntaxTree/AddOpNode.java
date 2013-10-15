package abstractSyntaxTree;

public class AddOpNode extends UnaryNode{
	
	public AddOpNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public void acceptDepthFirst(Visitor v) {
		v.visit(this);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
