/**
 * 
 */
package util;

import java.util.ArrayList;

/**
 * @author carr
 *
 */
public class BaseEnvironment extends Environment {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3135942080438916540L;

	static class First extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value op = args.get(0);
			
			if (op instanceof ListValue) 
				try {
					return ((ListValue)op).first();
				} catch (IndexOutOfBoundsException e) {
					throw new L485Error("Applied first to null list");
				}
			else
				throw new L485Error("Applied first to non-list");
		}
		
	}

	static class Rest extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value op = args.get(0);
			
			if (op instanceof ListValue) 
				try {
					return ((ListValue)op).rest();
				} catch (IndexOutOfBoundsException e) {
					throw new L485Error("Applied rest to null list");
				}
			else
				throw new L485Error("Applied rest to non-list");
		}
		
	}

	static class Insert extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value op1 = args.get(0);
			Value op2 = args.get(1);
			
			if (op2 instanceof ListValue) 
					return ((ListValue)op2).insert(op1);
			else
				throw new L485Error("Applied insert to non-list");
		}
		
	}

	static class List extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			return new ListValue(args);
		}
		
	}

	static class IsEmpty extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value op = args.get(0);
			
			if (op instanceof ListValue) 
				return new BooleanValue(((ListValue)op).length() == 0);
			else
				throw new L485Error("Applied empty? to non-list");
		}
		
	}

	static class IsPair extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value op = args.get(0);
			
			if (op instanceof ListValue) 
				return new BooleanValue(((ListValue)op).length() >= 0);
			else
				throw new L485Error("Applied pair? to non-list");
		}
		
	}

	static class IsList extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value op = args.get(0);
			
			return new BooleanValue(op instanceof ListValue);
		}
		
	}

	static class IsEqual extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value lop = args.get(0);
			Value rop = args.get(1);
			
			return new BooleanValue(lop.equals(rop));
		}
		
	}

	static class Length extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value op = args.get(0);
			
			if (op instanceof ListValue) 
				return new IntValue(((ListValue)op).length());
			else
				throw new L485Error("Applied length to non-list");
		}
		
	}

	static class IsNumber extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			Value op = args.get(0);
			
			return new BooleanValue(op instanceof IntValue || op instanceof FloatValue); 
		}
		
	}

	static class Exit extends BuiltinFunction {

		@Override
		public Value invoke(Environment env, ArrayList<Value> args)
				throws L485Error {
			System.out.println("Exit.");
			System.exit(0);
			return null;
		}
		
	}

	public BaseEnvironment() {
		
		super(new ArrayList<String>(),new ArrayList<Value>(),null);
		
		ArrayList<String> baseVars = new ArrayList<String>();
		ArrayList<Value> baseVals = new  ArrayList<Value>();
		
		baseVars.add("first");
		baseVals.add(new First());
		baseVars.add("rest");
		baseVals.add(new Rest());
		baseVars.add("insert");
		baseVals.add(new Insert());
		baseVars.add("list");
		baseVals.add(new List());
		baseVars.add("emptyp");
		baseVals.add(new IsEmpty());
		baseVars.add("pairp");
		baseVals.add(new IsPair());
		baseVars.add("listp");
		baseVals.add(new IsList());
		baseVars.add("equalp");
		baseVals.add(new IsEqual());
		baseVars.add("length");
		baseVals.add(new Length());
		
		baseVars.add("numberp");
		baseVals.add(new IsNumber());
		baseVars.add("exit");
		baseVals.add(new Exit());
		baseVars.add("quit");
		baseVals.add(new Exit());
		
		baseVars.add("true");
		baseVals.add(new BooleanValue(true));
		baseVars.add("false");
		baseVals.add(new BooleanValue(false));
		baseVars.add("nil");
		baseVals.add(new NullValue());
		

		addToMap(baseVars,baseVals);

	}

}
