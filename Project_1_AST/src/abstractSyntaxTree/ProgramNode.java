package abstractSyntaxTree;

import java.util.List;

public class ProgramNode implements ASTNode
{
	List<ASTNode> listOfNodes;

	public ProgramNode(List<ASTNode> nodes)
	{
		listOfNodes = nodes;
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

	public List<ASTNode> getListOfNodes() {
		return listOfNodes;
	}
}
