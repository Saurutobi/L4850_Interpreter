package abstractSyntaxTree;

import java.util.List;

public class ExpressionBinaryNode extends BinaryNode
{
	private List<ASTNode> extraExpressions = null;
	private ASTNode leftNode;
	
	public ExpressionBinaryNode(ASTNode leftNode, List<ASTNode> rightNode)
	{
		this.leftNode = leftNode;
		extraExpressions = rightNode;
	}

	@Override
	public Object accept(Visitor v)
	{
		return v.visit(this);
	}
	
	public ASTNode getFirst()
	{
		return leftNode;
	}
	
	public List<ASTNode> getExtras()
	{
		return extraExpressions;
	}
}
