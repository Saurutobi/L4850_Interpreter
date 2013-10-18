package abstractSyntaxTree;

import java.util.List;

public class ProgramNode implements ASTNode
{
	//I dont think that this node is needed anymore
	// I think that with our program node like that
	// ie it has 4 different nodes
	// we don't need this class to determine which node to go to
	
	
//	List<ASTNode> listOfNodes;
//
//	public ProgramNode(List<ASTNode> nodes)
//	{
//		listOfNodes = nodes;
//	}
//
//	@Override
//	public void acceptDepthFirst(Visitor v) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Object accept(Visitor v) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<ASTNode> getListOfNodes() {
//		return listOfNodes;
//	}
}
