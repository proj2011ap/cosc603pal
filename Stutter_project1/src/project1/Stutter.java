package project1;

import java.io.*;
import java.util.*;

public class Stutter
{
	public static void main (String args[])							
	{
		String [] words;
		try
		{
			int lineNo = 1;
			
		    Scanner inFile = new Scanner(new FileReader("Project1_Test_File.txt"));
		    // Read a line of text
		    System.out.println("File can be read"); 
		   
		    
		    while(inFile.hasNext())
		    {
		    	String line = inFile.nextLine();
		    	words = line.split(" ");
			    for(int i = 0; i < line.length(); i++)
			    {
			    	//System.out.println(words[i]);			    	
			    	if(words[i].equals(words[i+1]))
			    		++lineNo;
			    		System.out.println("Repeated word on line "+
			    				lineNo+": "+words[i]);		   	
			    }
			    
		    }   
		    		    
		    inFile.close();		
		}catch (IOException e){
			System.err.println ("Unable to read from file");
			System.exit(-1);
		}		
		
	}	
}



	
