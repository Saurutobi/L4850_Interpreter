package abstractSyntaxTree;

public interface Visitor
{
	//I'm bad at sorting we will have to look over these
	
	//ones that work in theory
	public Object visit(LogOpNode n);
	public Object visit(AddOpNode n);
	public Object visit(MulOpNode n);
	public Object visit(IDNode n);
	public Object visit(IfExprNode n);
	public Object visit(LoadFileNode n);
	public Object visit(NewExprNode n);
	
	//ones that need work
	public Object visit(CompOpNode n);
	public Object visit(VarRefNode n);
	public Object visit(CondExprNode n);
	public Object visit(AddExprNode n);
	//ones that need sorting and stuff
	public Object visit(FunctionDefNode n);
	
	public Object visit(IDListNode n);
	
	public Object visit(ClassDefNode n);
	public Object visit(ClassVarsNode n);
	public Object visit(MethodsNode n);
	public Object visit(ExpressionBinaryNode n);
	public Object visit(ExpressionUnaryNode n);
	public Object visit(ExpressionListNode n);
}
