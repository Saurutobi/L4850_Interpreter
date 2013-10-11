package abstractSyntaxTree;

public class IDNode implements ASTNode
{
	private String name;
	
	public IDNode(String name)
	{
		super();
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	@Override
	public void acceptDepthFirst(Visitor v) {
		v.visit(this);
	}
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
