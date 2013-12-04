/**
 * 
 */
package patterns;

import interpreter.L485Interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

import util.BooleanValue;
import util.Environment;
import util.FloatValue;
import util.Function;
import util.IntValue;
import util.L485Error;
import util.ListValue;
import util.StringValue;
import util.Value;
import util.VoidValue;
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
public class EvalVisitor implements Visitor {

	private Environment env;
	
	/**
	 * 
	 */
	public EvalVisitor(Environment env) {
		//when this is first called env is the base environment
		this.env = env;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ArgumentListNode)
	 */
	@Override
	public Value visit(ArgumentListNode n) throws L485Error {
		ArrayList<Value> list = new ArrayList<Value>();
		ArrayList<ASTNode> nodes = n.getArguments();
		
		for (ASTNode node: nodes) 
		{
			Value v = (Value)node.accept(this);
			list.add(v);
		}
		
		return new ListValue(list);
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.AssignNode)
	 */
	@Override
	public Value visit(AssignNode n) throws L485Error {
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ASTNodeList)
	 */
	@Override
	public Value visit(ASTNodeList n) throws L485Error {
		Value v = new VoidValue();
		for (ASTNode node:n.getNodeList()) {
			v = (Value)node.accept(this);
		}
		
		return v;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CallNode)
	 */
	@Override
	public Value visit(CallNode n) throws L485Error {
		Value v = (Value)n.getArgs().accept(this);
		ArrayList<Value> argvals = (ArrayList<Value>)((ListValue)v).get();
		
		try {
			return ((Function)n.getFunc().accept(this)).invoke(env, argvals);
		}
		catch(ClassCastException e) {
			SourceVisitor sv = new SourceVisitor();
			throw new L485Error("Invalid function call: "+n.accept(sv));
		}
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ClassNode)
	 */
	@Override
	public Value visit(ClassNode n) throws L485Error {
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CondClauseNode)
	 */
	@Override
	public Value visit(CondClauseNode n) throws L485Error {
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.CondNode)
	 */
	@Override
	public Value visit(CondNode n) throws L485Error {
		try {
			for (ASTNode node:n.getClauses().getNodeList()) {
				CondClauseNode cn = (CondClauseNode)node;
				BooleanValue tv = (BooleanValue)cn.getTestExpr().accept(this);
				if (tv.getBoolean())
					return (Value)cn.getResultExpr().accept(this);
				}
			return new VoidValue();
		} catch (ClassCastException e) {
			SourceVisitor sv = new SourceVisitor();
			throw new L485Error("Invalid type in cond clause test: "+n.accept(sv));
		}
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.DefuncNode)
	 */
	@Override
	public Value visit(DefuncNode n) throws L485Error {
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FloatNode)
	 */
	@Override
	public Value visit(FloatNode n) throws L485Error {
		return new FloatValue(n.getVal());
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.FuncNode)
	 */
	@Override
	public Value visit(FuncNode n) throws L485Error {
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IfNode)
	 */
	@Override
	public Value visit(IfNode n) throws L485Error {
		try {
			Value bv = (Value)n.getTestExpr().accept(this);
			if (((Boolean)bv.get()).booleanValue())
				return (Value)n.getThenExpr().accept(this);
			else
				return (Value)n.getElseExpr().accept(this);
		}
		catch (ClassCastException e) {
			SourceVisitor sv = new SourceVisitor();
			throw new L485Error("Invalid boolean value in if test expression: "+n.getTestExpr().accept(sv));
		}
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.IntegerNode)
	 */
	@Override
	public Value visit(IntegerNode n) throws L485Error {
		return new IntValue(n.getVal());
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.ListNode)
	 */
	@Override
	public Value visit(ListNode n) throws L485Error {
		
		ArrayList<Value> theVals = new ArrayList<Value>();
		for (ASTNode node:n.getTheList()) {
			theVals.add((Value)node.accept(this));
		}
		
		return new ListValue(theVals);
	}

	private String getCodeFromFile(String fn) throws IOException {
		String code = ""; 
		
		System.out.println("Enter a line of text (type 'quit' to exit): ");
		FileReader fileR = new FileReader(fn);
		BufferedReader in = new BufferedReader(fileR);

		String curLine;
		while ((curLine = in.readLine()) != null)
			code += curLine;
		
		in.close();
		return code;
	}
	
	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.LoadNode)
	 */
	@Override
	public Value visit(LoadNode n) throws L485Error {
		try {
			L485Interpreter.processCode(new StringReader(getCodeFromFile(n.getFileName())),L485Interpreter.getBaseEnv()); 
		}
		catch (IOException e) {
			throw new L485Error("File not found: "+n.getFileName());
		}
		return new StringValue("done.");
	} 

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.MethodNode)
	 */
	@Override
	public Value visit(MethodNode n) throws L485Error {
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.MethodrefNode)
	 */
	@Override
	public Value visit(MethodrefNode n) throws L485Error {
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.NewNode)
	 */
	@Override
	public Value visit(NewNode n) throws L485Error {
		return null;
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.StringNode)
	 */
	@Override
	public Value visit(StringNode n) throws L485Error {
		return new StringValue(n.getStr());
	}

	/* (non-Javadoc)
	 * @see visitor.Visitor#visit(ast.VarrefNode)
	 */
	@Override
	public Value visit(VarrefNode n) throws L485Error {
		if (env.hasKey(n.getId()))
			return env.get(n.getId());
		else
			throw new L485Error("Undefined variable: "+n.getId());
	}

	@Override
	public Value visit(WithNode n) throws L485Error {		
		//create a new environment
		//ok it looks like the hashmap that is the beginning
		//	part of the with node is a string that points to an ASTNode
		//	but our environment only maps strings to values
		//	should our environment map values or should it map
		//	ASTNodes? 
		
		HashMap<String,Value> tempHashMap = new HashMap<String, Value>();
		Object[] tempVals = n.getVarDefs().keySet().toArray();
		
		for(int i = 0; i < tempVals.length; i++)
		{
			Value tempValue = (Value) n.getVarDefs().get(tempVals[i]).accept(new EvalVisitor(env));
			tempHashMap.put(tempVals[i].toString(), tempValue);
		}	
		Environment temp = new Environment(tempHashMap,env);
		
		//visit the n node using the new environment
		//	this code below i think will drop down into a 
		//	eval visitor using the nested scheme of environments
		
		return (Value) n.getBody().accept(new EvalVisitor(temp));
	}

	@Override
	public Value visit(CondClauseList n) throws L485Error {
		return null;
	}

	@Override
	public Value visit(BooleanNode n) throws L485Error {
		return new BooleanValue(n.getVal());
	}

	@Override
	public Object visit(AddNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new IntValue(((IntValue)lop).getInt() + ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new FloatValue(((FloatValue)lop).getFloat() + ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new FloatValue(((IntValue)lop).getInt() + ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new FloatValue(((FloatValue)lop).getFloat() + ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" + "+rop);
	}

	@Override
	public Object visit(SubNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new IntValue(((IntValue)lop).getInt() - ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new FloatValue(((FloatValue)lop).getFloat() - ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new FloatValue(((IntValue)lop).getInt() - ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new FloatValue(((FloatValue)lop).getFloat() - ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" - "+rop);
	}

	@Override
	public Object visit(MultiplyNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new IntValue(((IntValue)lop).getInt() * ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new FloatValue(((FloatValue)lop).getFloat() * ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new FloatValue(((IntValue)lop).getInt() * ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new FloatValue(((FloatValue)lop).getFloat() * ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" * "+rop);
	}

	@Override
	public Object visit(DivideNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new IntValue(((IntValue)lop).getInt() / ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new FloatValue(((FloatValue)lop).getFloat() / ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new FloatValue(((IntValue)lop).getInt() / ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new FloatValue(((FloatValue)lop).getFloat() / ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" / "+rop);
	}

	@Override
	public Object visit(NotNode n) throws L485Error {
		Value lop = (Value)n.getOperand().accept(this);
		
		if (lop instanceof BooleanValue)
			return new BooleanValue(!((BooleanValue)lop).getBoolean() );
		else
			throw new L485Error("Incompatible type: !"+lop);
	}

	@Override
	public Object visit(OrNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof BooleanValue && rop instanceof BooleanValue)
			return new BooleanValue(((BooleanValue)lop).getBoolean() || ((BooleanValue)rop).getBoolean());
		else
			throw new L485Error("Incompatible types: "+lop+" || "+rop);
	}

	@Override
	public Object visit(AndNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof BooleanValue && rop instanceof BooleanValue)
			return new BooleanValue(((BooleanValue)lop).getBoolean() && ((BooleanValue)rop).getBoolean());
		else
			throw new L485Error("Incompatible types: "+lop+" && "+rop);
	}

	@Override
	public Object visit(EqualNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new BooleanValue(((IntValue)lop).getInt() == ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new BooleanValue(((FloatValue)lop).getFloat() == ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new BooleanValue(((IntValue)lop).getInt() == ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new BooleanValue(((FloatValue)lop).getFloat() == ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" == "+rop);
	}

	@Override
	public Object visit(NotEqualNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new BooleanValue(((IntValue)lop).getInt() != ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new BooleanValue(((FloatValue)lop).getFloat() != ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new BooleanValue(((IntValue)lop).getInt() != ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new BooleanValue(((FloatValue)lop).getFloat() != ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" == "+rop);
	}

	@Override
	public Object visit(LessNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new BooleanValue(((IntValue)lop).getInt() < ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new BooleanValue(((FloatValue)lop).getFloat() < ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new BooleanValue(((IntValue)lop).getInt() < ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new BooleanValue(((FloatValue)lop).getFloat() < ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" < "+rop);
	}

	@Override
	public Object visit(LessEqualNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new BooleanValue(((IntValue)lop).getInt() <= ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new BooleanValue(((FloatValue)lop).getFloat() <= ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new BooleanValue(((IntValue)lop).getInt() <= ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new BooleanValue(((FloatValue)lop).getFloat() <= ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" < "+rop);
	}

	@Override
	public Object visit(GreaterNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new BooleanValue(((IntValue)lop).getInt() > ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new BooleanValue(((FloatValue)lop).getFloat() > ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new BooleanValue(((IntValue)lop).getInt() > ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new BooleanValue(((FloatValue)lop).getFloat() > ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" > "+rop);
	}

	@Override
	public Object visit(GreaterEqualNode n) throws L485Error {
		Value lop = (Value)n.getLeftOperand().accept(this);
		Value rop = (Value)n.getRightOperand().accept(this);
		
		if (lop instanceof IntValue &&  rop instanceof IntValue)
			return new BooleanValue(((IntValue)lop).getInt() >= ((IntValue)rop).getInt());
		else if (lop instanceof FloatValue &&  rop instanceof IntValue)
			return new BooleanValue(((FloatValue)lop).getFloat() >= ((IntValue)rop).getInt());
		else if (lop instanceof IntValue &&  rop instanceof FloatValue)
			return new BooleanValue(((IntValue)lop).getInt() >= ((FloatValue)rop).getFloat());
		else if (lop instanceof FloatValue &&  rop instanceof FloatValue)
			return new BooleanValue(((FloatValue)lop).getFloat() >= ((FloatValue)rop).getFloat());
		else
			throw new L485Error("Incompatible types: "+lop+" > "+rop);
	}

}
