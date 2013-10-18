package abstractSyntaxTree;

public class LoadFileNode implements ASTNode{
	
	//do we need to do a unary node or a ast node for a node
	// that does not have any children at all
	// for example NewExpr needs new and an expression so
	// the expression is the unary node part
	// this node has no need to go anywhere
	// all it is is a load and a string that it is given
	// as long as it meets the regular expression
	// screw it and load whatever string we were given
	// if string was specified as a file path
	// ie <letter> <colon> <slash><id>(<slash><id>)*
	// then we would need like a trinary node
	// this is just food for thought if you see this
	// think about it we will talk next time we talk about the assignment
	// hopefully this got your attention
	// hopefully this got your attention
	// hopefully this got your attention
	// hopefully this got your attention
	// hopefully this got your attention
	// hopefully this got your attention
	
	private String FilePath;
	
	public LoadFileNode(String string)
	{
		FilePath = string;
	}

//	@Override
//	public void acceptDepthFirst(Visitor v) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
	public String getFilePath()
	{
		return FilePath;
	}

}
