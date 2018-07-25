import java.util.*;
import java.io.*;

public class ProcessQueries {
 
  public static void main(String[] args) throws FileNotFoundException{
    
    if(args.length<1){
      System.out.println("error");
      System.exit(1);
    }
    

   List<String> urlFileList = new ArrayList<String>();
   int count;
   if(args.length<2)
     count = 10;
   else
     count = Integer.parseInt(args[1]);
  
   Scanner docScanner = new Scanner(new File(args[0]));
   while(docScanner.hasNext()){
     urlFileList.add(docScanner.next());
   }
    
   List<WebPageIndex> list = new ArrayList<WebPageIndex>();
   int counter = 0;
   for(String url:urlFileList){
     WebPageIndex map = new WebPageIndex(url);
     list.add(map);
     counter++;
     if(counter % 100 == 0)
       System.out.println(counter);
   }

   Scanner sc = new Scanner(System.in);
   while(sc.hasNextLine()){
     
     List<String> query = new ArrayList<String>(Arrays.asList(sc.nextLine().split("\\s+")));

     URLScorer comp = new URLScorer(query);
     MyPriorityQueue<WebPageIndex> queue = new MyPriorityQueue<WebPageIndex>(comp);

     for(WebPageIndex temp:list){
       queue.add(temp);
     }
   
     if(count > list.size())
       count = list.size();
   
     for(int i = 0; i<count; i++){
       WebPageIndex temp = queue.remove();
       int num = comp.score(temp);
       String url = temp.getUrl();
       System.out.println("(score: " + num + ") " + url);
     }
   }
  }
}
