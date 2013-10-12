package abstractSyntaxTree;

public class IfExprNode extends TrinaryNode{
	
	public IfExprNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super(leftNode, centerNode, rightNode);
	}

	@Override
	public void acceptDepthFirst(Visitor v) {
		//print if
		leftNode.acceptDepthFirst(v);
		//print then
		centerNode.acceptDepthFirst(v);
		//print else
		rightNode.acceptDepthFirst(v);		
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visit(this);
	}
	
}
