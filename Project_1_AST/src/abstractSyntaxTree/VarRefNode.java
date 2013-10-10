package abstractSyntaxTree;

import java.util.List;

public class VarRefNode implements ASTNode
{
	private String ID;
	private List<String> extraIDs;
	
	public VarRefNode(String ID, List<String> moreIDs)
	{
		super();
		this.ID = ID;
		this.extraIDs = moreIDs;
	}
	
	@Override
	public void visit()
	{
		 System.out.print(ID);
		 for(String currentID : extraIDs)
		 {
			 System.out.print("." + currentID);
		 }
	}
}

