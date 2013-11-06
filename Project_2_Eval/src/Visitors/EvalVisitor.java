package Visitors;

import util.*;
import abstractSyntaxTree.*;

public class EvalVisitor implements Visitor{

	@Override
	public Object visit(ProgramNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FunctionDefNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IDListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ClassDefNode n) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExpressionBinaryNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExpressionUnaryNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LogOpNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CompExprNode n) {
		try
		{
			IntValue lv = (IntValue) n.getLeftNode().accept(this);
			IntValue rvHolder;
			
			String tempOperand;
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				switch(tempOperand){
				case 
				
				//there is no such thing as a switch in java
				//for strings so we need to find a way to represent
				// all the different outcomes for less than greater than
				//etc here
				
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
