package abstractSyntaxTree;


public class NullNode implements ASTNode{

	public NullNode()
	{
		
	}

	@Override
	public Object accept(Visitor v) {
		return null;
	}
}
