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
		System.out.print("new ");
		return null;
	}

	@Override
	public Object visit(FunctionDefNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ClassVarsNode n) {
		System.out.print("vars ");
		return null;
	}
	public Object visit(ClassDefNode n){
		//TODO: FIX THIS
		System.out.print("funky shiitii")
		return null;
	}

	@Override
	public Object visit(MethodsNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LoadFileNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExpressionListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ExpressionNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(LogOpNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CompOpNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AddExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AddOpNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MulExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(MulOpNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FactorNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(OperandNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CallNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ParamListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ConstantNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ConstantListNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(FuncExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(AssignExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CondExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CondClausesNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(WithExprNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(VariableDefsNode n) {
		// TODO Auto-generated method stub
		return null;
	}
}
