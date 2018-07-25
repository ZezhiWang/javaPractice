import java.util.*;

public class RadixSort{
  static class QueueArray extends LinkedQueue<String>{}
  public static void main(String[] args){
    String output = "";
    QueueArray[]group = new QueueArray[26];
    for(int x = 0; x < 26; x++){
      group[x] = new QueueArray();
    }
    LinkedQueue<String> result = new LinkedQueue<String>();
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()){
        result.enqueue(sc.nextLine());
    }
    for(int i=6; i >= 0; i--){
      for(int j=0; j < 26; j++){
        group[j].clear();
      }
      while(!result.isEmpty()){
        String temp = result.dequeue();
        char c = temp.charAt(i);
        int index = c-'a';
        group[index].enqueue(temp);
      }
      for(int n=0; n < 26; n++){
        result.append(group[n]);
      }
   }
   while(!result.isEmpty()){
     output += result.dequeue();
     output += "\n";
   }
   System.out.println(output);
  }
}