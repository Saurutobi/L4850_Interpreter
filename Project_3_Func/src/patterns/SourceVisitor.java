/**
 * 
 */
package patterns;

import util.L485Error;
import ast.ASTNode;
import ast.ASTNodeList;
import ast.AddNode;
import ast.AndNode;
import ast.ArgumentListNode;
import ast.AssignNode;
import ast.BooleanNode;
import ast.CallNode;
import ast.ClassNode;
import ast.CondClauseList;
import ast.CondClauseNode;
import ast.CondNode;
import ast.DefuncNode;
import ast.DivideNode;
import ast.EqualNode;
import ast.FloatNode;
import ast.FuncNode;
import ast.GreaterEqualNode;
import ast.GreaterNode;
import ast.IfNode;
import ast.IntegerNode;
import ast.LessEqualNode;
import ast.LessNode;
import ast.ListNode;
import ast.LoadNode;
import ast.MethodNode;
import ast.MethodrefNode;
import ast.MultiplyNode;
import ast.NewNode;
import ast.NotEqualNode;
import ast.NotNode;
import ast.OrNode;
import ast.StringNode;
import ast.SubNode;
import ast.VarrefNode;
import ast.WithNode;

/**
 * @author carr
 *
 */
public class SourceVisitor implements Visitor {

	/**
	 * 
	 */
	public SourceVisitor() {
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ArgumentListNode)
	 */
	@Override
	public Object visit(ArgumentListNode n) throws L485Error {
		String source = "";
		for (ASTNode node: n.getArguments()) {
			source += ((String)node.accept(this) + ", ");
		}
		if (source.equals(""))
			return source;
		else
			return source.substring(0,source.length()-2);	
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.AssignNode)
	 */
	@Override
	public Object visit(AssignNode n) throws L485Error {
		return "assign " + (String)n.getRhs().accept(this) + " to " + n.getLhs();
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ASTNodeList)
	 */
	@Override
	public Object visit(ASTNodeList n) throws L485Error {
		String source = "";
		for (ASTNode node:n.getNodeList()) {
			source += ((String)node.accept(this) + "\n");
		}
		
		return source;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CallNode)
	 */
	@Override
	public Object visit(CallNode n) throws L485Error {
		String argString;
		
		if (n.getArgs() == null)
			argString = "";
		else
			argString = (String)n.getArgs().accept(this);
		
		return (String)n.getFunc().accept(this)+"->("+argString+")";
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ClassNode)
	 */
	@Override
	public Object visit(ClassNode n) throws L485Error {
		String source = "defclass "+(String)n.getName() +"{ \n\tvars ";
		
		String varStr = "";
		for (String var: n.getClassVars())
			varStr += (var + ", ");
		source += varStr.substring(0, varStr.length()-2);
		
		source += (String)n.getMethods().accept(this);
		
		return source + "\n}";
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CondClauseNode)
	 */
	@Override
	public Object visit(CondClauseNode n) throws L485Error {
		return "[ " + n.getTestExpr().accept(this) + " " + n.getResultExpr().accept(this) + "]";
		
		
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CondNode)
	 */
	@Override
	public Object visit(CondNode n) throws L485Error {
		return "cond " + n.getClauses().accept(this);
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.DefuncNode)
	 */
	@Override
	public Object visit(DefuncNode n) throws L485Error {
		String source = "defunc " + n.getName() + "(";
		
		String pStr = "";
		for (String param: n.getParams())
			pStr += (param + ", ");
		
		return source + (pStr.substring(0, pStr.length()-2) + ") {\n" + n.getBody().accept(this) + "\n}");
		
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FloatNode)
	 */
	@Override
	public Object visit(FloatNode n) throws L485Error {
		return Float.toString(n.getVal());
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FuncNode)
	 */
	@Override
	public Object visit(FuncNode n) throws L485Error {
		String source = "func (";
		
		String pStr = "";
		for (String param: n.getParams())
			pStr += (param + ", ");
		
		return source + (pStr.substring(0, pStr.length()-2) + ") {\n" + n.getBody().accept(this) + "\n}");
	
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IfNode)
	 */
	@Override
	public Object visit(IfNode n) throws L485Error {
		return "if " + n.getTestExpr().accept(this) + " then " + n.getThenExpr().accept(this) +
				" else " + n.getElseExpr().accept(this) + "fi";
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IntegerNode)
	 */
	@Override
	public Object visit(IntegerNode n) throws L485Error {
		return Integer.toString(n.getVal());
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ListNode)
	 */
	@Override
	public Object visit(ListNode n) throws L485Error {
		
		String lStr = "";
		for (ASTNode node: n.getTheList())
			lStr += (node.accept(this) + ", ");
		
		return "[" + lStr.substring(0, lStr.length()-2) + "]";
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.LoadNode)
	 */
	@Override
	public Object visit(LoadNode n) throws L485Error {
		return "load '" + n.getFileName() + "'";
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.MethodNode)
	 */
	@Override
	public Object visit(MethodNode n) throws L485Error {
		
		String pStr = "";
		for (String param: n.getParams())
			pStr += (param + ", ");
		
		return "method " + n.getName() + "(" + pStr.substring(0, pStr.length()-2)+") {\n" + n.getBody().accept(this) + "\n}";
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.MethodrefNode)
	 */
	@Override
	public Object visit(MethodrefNode n) throws L485Error {
		return n.getObjectName() + "." + n.getMethodName();
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.NewNode)
	 */
	@Override
	public Object visit(NewNode n) throws L485Error {
		return "new " + n.getClassName();
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.StringNode)
	 */
	@Override
	public Object visit(StringNode n) throws L485Error {
		return n.getStr();
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.VarrefNode)
	 */
	@Override
	public Object visit(VarrefNode n) throws L485Error {
		return n.getId();
	}

	@Override
	public Object visit(WithNode n) throws L485Error {
		String source = "";
		for (String var:n.getVariables()) {
			source += "["+var+" "+n.getVarExpr(var).accept(this)+"]\n";
		}
		return "with ("+source.substring(0,source.length()-1)+")" + "{ \n"+n.getBody().accept(this)+"\n}\n";
	}

	@Override
	public Object visit(CondClauseList n) throws L485Error {
		String source = "";
		for (CondClauseNode node:n.getClauses()) {
			source += ((String)node.accept(this) + "\n");
		}
		
		return source;
		
	}

	@Override
	public Object visit(BooleanNode n) throws L485Error {
		return Boolean.toString(n.getVal());
	}

	@Override
	public Object visit(AddNode n) throws L485Error {
		
		return n.getLeftOperand().accept(this) + " + " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(SubNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " - " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(MultiplyNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " * " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(DivideNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " / " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(NotNode n) throws L485Error {
		return "!"+n.getOperand().accept(this);
	}

	@Override
	public Object visit(OrNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " || " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(AndNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " && " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(EqualNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " == " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(NotEqualNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " != " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(LessNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " < " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(LessEqualNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " <= " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(GreaterNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " >= " + n.getRightOperand().accept(this);
	}

	@Override
	public Object visit(GreaterEqualNode n) throws L485Error {
		return n.getLeftOperand().accept(this) + " >= " + n.getRightOperand().accept(this);
	}

}
