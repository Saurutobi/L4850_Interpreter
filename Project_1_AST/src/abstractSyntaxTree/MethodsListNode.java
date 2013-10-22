package abstractSyntaxTree;

import java.util.List;

public class MethodsListNode extends UnaryNode{

	public MethodsListNode(List<ASTNode> centerList)
	{
		super(centerList);
	}

	@Override
	public Object accept(Visitor v) 
	{
		return v.visit(this);
	}
}