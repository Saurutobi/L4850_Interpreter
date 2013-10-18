package abstractSyntaxTree;

public class VarRefNode extends BinaryNode
{	
	public VarRefNode(String leftNode, String rightNode)
	{
		super(leftNode, rightNode);
	}
	
	@Override
	public void acceptDepthFirst(Visitor v) {
		leftNode.acceptDepthFirst(v);
		v.visit(this);
		rightNode.acceptDepthFirst(v);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}

