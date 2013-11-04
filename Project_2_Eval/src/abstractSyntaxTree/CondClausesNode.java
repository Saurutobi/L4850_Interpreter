package abstractSyntaxTree;

import java.util.List;
import Visitors.*;
public class CondClausesNode extends UnaryNode
{
	public CondClausesNode(List<ASTNode> centerNodeList)
	{
		super(centerNodeList);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
