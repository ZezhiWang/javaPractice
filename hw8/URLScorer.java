/**
 * This class contains the code to compute the relevance score of a
 * web page, in response to a query.  It also contains a method to
 * compare the scores of two web pages.
 *
 * @author John Donaldson (Fall 2014)
 */

import java.util.*;

class URLScorer implements Comparator<WebPageIndex> {

   List<String> query;
   
   URLScorer(List<String> query){
      this.query = query;
   }
   
   public int score(WebPageIndex idx){
    int result = 0;
    String temp = "";
    for(String word:query){
      if(word.startsWith("\""))
        temp = word.substring(1) + " ";
      else if(word.endsWith("\"")){
        temp += word.substring(0,word.length()-1);
        result += idx.getPhraseCount(temp);
        temp = "";
      }
      else{
        if(temp == "")
          result += idx.getCount(word);
        else
          temp += word + " ";
      }   
    }
    return result;
   }
      
    public int compare(WebPageIndex idx1, WebPageIndex idx2){ 
       return score(idx1)-score(idx2);
    }

}
