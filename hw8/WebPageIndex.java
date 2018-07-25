import java.util.*;
import java.io.*;

public class WebPageIndex {
   
   private MyTreeMap<String,List<Integer>> map = new MyTreeMap<String,List<Integer>>();
   private String url;
   private int wordcount;

   WebPageIndex(String url) {
    this.url = url;
     try{
       HTMLScanner scanner = new HTMLScanner(url);
       int counter = 0;
       while(scanner.hasNext()){
         String token = scanner.next();
         token = token.toLowerCase();
         List<Integer> list = map.get(token);
         if(list == null)
           list = new ArrayList<Integer>();
         list.add(counter);
         map.put(token,list);
         counter++;
         wordcount++;
       }
     }
     catch (FileNotFoundException e){System.out.println(url);}
     catch (IOException e) {System.out.println(url);}
   }     
   
   public int getWordCount(){return wordcount;}
   
   public String getUrl(){return this.url;}
   
   public boolean contains(String s){
      s = s.toLowerCase();
      List<Integer> result = map.get(s);
      return result != null;
   }
   
   public int getCount(String s){
      s = s.toLowerCase();
      List<Integer> list = map.get(s);
      if(list == null)
        return 0;
      return list.size();
   }
   
   public double getFrequency(String s){
      s= s.toLowerCase();
      return (float)getCount(s) / getWordCount();
   }
   
   public List<Integer> getLocations(String s) {
      s = s.toLowerCase();
      List<Integer> result = map.get(s);
      if(result == null)
         return new ArrayList<Integer>();
      return result;
   }

   public Iterator<String> words(){return map.keys();}
   
   public String toString(){return map.toString();}

   public static void main(String[] args) throws IOException {
      
      if(args.length<1){
         System.out.println("Usage: java TestScanner <url>");
         System.exit(1);
      }
      
      System.out.println("Frequency and index of words in " + args[0]);
      
      try{
         String URL=args[0];
         WebPageIndex map = new WebPageIndex(URL);
         Iterator<String> itr = map.words();
         while(itr.hasNext()){
          String key = itr.next();
          String frequency = String.format("%.5f",map.getFrequency(key));
          String location = map.getLocations(key).toString();
          System.out.println(key+"      "+frequency+" "+location);
         }
      }
      
      catch (Exception e) {}
   }

   
   @SuppressWarnings("unchecked")
   public boolean containsPhrase(String s) {
     s = s.toLowerCase();
     boolean checker = true;
     
     String[] temp = s.split("\\s+");
     int n = temp.length;
     
     List<Integer>[] list = (ArrayList<Integer>[])new ArrayList[n];
     for(int x = 0; x < n; x++)
       list[x] = getLocations(temp[x]);
     
     for(int i : list[0]){
       checker = true;
       
       for(int j = 1; j < n; j++){
         if(!list[j].contains(i+j)){
           checker = false;
           break;
         }
       }
       
       if(checker)break;
     }
     
     return checker;
   }
   
   @SuppressWarnings("unchecked")
   public int getPhraseCount(String s) {
     s = s.toLowerCase();
     int result = 0;
     
     String[] temp = s.split("\\s+");
     int n = temp.length;
     
     List<Integer>[] list = (ArrayList<Integer>[])new ArrayList[n];
     for(int x = 0; x < n; x++)
       list[x] = getLocations(temp[x]);
     
     for(int i : list[0]){
       
       boolean checker = true;
       
       for(int j = 1; j < n; j++){
         if(!list[j].contains(i+j)){
           checker = false;
           break;
         }
       }
       
       if(checker) result += 1;
     }
     return result;
   }
   
   public double getPhraseFrequency(String s){return (float)getPhraseCount(s) / getWordCount();}

   @SuppressWarnings("unchecked")
   public List<Integer> getPhraseLocations(String s) {
     s = s.toLowerCase();
     List<Integer> result = new ArrayList<Integer>();
    
     String[] temp = s.split("\\s+");
     int n = temp.length;
     
     List<Integer>[] list = (ArrayList<Integer>[])new ArrayList[n];
     for(int x = 0; x < n; x++)
       list[x] = getLocations(temp[x]);
     
     for(int i : list[0]){
       
       boolean checker = true;
       
       for(int j = 1; j < n; j++){
         if(!list[j].contains(i+j)){
           checker = false;
           break;
         }
       }
       
       if(checker) result .add(i);
     }
     return result;
   }
   
   
}
