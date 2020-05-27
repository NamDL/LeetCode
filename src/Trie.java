import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/implement-trie-prefix-tree/submissions/

class Trie {
    Node root;

    public class Node {
        Map<Character, Node> map;
        char ch;
        boolean isValidWord;

        public Map<Character, Node> map() {
            return map;
        }

        public boolean isValidWord() {
            return isValidWord;
        }

        public void setMap(Map<Character, Node> map) {
            this.map=map;
        }

        public void setCh(char ch) {
            this.ch=ch;
        }

        public void setIsValidWord(boolean val) {
            this.isValidWord=val;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
        root.setMap(new HashMap<>());
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node=root;
        char[] cha = word.toCharArray();
        for(int i=0;i<cha.length;i++) {
            if(node.map.get(cha[i])==null) {
                node.map.put(cha[i],constructWord(word.substring(i)));
                break;
            } else {
                node = node.map.get(cha[i]);
                if(i==cha.length-1) node.setIsValidWord(true);
            }
        }
    }

    private Node constructWord(String word) {
        char[] ch=word.toCharArray();
        Node parent = getNewNode(ch[0]);
        Node previous=parent;
        for(int i=1;i<ch.length;i++) {
            Node node = getNewNode(ch[i]);
            if(i==ch.length-1) {
                node.setIsValidWord(true);
            }
            previous.map.put(ch[i], node);
            previous=node;
        }
        if(word.length()==1) parent.setIsValidWord(true);
        return parent;
    }

    private Node getNewNode(char c) {
        Node node = new Node();
        node.setCh(c);
        node.setMap(new HashMap<>());
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node=root;
        int i=0;
        while(node!=null && i<word.length()) {
            node=node.map.get(word.charAt(i));
            i++;
        }
        return node!=null && node.isValidWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node=root;
        int i=0;int count=0;
        while(node!=null && i<prefix.length()) {
            node=node.map.get(prefix.charAt(i));
            i++; count++;
        }
        return node!=null && count==prefix.length();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.search("a"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */