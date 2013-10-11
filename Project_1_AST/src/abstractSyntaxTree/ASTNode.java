package abstractSyntaxTree;

public interface ASTNode
{
	public void acceptDepthFirst(Visitor v);
	public Object accept(Visitor v);
}
