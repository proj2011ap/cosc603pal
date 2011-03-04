package com.example.mywebapp.server;

import com.example.mywebapp.client.GreetingService;
import com.example.mywebapp.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 10 characters long");
		}
		else
		{
			int numberOfLines = 1;
	   		String[] line = null;
	   		String lastWord = null;

			// Get the first line from the file argument
	   	//	line = input.readLine();
	   		line = input.split("\n");
	   		// Keep reading and analyzing lines until end of file
	   		while (line != null){
	   			
	   			// Splits the line into words and puts in an array of strings
	   			String[] words = input.split(" ");

	   			// Compare with the last word on the previous line
	   			if (words [0].equals (lastWord))
	   				System.out.println ("Repeated word on line " + numberOfLines + ": " + words[0]);

	   			// Stop before the end, nothing to compare the last word with
	   			for (int i = 0; i < (words.length-1); i++){
	   				// Check to see if the current and subsequent words are the same
	   				if (words [i].equals (words [i+1]))
	   					return ("Repeated word on line " + numberOfLines + ": " + words [i]);
	   			//	else
	   				//	return(" No repeated words found.");	   					
	            }
	   			
	   			// Save last word in the line
	   			lastWord = words [words.length-1];
	   			// Get the next line from the file argument
	   		//	line = input.readLine();
	   			// Increment line counter
	   			numberOfLines++;
	   		//	continue;
		}
	   		
		return input;
	   }
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
