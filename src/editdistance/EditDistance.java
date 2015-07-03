
// Purpose : Make queries from words in surnames.txt to match words 
// in turn.txt(the dictionary). If the distance is less than 2 between
// two words, the matching is seen to be successful and the two words 
// will be output in a file. 


import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class EditDistance {

	/**
	 * Computes the edit distance between two words and return it.
	 */

	public int editDistance(String word, String match) {
		
		int[][] dmatrix = new int[word.length()+1][match.length()+1];
		
		/* fill the first column with numbers from 0 to word.length */
		/* fill the first row with numbers from 0 to match.length */

		for(int i = 0; i <= word.length(); i++) {
			dmatrix[i][0] = i;
		}
		
		for(int j = 0; j <= match.length(); j++) {
			dmatrix[0][j] = j;
		}
		
		/* build up the dmatrix from the minimum change already done to the
		 * various substrings of the words
		 */
		for(int i = 1; i <= word.length(); i++) 
			for(int j = 1; j <= match.length(); j++) {
				int equal;
				if(word.charAt(i - 1) == match.charAt(j - 1)) 
					equal = 0;
				else equal = 1;
				dmatrix[i][j] = min(
						dmatrix[i - 1][j] + 1,
						dmatrix[i][j - 1] + 1,
						dmatrix[i - 1][j - 1] + equal);
			}
		
		
		/* return the edit distance */
		return dmatrix[word.length()][match.length()];
	}
	
	/**
	 * Find the mimimum value among integers
	 * 
	 */
	public int min(int... nums) {
		Arrays.sort(nums);
		return nums[0];
	}
	
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		String s = null;
        String s2 = null;
       	EditDistance ed = new EditDistance();
        LinkedList<String> dictionary = new LinkedList<String>();
        try {
            File input = new File("turn.txt");
            File input2 = new File("surnames.txt");
            File output = new File("editDResult.txt");
            Scanner sc = new Scanner(input);
            Scanner sc2 = new Scanner(input2);
            PrintWriter printer = new PrintWriter(output);
            while(sc.hasNext()) {
                s = sc.next();
                dictionary.add(s);
                //System.out.println("addString: " + s + '\n');
                //s = sc.next().replaceAll("[^a-zA-Z]+", " ").toLowerCase().trim() + '\n';
                //printer.write(s);
            }
            printer.write("Query Match Distance\n");
            while(sc2.hasNext()) {
                s = sc2.next();
                for(String ss : dictionary){
                	int dist = ed.editDistance(s, ss);
                	if(dist <= 2){
                		s2 = s + ' ' + ss + ' ' + Integer.toString(dist) + '\n'; 
                		printer.write(s2);
                		break;
                	}
                		           
                }
                	
            }
            sc.close();
            sc2.close();
            printer.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found. Please scan in new file.");
        }

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        
	}
}