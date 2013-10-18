package abstractSyntaxTree;

public class AddExprNode extends TrinaryNode{
	
	//i think this needs to be a trinary node because
	// there is a left operand to add
	// there is a center either add or subtract
	// there is a right operand to add
	
	public AddExprNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super(leftNode, centerNode, rightNode);
	}
// this one will need some work for sure
//
//	@Override
//	public void acceptDepthFirst(Visitor v) {
//		leftNode.acceptDepthFirst(v);
//		centerNode.acceptDepthFirst(v);
//		rightNode.acceptDepthFirst(v);
//	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}
