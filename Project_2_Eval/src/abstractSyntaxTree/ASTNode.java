package abstractSyntaxTree;

import visitors.Visitor;

public interface ASTNode
{
	public Object accept(Visitor v);
}
