package abstractSyntaxTree;

public class ClassVarsNode extends UnaryNode
{
	public ClassVarsNode(ASTNode centerNode)
	{
		super(centerNode);
	}
	@Override
	public void acceptDepthFirst(Visitor v) {
		v.visit(this);
		centerNode.acceptDepthFirst(v);
	}
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
}
