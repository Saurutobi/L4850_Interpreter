package Visitors;

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

public interface Visitor
{
	//Done
	
	//Doublecheck .jj
	
	//DoubleCheck PrintVisitor
	public Object visit(ProgramNode n);
	public Object visit(FunctionDefNode n);
	public Object visit(IDListNode n);
	public Object visit(ClassDefNode n);
	public Object visit(ClassVarsNode n);
	public Object visit(MethodsListNode n);	
	public Object visit(MethodsNode n);
	public Object visit(LoadFileNode n);
	public Object visit(ExpressionListNode n);
	public Object visit(ExpressionBinaryNode n);
	public Object visit(ExpressionUnaryNode n);
	public Object visit(LogOpNode n);
	public Object visit(CompExprNode n);
	public Object visit(CompOpNode n);
	public Object visit(AddExprNode n);
	public Object visit(AddOpNode n);
	public Object visit(MulExprNode n);
	public Object visit(MulOpNode n);
	public Object visit(FactorNode n);
	public Object visit(OperandNode n);
	public Object visit(CallNode n);
	public Object visit(ParamListNode n);
	public Object visit(VarRefNode n);
	public Object visit(ConstantNode n);
	public Object visit(ListNode n);
	public Object visit(ConstantListNode n);
	public Object visit(NewExprNode n);
	public Object visit(FuncExprNode n);
	public Object visit(IfExprNode n);
	public Object visit(AssignExprNode n);
	public Object visit(CondExprNode n);
	public Object visit(CondClausesNode n);
	public Object visit(WithExprNode n);
	public Object visit(VariableDefsNode n);	
	public Object visit(IDNode n);
}
