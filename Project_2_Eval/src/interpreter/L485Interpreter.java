package interpreter;

import java.io.*;
import java.util.*;

import abstractSyntaxTree.ASTNode;
import parser.L485Parser;
import parser.ParseException;
import Visitors.*;

//Author: Marcel Englmaier

public class L485Interpreter
{
	public static void main(String args []) throws ParseException
	{
		L485Parser parser = new L485Parser(System.in);
		repl();
	}
	
	private static void repl()
	{
		//Modified for grader's batch input
		try 
		{
			processCode(getSingleFileInput());
		}
		catch (IOException e)
		{
			System.out.println("Error reading input");
		}
		catch (Error e)
		{
			System.out.println("Uncaught Interpreter Error: "+e);
		}
		catch (Exception e)
		{
			System.out.println("Uncaught Interpreter Exception: "+e);
		}
		repl();
	}
	
	//This method now returns an array for quicker testing
	private static String [] getSingleFileInput() throws IOException
	{
		List<String> retVal = new ArrayList<String>();
		System.out.println("Enter the full file path of your file of input");
		System.out.print( "====> ");
		try
		{
			Scanner scan = new Scanner(System.in);
			String fileName = scan.nextLine();
			BufferedReader buff = new BufferedReader(new FileReader(fileName));
			String curLine;
			while((curLine = buff.readLine()) != null)
			{
				retVal.add(curLine);
			}
		}
		catch(Exception e)
		{
			System.out.println("It didn't work, try again");
		}
		return retVal.toArray(new String[retVal.size()]);
	}

	public static void processCode(String [] code)
	{
		//for each line of input, do all the work. allows for easy batch processing
		for(String currentInput : code)
		{
			//modified try-catch to run inside rather than outside foreach loop, so all items will get processed
			try
			{
				System.out.println("Working on: " + currentInput);
				L485Parser.ReInit(new StringReader(currentInput));
				ASTNode output = L485Parser.program();
				String outputString = output.accept(new EvalVisitor()).toString();
				System.out.println("Read In Done!");
				System.out.println(outputString);
			}
			catch(Exception e)
			{
				System.out.println("----------------------------------------------------Syntax Error: "+e + "\n" + e.getMessage());
			}
		}
	}
}