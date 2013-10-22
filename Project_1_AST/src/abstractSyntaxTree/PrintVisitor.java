package abstractSyntaxTree;

import java.util.List;

public class PrintVisitor implements Visitor
{
	@Override
	public Object visit(ProgramNode n)
	{
		n.getCenterNode().accept(this);
		return null;
	}

	@Override
	public Object visit(FunctionDefNode n)
	{
		System.out.print("defunc " + n.getID() + "(");
		if(n.getCenterNode() != null)
		{
			n.getCenterNode().accept(this);
		}
		System.out.print(")");
		n.getRightNode().accept(this);
		return null;
	}
	
	@Override
	public Object visit(IDListNode n)
	{
		System.out.print(n.getLeftString());
		System.out.print("test");
		for(int i = 0; i < n.getRightStrings().size(); i++)
		{
			System.out.print(" , " + n.getRightStrings().get(i));
		}
		return null;
	}
	
	@Override
	public Object visit(ClassDefNode n)
	{
		System.out.print("defclass " + n.getID() + "{");
		if(n.getCenterNode() != null)
		{
			n.getCenterNode().accept(this);
		}
		if(n.getRightNode() != null)
		{
			n.getRightNode().accept(this);
		}
		System.out.print("}");
		return null;
	}
	
	@Override
	public Object visit(ClassVarsNode n)
	{
		System.out.print("vars ");
		n.getCenterNode().accept(this);
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
	public Object visit(LoadFileNode n)
	{
		System.out.print("load " + n.getCenterString());
		return null;
	}
	
	@Override
	public Object visit(ExpressionListNode n)
	{
		System.out.print("{");
		for(int i = 0; i < n.getCenterList().size(); i++)
		{
			System.out.print(" " + n.getCenterList().get(i).accept(this));
		}
		System.out.print("}");
		return null;
	}
	
	@Override
	public Object visit(ExpressionBinaryNode n)
	{
		n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			System.out.print(" "); 
			n.getExtraNodes().get(i).accept(this);
		}
		return null;
	}

	@Override
	public Object visit(ExpressionUnaryNode n)
	{
		System.out.print("not ");
		n.getCenterNode().accept(this);
		return null;
	}
	
	@Override
	public Object visit(LogOpNode n)
	{
		System.out.print(" " + n.getToken() + " ");
		return null;
	}
	
	@Override
	public Object visit(CompExprNode n)
	{
		n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			System.out.print(" ");
			n.getExtraNodes().get(i).accept(this);
		}
		return null;
	}
	
	@Override
	public Object visit(CompOpNode n)
	{
		System.out.print(n.getCompOp());
		return null;
	}
	
	@Override
	public Object visit(AddExprNode n)
	{
		n.getLeftNode().accept(this);
		System.out.print(" ");
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			System.out.print(" ");
			n.getExtraNodes().get(i).accept(this);
		}
		return null;
	}
	
	@Override
	public Object visit(AddOpNode n)
	{
		System.out.print(" " + n.getToken() + " ");
		return null;
	}
	
	@Override
	public Object visit(MulExprNode n)
	{
		System.out.print(n.getLeftNode().accept(this));
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			System.out.print(" ");
			n.getExtraNodes().get(i).accept(this);
		}
		return null;
	}
	
	@Override
	public Object visit(MulOpNode n)
	{
		System.out.print(" " + n.getToken() + " ");
		return null;
	}
	
	@Override
	public Object visit(FactorNode n)
	{
		n.getLeftNode().accept(this);
		if(n.getRightNode() != null)
		{
			n.getRightNode().accept(this);
		}
		return null;
	}

	@Override
	public Object visit(OperandNode n)
	{
		if(n.isExpression())
		{
			System.out.print("(");
			n.getCenterNode().accept(this);
			System.out.print(")");
		}
		else
		{
			n.getCenterNode().accept(this);
		}
		return null;
	}

	@Override
	public Object visit(CallNode n)
	{
		System.out.print("-> ( ");
		if(n.getCenterNode() != null) 
		{
			n.getCenterNode().accept(this);
		}
		System.out.print(")");
		return null;
	}
	
	@Override
	public Object visit(ParamListNode n)
	{
		n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			System.out.print(", ");
			n.getExtraNodes().get(i).accept(this);
		}
		return null;
	}
	
	@Override
	public Object visit(VarRefNode n)
	{
		if(n.getLeftString() != null && n.getRightString() != null)
		{
			System.out.print(n.getLeftString() + "." + n.getRightString());
		}
		else if(n.getLeftString() != null)
		{
			System.out.print(n.getLeftString());
		}
		return null;
	}
	
	@Override
	public Object visit(ConstantNode n)
	{
		if(n.getCenterString() != null)
		{
			System.out.print(n.getCenterString());
		}
		else
		{
			n.getCenterNode().accept(this);
		}
		return null;
	}
	
	@Override
	public Object visit(ListNode n)
	{
		System.out.print("[");
		n.getCenterNode().accept(this);
		System.out.print("]");
		return null;
	}

	@Override
	public Object visit(ConstantListNode n)
	{
		n.getRightNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			System.out.print(", ");
			n.getExtraNodes().get(i).accept(this);
		}
		return null;
	}
	
	@Override
	public Object visit(NewExprNode n)
	{
		System.out.print("new " + n.getCenterString());
		return null;
	}
	
	@Override
	public Object visit(IfExprNode n)
	{
		System.out.print("if ");
		n.getLeftNode().accept(this);
		System.out.print(" then ");
		n.getCenterNode().accept(this);
		System.out.print(" else ");
		n.getRightNode().accept(this); 
		System.out.print(" fi");
		return null;
	}
	
	@Override
	public Object visit(FuncExprNode n)
	{
		System.out.print("func (");
		if(n.getLeftNode() != null)
		{
			System.out.print(n.getLeftNode().accept(this));
		}
		System.out.print(")");
		n.getRightNode().accept(this);
		return null;
	}
	
	@Override
	public Object visit(AssignExprNode n)
	{
		System.out.print("assign ");
		n.getLeftNode().accept(this);
		System.out.print(" to " + n.getRightString());
		return null;
	}
	
	@Override
	public Object visit(CondExprNode n)
	{
		System.out.print("cond ");
		n.getCenterNode();
		return null;
	}
	
	@Override
	public Object visit(CondClausesNode n)
	{
		for(int i = 0; i < n.getCenterList().size(); i++)
		{
			System.out.print("[");
			n.getCenterList().get(i).accept(this);
			i++;
			n.getCenterList().get(i).accept(this);
			System.out.print("] ");
		}
		return null;
	}
	
	@Override
	public Object visit(WithExprNode n)
	{
		System.out.print("with ( ");
		n.getLeftNode().accept(this);
		System.out.print(" )" );
		n.getRightNode().accept(this);
		return null;
	}
	
	@Override
	public Object visit(VariableDefsNode n)
	{
		for(int i = 0; i < n.getLeftStrings().size(); i++)
		{
			System.out.print("[" + n.getLeftStrings().get(i));
			n.getExtraNodes().get(i).accept(this);
			System.out.print("]");
		}
		return null;
	}
	
	@Override
	public Object visit(IDNode n)
	{
		System.out.print(n.getToken() + "fuck the police");
		return null;
	}
	@Override
	public Object visit(NullNode n)
	{
		System.out.print("mother fucking null node");
		return null;
	}
}
