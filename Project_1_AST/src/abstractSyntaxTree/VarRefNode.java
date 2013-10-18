package abstractSyntaxTree;

public class VarRefNode extends BinaryNode
{	
	public VarRefNode(String leftString, String rightString)
	{
		super(leftString, rightString);
	}
	public VarRefNode(String leftString)
	{
		super(leftString, null);
	}
	
//	@Override
//	public void acceptDepthFirst(Visitor v) {
//		leftNode.acceptDepthFirst(v);
//		v.visit(this);
//		rightNode.acceptDepthFirst(v);
//	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}

