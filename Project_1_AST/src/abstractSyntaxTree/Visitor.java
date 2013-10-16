package abstractSyntaxTree;

public interface Visitor
{
	public Object visit(FunctionDefNode n);
	
	IDLIST THING HERE
	
	public Object visit(ClassDefNode n);
	public Object visit(ClassVarsNode n);
	public Object visit(MethodsNode n);
}
