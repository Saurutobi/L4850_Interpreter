package abstractSyntaxTree;

import java.util.List;

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

	@Override
	public Object visit(VarRefNode n) {
		if(n.getRightNode() != null)
		{
			System.out.print(n.getLeftString());
		}
		else
		{
			System.out.print(n.getLeftString() + "." + n.getRightString());
		}
		return null;
	}
	
	@Override
	public Object visit(AddExprNode n) {
		System.out.print(n.getLeftNode().accept(this) + " " + n.getCenterNode().accept(this) + " " + n.getRightNode().accept(this));
		return null;
	}

	@Override
	public Object visit(CompOpNode n) {
		System.out.print(n.getCompOp());
		return null;
	}

	@Override
	public Object visit(IDListNode n) {
		System.out.print(n.getID());
		for(int i = 0; i < n.getExtras().size(); i++)
		{
			System.out.print(" , " + n.getExtras().get(i));
		}
		return null;
	}

	@Override
	public Object visit(ExpressionBinaryNode n) {
		System.out.print(n.getFirst());
		for(int i = 0; i < n.getExtras().size(); i++)
		{
			System.out.print(" " + n.get);
		}
		return null;
	}
}
