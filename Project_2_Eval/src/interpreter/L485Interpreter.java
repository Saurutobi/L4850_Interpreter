package interpreter;

import java.io.*;
import java.util.*;

import abstractSyntaxTree.ASTNode;
import Visitors.PrintVisitor;
import parser.L485Parser;
import parser.ParseException;

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
		//This section is modified to ask for 2 types of input: a single line input, or a directory path for batch processing
		System.out.println("1 for single input from command\n2 for single file input from command\n3 for directory input");
		Scanner operation = new Scanner(System.in);
		System.out.print( "====> ");
		String op = operation.nextLine();
		try 
		{
			System.out.print( "====> ");
			//single input from command
			if(op.equals("1"))
			{
				String [] temp = new String[1];
				temp[0] = operation.nextLine();
				processCode(temp);
			}
			//Single file input from command
			if(op.equals("2"))
			{
				processCode(getSingleFileInput());
			}
			//directory input
			if(op.equals("3"))
			{
				processCode(getDirectoryInput());
			}
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
		
	//This method now returns an array for quicker testing
	private static String [] getDirectoryInput() throws IOException
	{
		List<String> retVal = new ArrayList<String>();
		System.out.println("Enter the full file path of your directory of input");
		System.out.print( "====> ");
		try
		{
			Scanner scan = new Scanner(System.in);
			String dirName = scan.nextLine();
			File directory = new File(dirName);
			File [] contents = directory.listFiles();
			for(File currentFile : contents)
			{
				BufferedReader buff = new BufferedReader(new FileReader(currentFile.getAbsolutePath()));
				String curLine;
				while((curLine = buff.readLine()) != null)
				{
					retVal.add(curLine);
				}
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
				String outputString = (String)output.accept(new PrintVisitor());
				System.out.println("Read In Done!");
				System.out.println("\nYo, I like you, and imma let you finish, but let me regurgitate this back for you:"); 
				System.out.println(outputString);
				System.out.println("Yea, Science, Bitch!\n");
			}
			catch(ParseException e)
			{
				System.out.println("----------------------------------------------------Syntax Error: "+e);
			}
		}
	}
}