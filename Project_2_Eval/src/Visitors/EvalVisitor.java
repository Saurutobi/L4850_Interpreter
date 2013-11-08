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
		System.out.print("Made It Here\n");
		return n.getLeftNode().accept(this);
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
		//System.out.print("Another Sucess\n");
		try
		{
			IntValue lv = new IntValue(Integer.parseInt("" + n.getLeftNode().accept(this)));
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
			return "" + lv.getVal();
		}
		catch(ClassCastException c)
		{
			System.out.print("Shit Broke Yo\n");
		}

		//System.out.print("Made It Through CompExprNode\n");
		return "shit";
	}

	@Override
	public Object visit(CompOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Integer visit(AddExprNode n) {
		//zzSystem.out.print("Add ExprNode Entered\n");
		try
		{
			IntValue lv = new IntValue(Integer.parseInt("" + n.getLeftNode().accept(this)));
			IntValue rvHolder = new IntValue();

			String tempOperand;
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				tempOperand = (String) n.getExtraNodes().get(i).accept(this);
				if(tempOperand.compareTo("+") == 0)
				{
					rvHolder.setVal(Integer.parseInt("" + n.getExtraNodes().get(i + 1).accept(this)));
					lv.setVal(lv.getVal() + rvHolder.getVal());
				}
				else
				{
					if(tempOperand.compareTo("-") == 0)
					{
						rvHolder.setVal(Integer.parseInt("" + n.getExtraNodes().get(i + 1).accept(this)));
						lv.setVal(lv.getVal() - rvHolder.getVal());
					}
					else
					{
						throw(new BadSignError());
					}
				}
			}
			//System.out.print("About to leave Add Expr Node\n");
			return lv.getVal();
		}
		catch(BadSignError c)
		{
			System.out.print("Was Expecting + or -");
		}
		//catch(ClassCastException c)
		//{
		//	System.out.println("Bitch Titties");
		//}
		return -1337;
	}

	@Override
	public Object visit(AddOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Object visit(MulExprNode n) {
		//System.out.print("Mul Expr Node Entered\n");
		try
		{
			Object temp = n.getLeftNode().accept(this);
			if(temp instanceof IntValue)
			{
				System.out.print("SHIT FUCKING WORKED");
				IntValue lv = new IntValue(Integer.parseInt("" + temp));
			}
			else if(temp instanceof BooleanValue)
			{
				System.out.print("That was a bool dipshit");
			}
			else if(temp instanceof ListValue)
			{
				System.out.print("That was a list dipshit");
			}
			else if(temp instanceof FloatValue)
			{
				System.out.print("We can handle floats");
			}
			else if(temp instanceof StringValue)
			{
				System.out.print("That was a string dipshit");
			}
			IntValue rvHolder = new IntValue();

			String tempOperand = "";
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				tempOperand = (String) n.getExtraNodes().get(i).accept(this);
				if(tempOperand.compareTo("*") == 0)
				{
					rvHolder.setVal(Integer.parseInt("" + n.getExtraNodes().get(i + 1).accept(this)));
					lv.setVal(lv.getVal() * rvHolder.getVal());
				}
				else
				{
					if(tempOperand.compareTo("/") == 0)
					{
						rvHolder.setVal(Integer.parseInt("" + n.getExtraNodes().get(i + 1).accept(this)));
						lv.setVal(lv.getVal() / rvHolder.getVal());
					}
					else
					{
						throw(new BadSignError());
					}
				}
			}
			//System.out.print("Mul Expr About To Leave\n");
			return lv.getVal();
		}
		catch(BadSignError c)
		{
			System.out.print("Was Expecting + or -");
		}
		//catch(ClassCastException c)
		//{
			//System.out.println("Titties Bitch");
		//}
		
		//something went wrong
		return -1337;
	}

	@Override
	public Object visit(MulOpNode n) {
		return n.getCenterString();
	} 	 

	@Override
	public Object visit(FactorNode n) {
		//System.out.print("Factor Node Entered\n");
		try
		{
			//this one will be tricky to handle because it can have a call in it too
			
		}
		catch(ClassCastException c)
		{
			
		}
		//System.out.print("Mul Expr Node About To Leave\n");
		return n.getLeftNode().accept(this);
	}

	@Override
	public Object visit(OperandNode n) {
		return n.getCenterNode().accept(this);
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
	public Value visit(ConstantNode n) {
		//System.out.print("Constant Node Entered\n");
		try
		{
			//there are gunna be a lot of different casts here but for now im assuming they are
			//  going to be int numbers so that i can get fucking addition working
			int temp = Integer.parseInt(n.getCenterString());
			return new IntValue(temp);
		}
		catch(ClassCastException c)
		{
			System.out.print("shits broke yo");
		}
		//System.out.print("Constant Node About To Leave\n");
		return new IntValue(-1337);
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
		System.out.print("IDNode Entered\n");
		int tempValue = (Integer.parseInt(n.getToken()));
		return tempValue;
	}

}
