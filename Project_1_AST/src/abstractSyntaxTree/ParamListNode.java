package abstractSyntaxTree;

public class ParamListNode extends BinaryNode{

	public ParamListNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode,rightNode);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
}
