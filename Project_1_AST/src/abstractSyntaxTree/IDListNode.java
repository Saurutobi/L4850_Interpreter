package abstractSyntaxTree;

import java.util.List;

public class IDListNode implements ASTNode
{	
	private String localID;
	private List<String> localIDs = null;
	
	public IDListNode(String id, List<String> ids)
	{
		localID = id;
		localIDs = ids;
	}
	
	public String getID()
	{
		return localID;
	}
	
	public List<String> getExtras()
	{
		return localIDs;
	}
	
	@Override
	public Object accept(Visitor v)
	{
		return null;
	}
}
