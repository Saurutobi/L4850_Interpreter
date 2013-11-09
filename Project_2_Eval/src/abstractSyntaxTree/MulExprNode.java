package abstractSyntaxTree;

import java.util.List;
import Visitors.*;

public class MulExprNode extends BinaryNode
{
	public MulExprNode(ASTNode leftNode, List<ASTNode> extraNodes)
	{
		super(leftNode, extraNodes);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
