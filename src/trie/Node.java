
import java.util.*;
import java.text.Collator;

public class Node implements Comparable<Node>{

    private Character value;
    private HashMap<Character, Node> children;

    public Node() {
        children = new LinkedHashMap<Character, Node>();
    }

    public Node(Character value) {
        this();
        this.value = value;
    }

    public Node getChild(Character c) {
        return children.get(c);
    }

    public LinkedList<Node> getChildren() {
        LinkedList<Node> sorted = new LinkedList<Node>(children.values());
        Collections.sort(sorted);
        return sorted;
    }

    public boolean hasChild(Character c) {
        return (children.get(c) != null);
    }

    public Node addChild(Character c) {
        Node child = new Node(c);
        children.put(c, child);
        return child;
    }

    @Override
    public int compareTo(Node o) {
        return value.compareTo(o.value);
    }
}
