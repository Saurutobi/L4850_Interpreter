package abstractSyntaxTree;

public class VariableDefNode extends UnaryNode{
	
	public VariableDefNode(ASTNode centerNode)
	{
		super(centerNode);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
