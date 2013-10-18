package abstractSyntaxTree;

public class IfExprNode extends TrinaryNode{
	
	public IfExprNode(ASTNode leftNode, ASTNode centerNode, ASTNode rightNode)
	{
		super(leftNode, centerNode, rightNode);
	}

//	@Override
//	public void acceptDepthFirst(Visitor v) {
//		//print if
//		leftNode.acceptDepthFirst(v);
//		//print then
//		centerNode.acceptDepthFirst(v);
//		//print else
//		rightNode.acceptDepthFirst(v);		
//	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	//there is something more we need to do here
	//idk what yet i think we just need to figure out what
	//expression returns before here, these nodes are test for now
	//until we figure this whole part out
	//maybe we do a node visit here to get a string out
	//actually that has to be it!
	public String FirstExpression()
	{
		return "test1";
	}
	public String SecondExpression()
	{
		return "test2";	
	}
	public String ThirdExpression()
	{
		return "test3";
	}
	
}
