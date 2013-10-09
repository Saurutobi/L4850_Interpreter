package AbstractSyntaxTree;

public interface ASTNode {
	public void acceptDF(Visitor V)
	public Object accept(Visitor V)
}
