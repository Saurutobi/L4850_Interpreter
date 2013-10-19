package abstractSyntaxTree;

public class OperandNode extends UnaryNode{
	
	public OperandNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
