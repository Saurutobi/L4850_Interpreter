package abstractSyntaxTree;

public class MulOpNode extends UnaryNode{
	
	public MulOpNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}

	@Override
	public void acceptDepthFirst(Visitor v) {
		v.visit(this);
	}
	

}
