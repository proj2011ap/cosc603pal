package project1;

import java.io.*;

public class Stutter
{
	//static Scanner console = new Scanner(System.in);

  public static void main(String[] args) //throws FileNotFoundException

  {
	  try{
		  
          String[] words = new String[100]; 
          File inFile = new File("Project1_Test_File.txt");
          int lineNo = 1;
          BufferedReader br = new BufferedReader(new InputStreamReader(
          new FileInputStream(inFile)));        
            
          String lineRead = br.readLine();
          while ((lineRead = br.readLine()) != null)
          {
        	  lineRead = br.readLine();
        	  System.out.println(lineRead);
        	  words = lineRead.split(" ");

        	  for (int i=0; i <words.length; i++)
        	  {
        		  //System.out.println(lineRead);        		        
        		  if(words[i].equals(words[i+1]))
        		  {
        			  System.out.println ("Repeated word on line " + lineNo + ": " +
        	                     words[i]+ " " + words[i+1]);        			  
        		  }
        		  else
        		  {
        			  words[i] = words[i+1];  
        		  }         		   
        	  }
        	  ++lineNo;        	  
          }

          br.close();
	  }catch (IOException e) {
    // Print out the exception that occurred
    System.out.println("Unable to create ");
    }


  }

}
