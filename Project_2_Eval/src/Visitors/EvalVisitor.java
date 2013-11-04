package Visitors;

import util.BooleanValue;
import util.Value;
import abstractSyntaxTree.AddExprNode;
import abstractSyntaxTree.AddOpNode;
import abstractSyntaxTree.AssignExprNode;
import abstractSyntaxTree.CallNode;
import abstractSyntaxTree.ClassDefNode;
import abstractSyntaxTree.ClassVarsNode;
import abstractSyntaxTree.CompExprNode;
import abstractSyntaxTree.CompOpNode;
import abstractSyntaxTree.CondClausesNode;
import abstractSyntaxTree.CondExprNode;
import abstractSyntaxTree.ConstantListNode;
import abstractSyntaxTree.ConstantNode;
import abstractSyntaxTree.ExpressionBinaryNode;
import abstractSyntaxTree.ExpressionListNode;
import abstractSyntaxTree.ExpressionUnaryNode;
import abstractSyntaxTree.FactorNode;
import abstractSyntaxTree.FuncExprNode;
import abstractSyntaxTree.FunctionDefNode;
import abstractSyntaxTree.IDListNode;
import abstractSyntaxTree.IDNode;
import abstractSyntaxTree.IfExprNode;
import abstractSyntaxTree.ListNode;
import abstractSyntaxTree.LoadFileNode;
import abstractSyntaxTree.LogOpNode;
import abstractSyntaxTree.MethodsListNode;
import abstractSyntaxTree.MethodsNode;
import abstractSyntaxTree.MulExprNode;
import abstractSyntaxTree.MulOpNode;
import abstractSyntaxTree.NewExprNode;
import abstractSyntaxTree.OperandNode;
import abstractSyntaxTree.ParamListNode;
import abstractSyntaxTree.ProgramNode;
import abstractSyntaxTree.VarRefNode;
import abstractSyntaxTree.VariableDefsNode;
import abstractSyntaxTree.WithExprNode;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CompOpNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AddExprNode n) {
		try
		{

			String tempOperand;
			
			for(int i = 0; i < n.getExtraNodes().size(); i+=2)
			{
				tempOperand = (String) n.getExtraNodes().get(i).accept(this);
				if(tempOperand.compareTo("+") == 0)
				{
					
					
				}
				else
				{
					if(tempOperand.compareTo("-") == 0)
					{
						
						
					}
					else
					{
						throw(DeclareANewException)
					}
				}
			}
		}
		catch(DeclareANewException)
		{
			
		}
		catch(ClassCastException c)
		{
			
		}
		return null;
	}

	@Override
	public Object visit(AddOpNode n) {
		return n.getCenterString();
	}

	@Override
	public Object visit(MulExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MulOpNode n) {
		// TODO Auto-generated method stub
		return null;
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
