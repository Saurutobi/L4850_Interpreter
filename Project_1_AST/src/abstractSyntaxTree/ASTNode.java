package abstractSyntaxTree;

public interface ASTNode
{
	public Object accept(Visitor v);
}
