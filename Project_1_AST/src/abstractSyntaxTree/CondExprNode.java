package abstractSyntaxTree;

public class CondExprNode extends UnaryNode{

	public CondExprNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public void acceptDepthFirst(Visitor v) {
		//write cond
		centerNode.acceptDepthFirst(v);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
