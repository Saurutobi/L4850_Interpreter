package abstractSyntaxTree;

import java.util.List;

import visitors.Visitor;

public class VariableDefsNode extends BinaryNode
{
	public VariableDefsNode(List<String> leftStrings, List<ASTNode> rightNodes)
	{
		super(leftStrings, rightNodes);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}
