package abstractSyntaxTree;

public class PrintVisitor implements Visitor
{
	@Override
	public Object visit(FunctionDefNode n)
	{
		System.out.print("defunc " + n.getID() + "(");
		n.getCenterNode().accept(this);
		System.out.print(")");
		n.getRightNode().accept(this);
		return null;
	}

	IDLIST THING HERE
	
	@Override
	public Object visit(ClassDefNode n)
	{
		System.out.print("defclass " + n.getID() + "{");
		n.getCenterNode().accept(this);
		n.getRightNode().accept(this);
		System.out.print("}");
		return null;
	}
	
	@Override
	public Object visit(ClassVarsNode n)
	{
		System.out.print("vars " + n.getCenterNode().accept(this));
		return null;
	}
	
	@Override
	public Object visit(MethodsNode n)
	{
		System.out.print("METHOD" + n.getID() + "(");
		n.getCenterNode().accept(this);
		System.out.print(")");
		n.getRightNode().accept(this);
		return null;
	}
}
