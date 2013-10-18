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
	public Object visit(LoadFileNode n)
	
	//ones that need work
	;
	public Object visit(CondExprNode n);
	
	//ones that need sorting and stuff
	public Object visit(FunctionDefNode n);
	
	//IDLIST THING HERE
	
	public Object visit(ClassDefNode n);
	public Object visit(ClassVarsNode n);
	public Object visit(MethodsNode n);
}
