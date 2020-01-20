package trie;


public class RenameCity {

    static private final int alphabet_size = 26;
    static TrieNode root;

    static class TrieNode {
        TrieNode children[] ;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[alphabet_size];
            isEndOfWord = false;
            for (int i = 0; i < alphabet_size; i++) {
                children[i] = null;

            }
        }


    }
    private static String generateCode(String key){
        int level ;
        int index ;
        int length = key.length();
        boolean add = true ;
        TrieNode node = root ;
        StringBuilder sb = new StringBuilder();
        for(level = 0 ; level < length ; level++){
            index = key.charAt(level) - 'a' ;
            if(node.children[index] == null){
                if(add) {
                    sb.append(key.charAt(level));
                }
                add = false ;
                node.children[index] = new TrieNode();
            }
            if(add){
                sb.append(key.charAt(level));
            }
            node = node.children[index];
        }
        if(!node.isEndOfWord){
            node.isEndOfWord = true ;
        }
        else
            sb.append("2");

        return sb.toString();

    }
    public static void main(String[] args) {
        String keys[] = {"shimla", "safari", "jammu", "delhi", "dehradun", "jammu"};

        root = new TrieNode() ;
        for (String key : keys) {
            String code = generateCode(key);
            System.out.println("Code for " + key + " is - " + code);
        }



    }
}
