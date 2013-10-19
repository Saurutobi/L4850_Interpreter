package abstractSyntaxTree;

public class ConstantListNode extends BinaryNode{
	
	public ConstantListNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode,rightNode);
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}