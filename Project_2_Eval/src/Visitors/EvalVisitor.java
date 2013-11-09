package Visitors;

import java.util.ArrayList;

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
		if(n.getExtraNodes().size() > 0)
		{
			try
			{
				BooleanValue left = (BooleanValue) n.getLeftNode().accept(this);
				String AndOr = (String) n.getExtraNodes().get(0).accept(this);
				BooleanValue right = (BooleanValue) n.getExtraNodes().get(1).accept(this);
				if(AndOr.compareTo("&&") == 0)
				{
					return new BooleanValue((left.getVal() && right.getVal()));
				}
				else if(AndOr.compareTo("||") == 0)
				{
					return new BooleanValue((left.getVal() || right.getVal()));
				}	
			}
			catch(ClassCastException c)
			{
				System.out.print("Need a boolean to compare\n");
				return "";
			}
		}
		else
		{
			return n.getLeftNode().accept(this);
	
		}
		return null;
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
				return temp;
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
				return temp;
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
				if(n.getExtraNodes().size() > 0){
					System.out.print("Cannot add/subtract with a boolean\n");
					return null;
				}
				else{
					return temp;
				}
			}
			else if(temp instanceof ListValue)
			{				
				if(n.getExtraNodes().size() > 0){
				System.out.print("Cannot add/subtract with a list\n");
				return null;
			}
			else{
				return temp;
			}
			}
			else if(temp instanceof FloatValue)
			{
				lv = (FloatValue) temp;
				useFloats = true;
			}
			else if(temp instanceof StringValue)
			{
				if(n.getExtraNodes().size() > 0){
					System.out.print("Cannot add/subtract with a string\n");
					return null;
				}
				else{
					return temp;
				}
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
				else if(insideTemp instanceof StringValue)
				{
					System.out.print("Cannot add/subtract with a String\n");
					return null;
				}
				else if(insideTemp instanceof ListValue)
				{
					System.out.print("Cannot add/subtract with a List\n");
					return null;
				}
				else if(insideTemp instanceof BooleanValue)
				{
					System.out.print("Cannot add/subtract with a Boolean\n");
					return null;
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
				return (FloatValue) lv;
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
				if(n.getExtraNodes().size() > 0){
					System.out.print("Cannot divide/multiply with a boolean\n");
					return null;
				}
				else{
					return temp;
				}
			}
			else if(temp instanceof ListValue)
			{				
				if(n.getExtraNodes().size() > 0){
				System.out.print("Cannot divide/multiply with a list\n");
				return null;
			}
			else{
				return temp;
			}
			}
			else if(temp instanceof FloatValue)
			{
				lv = (FloatValue) temp;
				useFloats = true;
			}
			else if(temp instanceof StringValue)
			{
				if(n.getExtraNodes().size() > 0){
					System.out.print("Cannot divide/multiply with a string\n");
					return null;
				}
				else{
					return temp;
				}
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
				else if(insideTemp instanceof StringValue)
				{
					System.out.print("Cannot divide/multiply with a String\n");
					return null;
				}
				else if(insideTemp instanceof ListValue)
				{
					System.out.print("Cannot divide/multiply with a List\n");
					return null;
				}
				else if(insideTemp instanceof BooleanValue)
				{
					System.out.print("Cannot divide/multiply with a Boolean\n");
					return null;
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
		//TODO SHIT HERE
		return null;
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
			else
			{
				@SuppressWarnings("unchecked")
				ArrayList<Value> temp = (ArrayList<Value>)(n.getCenterNode().accept(this));
				return new ListValue(temp);
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
	public Object visit(ListNode n)
	{
		return n.getCenterNode().accept(this);
	}

	@Override
	public Object visit(ConstantListNode n)
	{
		ArrayList<Value> temp = new ArrayList<Value>();
		temp.add((Value)n.getLeftNode().accept(this));
		for(int i = 0; i < n.getExtraNodes().size(); i++)
		{
			temp.add( (Value)n.getExtraNodes().get(i).accept(this));
		}
		return temp;
	}
	
	@Override
	public Object visit(NewExprNode n)
	{
		return "new " + n.getCenterString();
	}

	@Override
	public Object visit(FuncExprNode n)
	{
		return null;
	}

	@Override
	public Object visit(IfExprNode n) {
		try{
			BooleanValue lv = (BooleanValue)n.getLeftNode().accept(this);
	
			if(lv.getVal())
			{
				return n.getCenterNode().accept(this);
			}
			else
			{
				return n.getRightNode().accept(this);
			}
		
		}
		catch (ClassCastException c)
		{
			System.out.println("Casting Error In If Expr Node");
		}
		
		return null;
	}
	
	@Override
	public Object visit(AssignExprNode n)
	{
		return "assign " + (String)n.getLeftNode().accept(this) + " to " + n.getRightString();
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
			Object temp = n.getCenterList().get(i).accept(this);
			if(temp instanceof BooleanValue)
			{
				BooleanValue Statement = (BooleanValue) temp;
				if(Statement.getVal())
				{
					return n.getCenterList().get(i + 1).accept(this);
				}
			}
			else
			{
				System.out.print("Expected a Boolean Exception\n");
			}
		}
		return null;
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
		System.out.print("IDNode Entered\n");
		int tempValue = (Integer.parseInt(n.getToken()));
		return tempValue;
	}

}
