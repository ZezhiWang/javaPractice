import java.util.*;
import java.io.*;
public class Decode {
  
  
  public static void main(String[] args) {
    try{
      Scanner docScanner = new Scanner(new File(args[0]));
      Map<Character,Double> freqMap = new TreeMap<Character,Double>();
      while(docScanner.hasNextLine()){
        String[] temp = docScanner.nextLine().split("\\s+");
        int ch = Integer.parseInt(temp[0]);
        Character letter = (char)ch;
        Double freq = Double.parseDouble(temp[1]);
        freqMap.put(letter,freq);
      }

      HuffmanCode huffman = new HuffmanCode(freqMap);

      Scanner sc = new Scanner(System.in);
      StringBuilder result = new StringBuilder();

      while(sc.hasNextLine()){
        String line = sc.nextLine();
        result.append(huffman.decode(line));
      }
      System.out.print(result);
    }
    catch(Exception e){
      System.out.println(e);
    }
  } 
}
