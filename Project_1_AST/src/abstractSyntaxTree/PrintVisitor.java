package abstractSyntaxTree;

public class PrintVisitor implements Visitor
{

	@Override
	public Object visit(FunctionDefNode n)
	{
		System.out.print("defunc " + n.id + "(");
		n.centerNode.accept(this);
		System.out.print(")");
		n.rightNode.accept(this);
		return null;
	}

	
	
	

}
