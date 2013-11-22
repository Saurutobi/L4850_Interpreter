package interpreter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import parser.L485Parser;
import parser.ParseException;
import patterns.EvalVisitor;
import patterns.SourceVisitor;
import util.BaseEnvironment;
import util.Environment;
import util.L485Error;
import util.Value;
import ast.ASTNodeList;


/**
 * @author carr
 *
 */

public class L485Interpreter {

	private static Environment baseEnv;
	
	private static String getUserInput() throws IOException {
		String curLine = ""; // Line read from standard in
		
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);

		curLine = in.readLine();
		
		return curLine;
	}
	
	private static void repl()
	{
	    System.out.print( "====> ");
	    try {
			processCode(new StringReader(getUserInput()),baseEnv);
		} catch (IOException e) {
			System.out.println("Error reading input");
		} catch (Error e) {
			System.out.println("Uncaught Interpreter Error: "+e);
		} catch (Exception e) {
			System.out.println("Uncaught Interpreter Exception: "+e);
		}
	    repl();
	}
	
	public static void processCode(Reader code, Environment env)
	{
	    try {
	    	L485Parser.ReInit(code);
	    	ASTNodeList ast = L485Parser.program();
	    	String s = (String)ast.accept(new SourceVisitor());
	    	System.out.print(s+" = ");
	    	Value v = (Value)ast.accept(new EvalVisitor(env));
	    	System.out.println(v);
	    }
	    catch(ParseException e) {
	    	System.out.println("Syntax Error: "+e);
	    }
	    catch(L485Error e) {
	    	System.out.println("Error: "+e);
	    }
	}
	

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String args []) throws ParseException, FileNotFoundException
	{
		L485Parser parser = new L485Parser(System.in);
		baseEnv = new BaseEnvironment();
		if (args.length > 0) {
			processCode(new FileReader(args[0]),baseEnv);			
		} else {
			repl();
		}
	}
	
	public static Environment getBaseEnv() { return baseEnv; }

	/**
	 * @param args
	 */
}
