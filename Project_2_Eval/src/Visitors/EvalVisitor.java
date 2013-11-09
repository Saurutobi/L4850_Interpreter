package Visitors;

import util.*;
import abstractSyntaxTree.*;

public class EvalVisitor implements Visitor{
	
	boolean useFloats;

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
		return n.getLeftNode().accept(this);
	}

	@Override
	public Object visit(ExpressionUnaryNode n) {
		BooleanValue temp = (BooleanValue) n.getCenterNode().accept(this);
		if(temp.getVal())
		{
			temp.setVal(false);
		}
		else
		{
			temp.setVal(true);
		}
		return temp.getVal();
	}

	@Override
	public Object visit(LogOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Object visit(CompExprNode n) {
		//System.out.print("Another Sucess\n");
		Value lv = null; 
		try
		{		
			useFloats = false;
			Object temp = n.getLeftNode().accept(this);
			if(temp == null)
			{
				return "";
			}
			if(temp instanceof IntValue)
			{
				//System.out.print("Int Value at Comp Expr Node\n");
				lv = (IntValue) temp;
			}
			else if(temp instanceof BooleanValue)
			{
				return temp;
			}
			else if(temp instanceof ListValue)
			{
				//System.out.print("That was a list dipshit");
			}
			else if(temp instanceof FloatValue)
			{
				//System.out.print("Float Value at Comp Expr Node\n");
				lv = (FloatValue) temp;
				useFloats = true;
			}
			else if(temp instanceof StringValue)
			{
				//System.out.print("That was a string dipshit");
			}
			
			BooleanValue rvHolder = new BooleanValue();
			
			String tempOperand;
			
			for(int i = 0; i < n.getExtraNodes().size();)
			{
				tempOperand = ((String) n.getExtraNodes().get(i).accept(this)).trim();
				if(tempOperand.compareTo("==") == 0)
				{
					if(useFloats){
						 if(((FloatValue)lv).getVal() == ((FloatValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						 {
							 rvHolder.setVal(true);
						 }
						 else
						 {
							 rvHolder.setVal(false);
						 }
					}
					else{						
						if(((IntValue)lv).getVal() == ((IntValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						{
							rvHolder.setVal(true);
						}
						else
						{
							rvHolder.setVal(false);
						}
					}
				}
				else if(tempOperand.compareTo(">") == 0){
					if(useFloats){
						 if(((FloatValue)lv).getVal() > ((FloatValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						 {
							 rvHolder.setVal(true);
						 }
						 else
						 {
							 rvHolder.setVal(false);
						 }
					}
					else{						
						if(((IntValue)lv).getVal() > ((IntValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						{
							rvHolder.setVal(true);
						}
						else
						{
							rvHolder.setVal(false);
						}
					}
				}
				else if(tempOperand.compareTo("<") == 0){
					if(useFloats){
						 if(((FloatValue)lv).getVal() < ((FloatValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						 {
							 rvHolder.setVal(true);
						 }
						 else
						 {
							 rvHolder.setVal(false);
						 }
					}
					else{						
						if(((IntValue)lv).getVal() < ((IntValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						{
							rvHolder.setVal(true);
						}
						else
						{
							rvHolder.setVal(false);
						}
					}
				}
				else if(tempOperand.compareTo(">=") == 0){
					if(useFloats){
						 if(((FloatValue)lv).getVal() >= ((FloatValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						 {
							 rvHolder.setVal(true);
						 }
						 else
						 {
							 rvHolder.setVal(false);
						 }
					}
					else{						
						if(((IntValue)lv).getVal() >= ((IntValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						{
							rvHolder.setVal(true);
						}
						else
						{
							rvHolder.setVal(false);
						}
					}
				}
				else if(tempOperand.compareTo("<=") == 0){
					if(useFloats){
						 if(((FloatValue)lv).getVal() <= ((FloatValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						 {
							 rvHolder.setVal(true);
						 }
						 else
						 {
							 rvHolder.setVal(false);
						 }
					}
					else{						
						if(((IntValue)lv).getVal() <= ((IntValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						{
							rvHolder.setVal(true);
						}
						else
						{
							rvHolder.setVal(false);
						}
					}
				}
				else if(tempOperand.compareTo("!=") == 0){
					if(useFloats){
						 if(((FloatValue)lv).getVal() != ((FloatValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						 {
							 rvHolder.setVal(true);
						 }
						 else
						 {
							 rvHolder.setVal(false);
						 }
					}
					else{						
						if(((IntValue)lv).getVal() != ((IntValue)n.getExtraNodes().get(i + 1).accept(this)).getVal())
						{
							rvHolder.setVal(true);
						}
						else
						{
							rvHolder.setVal(false);
						}
					}
				}
				else{
					//some fucking crazy shit goes here
				}
				
				return rvHolder;
			}			
		}
		catch(ClassCastException c)
		{
			//System.out.print("Shit Broke Yo\n");
		}

		//System.out.print("Made It Through CompExprNode\n");
		if(useFloats)
		{
			return ((FloatValue) lv);
		}
		else
		{
			return ((IntValue) lv);
		}
	}

	@Override
	public Object visit(CompOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Object visit(AddExprNode n) {
		//System.out.print("Add Expr Node Entered\n");
		try
		{
			Object temp = n.getLeftNode().accept(this);
			Value lv = null;
			if(temp instanceof IntValue)
			{
				//System.out.print("Add Node Int Value");
				lv = (IntValue) temp;
			}
			else if(temp instanceof BooleanValue)
			{
				return temp;
			}
			else if(temp instanceof ListValue)
			{
				//System.out.print("Add Expr Node List");
			}
			else if(temp instanceof FloatValue)
			{
				//System.out.print("Float Value in Add Expr Node");
				lv = (FloatValue) temp;
				useFloats = true;
			}
			else if(temp instanceof StringValue)
			{
				//System.out.print("String Value in Add Expr Node");
			}
			Value rvHolder = null;

			String tempOperand = "";
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				Object insideTemp = n.getExtraNodes().get(i + 1).accept(this);
				if(insideTemp instanceof FloatValue)
				{
					useFloats = true;
				}
				if(useFloats)
				{ 
					rvHolder = (FloatValue)insideTemp;
					tempOperand = (String) n.getExtraNodes().get(i).accept(this);
					if(tempOperand.compareTo("+") == 0)
					{
						((FloatValue) lv).setVal(((FloatValue) lv).getVal() + ((FloatValue)rvHolder).getVal());
					}
					else
					{
						if(tempOperand.compareTo("-") == 0)
						{
							((FloatValue) lv).setVal(((FloatValue) lv).getVal() - ((FloatValue)rvHolder).getVal());
						}
						else
						{
							throw(new BadSignError());
						}
					}
				}
				else
				{
					rvHolder = (IntValue)insideTemp;
					tempOperand = (String) n.getExtraNodes().get(i).accept(this);
					if(tempOperand.compareTo("+") == 0)
					{
						((IntValue) lv).setVal(((IntValue) lv).getVal() + ((IntValue)rvHolder).getVal());
					}
					else
					{
						if(tempOperand.compareTo("-") == 0)
						{
							((IntValue) lv).setVal(((IntValue) lv).getVal() - ((IntValue)rvHolder).getVal());
						}
						else
						{
							throw(new BadSignError());
						}
					}
				}
			}
			//System.out.print("Mul Expr About To Leave\n");
			if(useFloats)
			{
				return ((FloatValue) lv);
			}
			else
			{
				return ((IntValue) lv);
			}
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
	public Object visit(AddOpNode n) {
		return n.getCenterString();
	}

	@SuppressWarnings("null")
	@Override
	public Object visit(MulExprNode n) {
		//System.out.print("Mul Expr Node Entered\n");
		try
		{
			Object temp = n.getLeftNode().accept(this);
			Value lv = null;
			if(temp instanceof IntValue)
			{
				//System.out.print("Int Value in Mul Expr Node");
				lv = (IntValue) temp;
			}
			else if(temp instanceof BooleanValue)
			{
				return temp;
			}
			else if(temp instanceof ListValue)
			{
				//System.out.print("List Value in Muul Expr Node");
			}
			else if(temp instanceof FloatValue)
			{
				//System.out.print("Float value in Mul Expr Node");
				lv = (FloatValue) temp;
				useFloats = true;
			}
			else if(temp instanceof StringValue)
			{
				//System.out.print("String Value in Mul Expr Node");
			}
			Value rvHolder = null;

			String tempOperand = "";
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				Object insideTemp = n.getExtraNodes().get(i + 1).accept(this);
				if(insideTemp instanceof FloatValue)
				{
					useFloats = true;
				}
				if(useFloats)
				{ 
					rvHolder = (FloatValue)insideTemp;
					tempOperand = (String) n.getExtraNodes().get(i).accept(this);
					if(tempOperand.compareTo("*") == 0)
					{
						((FloatValue) lv).setVal(((FloatValue) lv).getVal() * ((FloatValue)rvHolder).getVal());
					}
					else
					{
						if(tempOperand.compareTo("/") == 0)
						{
							((FloatValue) lv).setVal(((FloatValue) lv).getVal() / ((FloatValue)rvHolder).getVal());
						}
						else
						{
							throw(new BadSignError());
						}
					}
				}
				else
				{
					rvHolder = (IntValue)insideTemp;
					tempOperand = (String) n.getExtraNodes().get(i).accept(this);
					if(tempOperand.compareTo("*") == 0)
					{
						((IntValue) lv).setVal(((IntValue) lv).getVal() * ((IntValue)rvHolder).getVal());
					}
					else
					{
						if(tempOperand.compareTo("/") == 0)
						{
							((IntValue) lv).setVal(((IntValue) lv).getVal() / ((IntValue)rvHolder).getVal());
						}
						else
						{
							throw(new BadSignError());
						}
					}
				}
			}
			//System.out.print("Mul Expr About To Leave\n");
			if(useFloats)
			{
				return ((FloatValue) lv);
			}
			else
			{
				return ((IntValue) lv);
			}
		}
		catch(BadSignError c)
		{
			System.out.print("Was Expecting * or /");
		}
		return -1337;
	}

	@Override
	public Object visit(MulOpNode n) {
		return n.getCenterString();
	} 	 

	@Override
	public Object visit(FactorNode n) {
		if(n.getRightNode() != null)
		{
			return n.getRightNode().accept(this);
		}
		else
		{
			return n.getLeftNode().accept(this);
		}
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
			if(n.getCenterString() != null)
			{
				String temp = n.getCenterString().trim();
				if(temp.compareTo("true") == 0)
				{
					return new BooleanValue(true);
				}
				else if(temp.compareTo("false") == 0)
				{
					return new BooleanValue(false);
				}
				else
				{
					try{
						return new IntValue(Integer.parseInt(temp));
					}
					catch (Exception e){}
					try{
						return new FloatValue(Float.parseFloat(temp + "f"));
					}
					catch (Exception e){}
				}
				return new StringValue(temp);
			}
		}
		catch(ClassCastException c)
		{
			System.out.print("Casting Exception in Constant Node");
		}
		//System.out.print("Constant Node About To Leave\n");
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
			System.out.println("Casting Error In If Expr Node");
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
		return n.getCenterNode().accept(this);
	}

	@Override
	public Object visit(CondClausesNode n) 
	{
		for(int i = 0; i < n.getCenterList().size(); i+=2)
		{
			BooleanValue Statement = (BooleanValue)n.getCenterList().get(i).accept(this);
			if(Statement.getVal())
			{
				return n.getCenterList().get(i + 1).accept(this);
			}
		}
		return "That cond was gay";
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
