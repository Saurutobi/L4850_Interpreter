package Visitors;

import util.*;
import abstractSyntaxTree.*;

public class EvalVisitor implements Visitor{

	//copied from print visitor
	@Override
	public Object visit(ProgramNode n)
	{
		return n.getCenterNode().accept(this);
	}

	//copied from print visitor
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
	
	//copied from print visitor
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

	//copied from print visitor
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
	public Object visit(ClassVarsNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MethodsListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MethodsNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LoadFileNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExpressionListNode n) {
		BooleanValue cv = (BooleanValue) n.getCenterNode().accept(this);
		if(cv.getVal())
		{
			cv.setVal(false);
		}
		else
		{
			cv.setVal(true);
		}
		return cv.getVal();
	}

	@Override
	public Object visit(ExpressionBinaryNode n) {
		try
		{
			
		}
		catch(ClassCastException c)
		{
			
		}
		return "gothere";
	}

	@Override
	public Object visit(ExpressionUnaryNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LogOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Object visit(CompExprNode n) {
		try
		{
			IntValue lv = (IntValue) n.getLeftNode().accept(this);
			BooleanValue rvHolder;
			
			String tempOperand;
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				tempOperand = (String) n.getExtraNodes().get(i).accept(this);
				if(tempOperand.compareTo("==") == 0)
				{
					
				}
				else if(tempOperand.compareTo(">") == 0){
					
				}
				else if(tempOperand.compareTo("<") == 0){
					
				}
				else if(tempOperand.compareTo(">=") == 0){
					
				}
				else if(tempOperand.compareTo("<=") == 0){
					
				}
				else if(tempOperand.compareTo("!=") == 0){
					
				}
				else{
					
				}
			}
		}
		catch(ClassCastException c)
		{
			
		}
		return null;
	}

	@Override
	public Object visit(CompOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Integer visit(AddExprNode n) {
		try
		{
			IntValue lv = (IntValue)n.getLeftNode().accept(this);
			IntValue rvHolder;

			String tempOperand;
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				tempOperand = (String) n.getExtraNodes().get(i).accept(this);
				if(tempOperand.compareTo("+") == 0)
				{
					rvHolder = (IntValue) n.getExtraNodes().get(i + 1).accept(this);
					lv.setVal(lv.getVal() + rvHolder.getVal());
				}
				else
				{
					if(tempOperand.compareTo("-") == 0)
					{
						rvHolder = (IntValue) n.getExtraNodes().get(i + 1).accept(this);
						lv.setVal(lv.getVal() - rvHolder.getVal());
					}
					else
					{
						throw(new BadSignError());
					}
				}
			}
			
			return lv.getVal();
		}
		catch(BadSignError c)
		{
			System.out.print("Was Expecting + or -");
		}
		catch(ClassCastException c)
		{
			System.out.println("Casting Error");
		}
		return -1337;
	}

	@Override
	public Object visit(AddOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Object visit(MulExprNode n) {
		try
		{
			IntValue lv = (IntValue)n.getLeftNode().accept(this);
			IntValue rvHolder;

			String tempOperand;
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				tempOperand = (String) n.getExtraNodes().get(i).accept(this);
				if(tempOperand.compareTo("*") == 0)
				{
					rvHolder = (IntValue) n.getExtraNodes().get(i + 1).accept(this);
					lv.setVal(lv.getVal() * rvHolder.getVal());
				}
				else
				{
					if(tempOperand.compareTo("/") == 0)
					{
						rvHolder = (IntValue) n.getExtraNodes().get(i + 1).accept(this);
						lv.setVal(lv.getVal() / rvHolder.getVal());
					}
					else
					{
						throw(new BadSignError());
					}
				}
			}
			
			return lv.getVal();
		}
		catch(BadSignError c)
		{
			System.out.print("Was Expecting + or -");
		}
		catch(ClassCastException c)
		{
			System.out.println("Casting Error");
		}
		
		//something went wrong
		return -1337;
	}

	@Override
	public Object visit(MulOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Object visit(FactorNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OperandNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CallNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ParamListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VarRefNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ConstantNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ConstantListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NewExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(IfExprNode n) {
		try{
			BooleanValue lv = (BooleanValue)n.getLeftNode().accept(this);
	
			if(lv.getVal())
			{
				n.getCenterNode().accept(this);
			}
			else
			{
				n.getRightNode().accept(this);
			}
		
		}
		catch (ClassCastException c)
		{
			System.out.println("Casting Error");
		}
		
		return null;
	}
	@Override
	public Object visit(AssignExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CondExprNode n) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CondClausesNode n) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WithExprNode n) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VariableDefsNode n) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IDNode n) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
