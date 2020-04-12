import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int lengthOfEachLine = 0 ; ;
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>() ;
        StringBuilder str = new StringBuilder();
        for(int j = 0 ; j < words.length ; j++){
            list.add(words[j]);
            str.append(words[j]);
            int minSpace = list.size() - 1 ;
            lengthOfEachLine += str.toString().length() + minSpace ;
            int extraSpace = maxWidth - str.toString().length() ;
            if(lengthOfEachLine > extraSpace){
                list.remove(j) ;
                lengthOfEachLine = lengthOfEachLine - words[j].length() ;
                int spaceLeft = maxWidth - lengthOfEachLine ;
                boolean isLastLine = (j == words.length-1) ;
                result.add(format(list , spaceLeft , isLastLine)) ;
                list.clear() ;
            }
        }
        return result ;
    }

    private String format(List<String> wordList, int spaceLeft, boolean isLastLine){
        StringBuilder sb = new StringBuilder() ;
        String space = " ";
        for(int i = 0 ; i < wordList.size()-1 ; i++){
            if(isLastLine && wordList.size() == 1){
                sb.append(wordList.get(0) + new String(new char[spaceLeft]).replace("\0", space));
            }
            else if (isLastLine){
                for(int p = 0 ; p < wordList.size() ; p++){
                    if( p != wordList.size()-1){
                        sb.append(wordList.get(p) + space);
                        spaceLeft-- ;
                    }
                    else{
                        sb.append(wordList.get(p) + new String(new char[spaceLeft]).replace("\0", space)) ;
                    }
                }
            }
            else{

            }
        }

        return sb.toString() ;
    }
}
