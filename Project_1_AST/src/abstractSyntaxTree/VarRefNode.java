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
	public void visit()
	{
		 System.out.print(ID);
		 for(String currentID : extraIDs)
		 {
			 System.out.print("." + currentID);
		 }
	}

	@Override
	public void acceptDepthFirst(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getID() {
		return ID;
	}
	public List<String> getextraIDs() {
		return extraIDs;
	}
}

