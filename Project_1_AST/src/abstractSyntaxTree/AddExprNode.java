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

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

}
