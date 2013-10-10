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
	public void visit()
	{
		for(ASTNode currentNode : listOfNodes)
		{
			currentNode.visit();
		}
	}
}
