import java.util.*;
import java.io.*;

public class Trie {

    private Node base;

    public Trie() {
        base = new Node();
    }

    public void addNode(String string) {
        Node node = base;

        for(char c : string.toCharArray()) {
            if(node.hasChild(c)) {
                node = node.getChild(c);
            } else {
                node = node.addChild(c);
            }
        }
    }

    public boolean mismatchQuery(String string) {
        Node node = base;
        int i = 0;
        int mismatch = 0;
        
        while(mismatch < 3) {
            if(i >= string.length()) break;    
               
            if(node.getChild(string.charAt(i)) != null)
                node = node.getChild(string.charAt(i));
            else if(node.getChild(string.charAt(i)) == null){    
                mismatch++;
                if (node.getChildren().size() > 0) 
                   node = node.getChildren().getFirst(); 
                else {
                    if((mismatch + string.length() - i ) >= 3)
                        node = null;break;

                }
            }                    
            i++;
        }

        return node != null;
    }


    public boolean prefixQuery(String string) {
        Node node = base;
        int i = 0;

        while(node != null ) {
            if(i >= string.length()) break; 
            node = node.getChild(string.charAt(i));
            i++;
        }

        return node != null;
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Trie trie = new Trie();
        String s = null;
        String s2 = null;
        try {
            File input = new File("turn.txt");
            File input2 = new File("surnames.txt");
            File output = new File("trieResult.txt");
            File output2 = new File("trieResult_prefix.txt");
            Scanner sc = new Scanner(input);
            Scanner sc2 = new Scanner(input2);
            PrintWriter printer = new PrintWriter(output);
            PrintWriter printer2 = new PrintWriter(output2);

            //add words to trie to build it
            while(sc.hasNext()) {
                s = sc.next();
                trie.addNode(s);
            }

            //search each words from surnames.txt in trie 
            //with two trie methods
            while(sc2.hasNext()) {
                s = sc2.next(); 
                // trie with mismatch
                s2 = s + ' ' + trie.mismatchQuery(s) + '\n';
                printer.write(s2);
                // trie by search from any node on surname prefix
                s2 = s + ' ' + trie.prefixQuery(s) + '\n';
                printer2.write(s2);
            }
            sc.close();
            sc2.close();
            printer.close();
            printer2.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("File not found. Please scan in new file.");
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }

}
