package abstractSyntaxTree;

public class IDNode implements ASTNode
{
	private String name;
	
	public IDNode(String name)
	{
		super();
		this.name = name;
	}
	
	@Override
	public void visit()
	{
		 System.out.print(name);
	}
}
