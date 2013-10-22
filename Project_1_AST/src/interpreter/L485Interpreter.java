package interpreter;
import java.io.*;
import java.util.*;

import abstractSyntaxTree.PrintVisitor;
import parser.L485Parser;
import parser.ParseException;


/**
 * @author carr
 *
 */

public class L485Interpreter {
        
        private static String [] getUserInput() throws IOException
        {
                List<String> retVal = new ArrayList<String>();
                System.out.println("Enter the full file path of your directory of input");
                Scanner scan = new Scanner(System.in);
                String dirName = scan.nextLine();
                try
                {
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
        
        private static void repl()
        {
            System.out.print( "====> ");
            try {
                        processCode(getUserInput());
                } catch (IOException e) {
                        System.out.println("Error reading input");
                } catch (Error e) {
                        System.out.println("Uncaught Interpreter Error: "+e);
                } catch (Exception e) {
                        System.out.println("Uncaught Interpreter Exception: ");
                        e.printStackTrace();
                }
            repl();
        }
        
        public static void processCode(String [] code)
        {
            try {
                    for(String currentInput : code)
                    {
                            System.out.println("Working on: " + currentInput);
                            L485Parser.ReInit(new StringReader(currentInput));
                            L485Parser.program().accept(new PrintVisitor());
                            System.out.println("\nSuccess!");
                    }
            }
            catch(ParseException e) {
                    System.out.println("----------------------------------------------------Syntax Error: "+e);
            }
        }
        

        /**
         * @param args
         */
        public static void main(String args []) throws ParseException
        {
                L485Parser parser = new L485Parser(System.in);
                repl();
        }
}