package abstractSyntaxTree;

import java.util.List;

public class ConstantListNode extends BinaryNode
{
	public ConstantListNode(ASTNode leftNode, List<ASTNode> extraNodes)
	{
		super(leftNode, extraNodes);
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}