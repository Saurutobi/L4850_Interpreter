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

	//IDLIST THING HERE
	
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

	@Override
	public Object visit(LogOpNode n) {
		System.out.print(" " + n.getToken() + " ");
		return null;
	}

	@Override
	public Object visit(AddOpNode n) {
		System.out.print(" " + n.getToken() + " ");
		return null;
	}

	@Override
	public Object visit(MulOpNode n) {
		System.out.print(" " + n.getToken() + " ");
		return null;
	}

	@Override
	public Object visit(IDNode n) {
		System.out.print(n.getToken());
		return null;
	}

	@Override
	public Object visit(IfExprNode n) {
		System.out.print("if " + n.FirstExpression() + " then " + n.SecondExpression() + " else " + n.ThirdExpression() + " fi");
		return null;
	}

	@Override
	public Object visit(LoadFileNode n) {
		System.out.print("load " + n.getFilePath());
		return null;
	}

	@Override
	public Object visit(CondExprNode n) {
		//this may be wrong here we may need to do another method in 
		// this class to do the condition clauses
		System.out.print("cond " + n.getCenterNode());
		return null;
	}
}
