package abstractSyntaxTree;

import java.util.List;

public class ProgramNode extends UnaryNode
{
	public ProgramNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
