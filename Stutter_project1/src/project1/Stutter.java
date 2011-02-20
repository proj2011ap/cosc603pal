package project1;

import java.io.*; //Java I/O package imported

// TODO: Auto-generated Javadoc
/**
 * The Class Stutter.
 */
public class Stutter
{
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		try{
			String[] words = new String[100]; 			
			//declaring array variable words as String
			
			File inFile = new File("Project1_Test_File.txt");
			//making an input file object
			
			int lineNo = 1; //counter variable for lines in text file
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(inFile)));  
		  //Read text from an input stream, buffering characters and
		  //efficient reading of characters, arrays, and lines
            
			String lineRead;
			//declaring lineRead as a line of String from the input file
			
			while ((lineRead = br.readLine()) != null)//when file is not empty and
				//Read File line By line
				{
				words = lineRead.split(" "); //if any space between two words, splits

        	    for (int i=0; i <words.length-1; i++) //checking each word 
        	    	{
        	    	if(words[i].equals(words[i+1]))//comparing each word for equality
        	    		{
        	    		System.out.println ("Repeated word on line " + lineNo + ": " +
        	                     words[i]+ " " + words[i+1]);
        	    		//prints out the output
        	    		}
        	    	else
        	    		{
        	    		words[i] = words[i+1]; //assigning next word as current word
        	    		} 
        	    	}  
        	    ++lineNo; //pre-increment of line number  	 
        	    continue; //next input line goes inside for loop 
        	    }
			br.close();//input file closed
			}catch (IOException e) {
				// Print out the exception if file can not be read
				System.out.println("No file could be read ");
				}
			}//main class ends
	}//Stutter class ends
