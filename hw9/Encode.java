import java.util.*;
import java.io.*;
public class Encode {
  
  
  public static void main(String[] args)throws IOException{
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
        String line = sc.nextLine()+"\n";
        result.append(huffman.encode(line));
      }
      
      System.out.print(result);
  }
  
}
