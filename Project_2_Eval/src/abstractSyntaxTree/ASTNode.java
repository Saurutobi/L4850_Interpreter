package abstractSyntaxTree;

import Visitors.Visitor;

public interface ASTNode
{
	public Object accept(Visitor v);
}
