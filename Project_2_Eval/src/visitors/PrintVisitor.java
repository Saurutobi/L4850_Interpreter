package visitors;

import visitors.Visitor;
import abstractSyntaxTree.*;

public class PrintVisitor implements Visitor
{
	@Override
	public Object visit(ProgramNode n)
	{
		return n.getCenterNode().accept(this);
	}

	@Override
	public Object visit(FunctionDefNode n)
	{
		String out = "defunc " + n.getID() + "(";
		if(n.getCenterNode() != null)
		{
			out += (String)n.getCenterNode().accept(this);
		}
		out += ")" + (String)n.getRightNode().accept(this);
		return out;
	}
	
	@Override
	public Object visit(IDListNode n)
	{
		String out = n.getLeftString();
		for(int i = 0; i < n.getRightStrings().size(); i++)
		{
			out += ", " + n.getRightStrings().get(i);
		}
		return out;
	}
	
	@Override
	public Object visit(ClassDefNode n)
	{
		String out = "defclass " + n.getID() + "{";
		if(n.getCenterNode() != null)
		{
			out += (String)n.getCenterNode().accept(this);
		}
		if(n.getRightNode() != null)
		{
			out += (String)n.getRightNode().accept(this);
		}
		out += "}";
		return out;
	}
	
	@Override
	public Object visit(ClassVarsNode n)
	{
		return "vars "+ (String)n.getCenterNode().accept(this);
	}

	@Override
	public Object visit(MethodsListNode n)
	{
		String out = "";
		for(int i = 0; i < n.getCenterList().size(); i++)
		{
			out += (String)n.getCenterList().get(i).accept(this);
		}
		return out;
	}
	
	@Override
	public Object visit(MethodsNode n)
	{
		String out = "method " + n.getID() + "(";
		out += (String)n.getCenterNode().accept(this);
		out += ")";
		out += (String)n.getRightNode().accept(this);
		return out;
	}

	@Override
	public Object visit(LoadFileNode n)
	{
		return "load " + n.getCenterString();
	}
	
	@Override
	public Object visit(ExpressionListNode n)
	{
		String out = "{";
		for(int i = 0; i < n.getCenterList().size(); i++)
		{
			out += (String)n.getCenterList().get(i).accept(this);
		}
		out += "}";
		return out;
	}
	
	@Override
	public Object visit(ExpressionBinaryNode n)
	{
		String out = (String)n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			out += n.getExtraNodes().get(i).accept(this);
		}
		return out;
	}

	@Override
	public Object visit(ExpressionUnaryNode n)
	{
		return "not " + (String)n.getCenterNode().accept(this);
	}
	
	@Override
	public Object visit(LogOpNode n)
	{
		return n.getCenterString() + " ";
	}
	
	@Override
	public Object visit(CompExprNode n)
	{
		String out = (String)n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			out += " " + (String)n.getExtraNodes().get(i).accept(this);
		}
		return out;
	}
	
	@Override
	public Object visit(CompOpNode n)
	{
		return n.getCenterString();
	}
	
	@Override
	public Object visit(AddExprNode n)
	{
		String out = (String)n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			out += (String)n.getExtraNodes().get(i).accept(this);
		}
		return out;
	}
	
	@Override
	public Object visit(AddOpNode n)
	{
		return " " + n.getCenterString() + " ";
	}
	
	@Override
	public Object visit(MulExprNode n)
	{
		String out = (String)n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			out += " " + (String)n.getExtraNodes().get(i).accept(this);
		}
		return out;
	}
	
	@Override
	public Object visit(MulOpNode n)
	{
		return " " + n.getCenterString() + " ";
	}
	
	@Override
	public Object visit(FactorNode n)
	{
		String out = (String)n.getLeftNode().accept(this);
		if(n.getRightNode() != null)
		{
			out += (String)n.getRightNode().accept(this);
		}
		return out;
	}

	@Override
	public Object visit(OperandNode n)
	{
		if(n.isExpression())
		{
			return "(" + (String)n.getCenterNode().accept(this) + ")";
		}
		else
		{
			return n.getCenterNode().accept(this);
		}
	}

	@Override
	public Object visit(CallNode n)
	{
		String out = "->(";
		if(n.getCenterNode() != null) 
		{
			out += (String)n.getCenterNode().accept(this);
		}
		out +=")";
		return out;
	}
	
	@Override
	public Object visit(ParamListNode n)
	{
		String out = (String)n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			out += ", " + (String)n.getExtraNodes().get(i).accept(this);
		}
		return out;
	}
	
	@Override
	public Object visit(VarRefNode n)
	{
		if(n.getRightString() != null && n.getLeftString() != null)
		{
			return n.getLeftString() + "." + n.getRightString();
		}
		else if(n.getLeftString() != null)
		{
			return n.getLeftString();
		}
		else
		{
			return "--VariableReferenceIsNull--";
		}
	}
	
	@Override
	public Object visit(ConstantNode n)
	{
		if(n.getCenterString() != null)
		{
			return n.getCenterString();
		}
		else
		{
			return n.getCenterNode().accept(this);
		}
	}
	
	@Override
	public Object visit(ListNode n)
	{
		return "[" + (String)n.getCenterNode().accept(this) + "]";
	}

	@Override
	public Object visit(ConstantListNode n)
	{
		String out = (String)n.getLeftNode().accept(this);
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			out += ", " + (String)n.getExtraNodes().get(i).accept(this);
		}
		return out;
	}
	
	@Override
	public Object visit(NewExprNode n)
	{
		return "new " + n.getCenterString();
	}
	
	@Override
	public Object visit(IfExprNode n)
	{
		String out = "if " + (String)n.getLeftNode().accept(this) + " then ";
		out += (String)n.getCenterNode().accept(this) + " else ";
		out += (String)n.getRightNode().accept(this) + " fi";
		return out;
	}
	
	@Override
	public Object visit(FuncExprNode n)
	{
		String out = "func (";
		if(n.getLeftNode() != null)
		{
			out += (String)n.getLeftNode().accept(this);
		}
		out += ") " + (String)n.getRightNode().accept(this);
		return out;
	}
	
	@Override
	public Object visit(AssignExprNode n)
	{
		return "assign " + (String)n.getLeftNode().accept(this) + " to " + n.getRightString();
	}
	
	@Override
	public Object visit(CondExprNode n)
	{
		return "cond " + (String)n.getCenterNode().accept(this);
	}
	
	@Override
	public Object visit(CondClausesNode n)
	{
		String out = "";
		for(int i = 0; i < n.getCenterList().size(); i++)
		{
			out += "{" + (String)n.getCenterList().get(i).accept(this) + " ";
			i++;
			out += (String)n.getCenterList().get(i).accept(this) + "}";
		}
		return out;
	}
	
	@Override
	public Object visit(WithExprNode n)
	{
		return "with (" + (String)n.getLeftNode().accept(this) + ") " + (String)n.getRightNode().accept(this);
	}
	
	@Override
	public Object visit(VariableDefsNode n)
	{
		String out = "";
		for(int i = 0; i < n.getLeftStrings().size(); i++)
		{
			out += "[" + n.getLeftStrings().get(i) + " ";
			out += (String)n.getExtraNodes().get(i).accept(this) + "]";
		}
		return out;
	}
	
	@Override
	public Object visit(IDNode n)
	{
		return n.getToken();
	}
}
