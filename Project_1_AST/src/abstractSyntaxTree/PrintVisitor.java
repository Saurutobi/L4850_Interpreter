package abstractSyntaxTree;

public class PrintVisitor implements Visitor{

/*	
 * This just needs to be implimented in the print visitor area i just don't know how right now
 * @Override
	public Object visit(FunctionDefNode n) {
		System.out.print("defunc " + name + "(");
		left.visit();
		System.out.print(")");
		right.visit();
		return null;
	}*/

	@Override
	public Object visit(IDNode n) {
			System.out.print(n.getName());
		return null;
	}

	@Override
	public Object visit(ProgramNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VarRefNode n) {
		 System.out.print(n.getID());
		 for(String currentID : n.getextraIDs())
		 {
			 System.out.print("." + currentID);
		 }
		return null;
	}

	@Override
	public Object visit(NewExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FunctionDefNode n) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
