package abstractSyntaxTree;

public class ClassDefNode extends TrinaryNode
{
	public ClassDefNode(String id, ASTNode center, ASTNode right)
	{
		super(id, center, right);
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
}

