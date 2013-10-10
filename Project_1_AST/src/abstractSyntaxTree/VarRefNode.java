package abstractSyntaxTree;

public class VarRefNode implements ASTNode
{
	private String firstID;
	private String secondID;
	
	public VarRefNode(String firstID, String secondID)
	{
		super();
		this.firstID = firstID;
		this.secondID = secondID;
	}
	
	@Override
	public void visit()
	{
		 System.out.print(firstID + "." + secondID);
	}
}

