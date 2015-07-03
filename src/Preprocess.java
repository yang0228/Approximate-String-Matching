import java.util.*;
import java.io.*;

public class Preprocess{


	public static void main(String args[]) {

		// Scanner scan = new Scanner(System.in);

		// System.out.println("Type a sentence and press enter.");

		// String input = scan.nextLine();
		String s = null;
		try {
	        File input = new File("turgenev.txt");
	        File output = new File("turn.txt");
	        Scanner sc = new Scanner(input);
	        PrintWriter printer = new PrintWriter(output);
	        while(sc.hasNext()) {
	            s = sc.next().replaceAll("[^a-zA-Z]+", " ").toLowerCase().trim() + '\n';
	            printer.write(s);
	        }
	        sc.close();
	        printer.close();
	    }
	    catch(FileNotFoundException e) {
	        System.err.println("File not found. Please scan in new file.");
	    }
	
	// BufferedReader br = null;
 // 	String[] rawtext = null;
 // 	File file = new File("turn.txt");

	// 	try {
 
	// 		String sCurrentLine;
 
	// 		br = new BufferedReader(new FileReader("turgenev.txt"));
	// 		//String content = "This is the content to write into file";

	// 		while (br.ready()) {
				
	// 			// use regex to remove the punctuation and spaces
	// 			rawtext = (((br.readLine()).replaceAll("[^a-zA-Z]+", " ")).toLowerCase()).split(" ");
	// 			// String strippedInput = sCurrentLine.replaceAll("[^a-zA-Z]+", " ");
	// 		}

 // 			// if file doesnt exists, then create it
	// 		if (!file.exists()) {
	// 			file.createNewFile();
	// 		}
 
	// 		FileWriter fw = new FileWriter(file.getAbsoluteFile());
	// 		BufferedWriter bw = new BufferedWriter(fw);
	// 		for(String str : rawtext)
	// 			bw.write(str);
	// 		bw.close();
 
	// 		System.out.println("Done");

 
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	} finally {
	// 		try {
	// 			if (br != null)br.close();
	// 		} catch (IOException ex) {
	// 			ex.printStackTrace();
	// 		}
	// 	} 

	// 	//System.out.println("Stripped string: " + strippedInput);


	}

}



