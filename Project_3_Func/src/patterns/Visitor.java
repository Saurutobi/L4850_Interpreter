/**
 * 
 */
package patterns;

import ast.*;
import util.L485Error;

/**
 * @author carr
 *
 */
public interface Visitor {

	public Object visit(ArgumentListNode n) throws L485Error;
	public Object visit(AssignNode n) throws L485Error;
	public Object visit(ASTNodeList n) throws L485Error;
	public Object visit(BooleanNode n) throws L485Error;
	public Object visit(CallNode n) throws L485Error;
	public Object visit(ClassNode n) throws L485Error;
	public Object visit(CondClauseNode n) throws L485Error;
	public Object visit(CondNode n) throws L485Error;
	public Object visit(DefuncNode n) throws L485Error;
	public Object visit(FloatNode n) throws L485Error;
	public Object visit(FuncNode n) throws L485Error;
	public Object visit(IfNode n) throws L485Error;
	public Object visit(IntegerNode n) throws L485Error;
	public Object visit(ListNode n) throws L485Error;
	public Object visit(LoadNode n) throws L485Error;
	public Object visit(MethodNode n) throws L485Error;
	public Object visit(MethodrefNode n) throws L485Error;
	public Object visit(NewNode n) throws L485Error;
	public Object visit(StringNode n) throws L485Error;
	public Object visit(VarrefNode n) throws L485Error;
	public Object visit(WithNode n) throws L485Error;
	public Object visit(CondClauseList n) throws L485Error;
	public Object visit(AddNode n) throws L485Error;
	public Object visit(SubNode n) throws L485Error;
	public Object visit(MultiplyNode n) throws L485Error;
	public Object visit(DivideNode n) throws L485Error;
	public Object visit(NotNode n) throws L485Error;
	public Object visit(OrNode n) throws L485Error;
	public Object visit(AndNode n) throws L485Error;
	public Object visit(EqualNode n) throws L485Error;
	public Object visit(NotEqualNode n) throws L485Error;
	public Object visit(LessNode n) throws L485Error;
	public Object visit(LessEqualNode n) throws L485Error;
	public Object visit(GreaterNode n) throws L485Error;
	public Object visit(GreaterEqualNode n) throws L485Error;
}
