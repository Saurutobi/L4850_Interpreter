package abstractSyntaxTree;

public class FunctionDefNode extends TrinaryNode
{
	String name;
	IDListNode left;
	ExpressionListNode right;
	
	public FunctionDefNode(ASTNode leftNode, ASTNode rightNode)
	{
		super(leftNode, rightNode);
		this.left = (IDListNode)leftNode;
		this.right = (ExpressionListNode)rightNode;
	}

	
	public void setName(String name)
	{
		this.name = name;
	}


	@Override
	public void acceptDepthFirst(Visitor v) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}
}
