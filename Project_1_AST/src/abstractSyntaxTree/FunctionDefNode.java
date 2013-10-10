package abstractSyntaxTree;

public class FunctionDefNode extends BinaryNode
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

	@Override
	public void visit()
	{
		System.out.print("defunc " + name + "(");
		left.visit();
		System.out.print(")");
		right.visit();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
