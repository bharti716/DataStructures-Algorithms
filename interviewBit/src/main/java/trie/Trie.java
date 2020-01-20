package trie;

public class Trie {

    static private final int alphabet_size = 26;
    static TrieNode root;

    static class TrieNode {
        TrieNode children[] = new TrieNode[alphabet_size];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < alphabet_size; i++) {
                children[i] = null;

            }
        }


    }

    static void insert(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];

        }
        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key){

        int level ;
        int index ;
        int length = key.length();
        TrieNode node = root ;
        for(level = 0 ; level < length ; level++){
            index = key.charAt(level) - 'a' ;
            if(node.children[index] == null){
                return false ;
            }
            node = node.children[index];
        }
        return (node != null && node.isEndOfWord) ;

    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"not present", "present"};

        root = new TrieNode();

        for (String key : keys) {
            insert(key);
        }

        // Search for different keys
        if(search("the"))
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these"))
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
    }




}
