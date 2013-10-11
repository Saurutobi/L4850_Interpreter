package abstractSyntaxTree;

public interface Visitor {
	public Object visit(FunctionDefNode n);
	public Object visit(IDNode n);
	public Object visit(ProgramNode n);
	public Object visit(VarRefNode n);
	public Object visit(NewExprNode n);
}
