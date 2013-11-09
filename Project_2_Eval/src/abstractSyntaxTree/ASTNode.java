package abstractSyntaxTree;

import Visitors.*;

public interface ASTNode
{
	public Object accept(Visitor v);
}
