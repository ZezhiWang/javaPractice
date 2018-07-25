import java.util.*;
import java.io.*;

class HuffmanCode {
   
   TreeNode root;
   Map<Character,String> codeMap;
   Map<Character,Double> freqMap;
   
   /*
    This is the constructor for HuffmanCode.  It needs to
    1. Build the Huffman tree.
    2. Generate the code table from the tree.
    */
   HuffmanCode(Map<Character,Double> freqMap){
    
    this.freqMap = freqMap;

    PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>();
    
    for(Map.Entry<Character,Double> entry : freqMap.entrySet()) {
      Character key = entry.getKey();
      Double value = entry.getValue();
      TreeNode temp = new TreeNode(key,value);
      queue.add(temp);
    }

    while(queue.size()>1){
      TreeNode left = queue.remove();
      TreeNode right = queue.remove();
      TreeNode newtemp = new TreeNode(left.freq+right.freq,left,right);
      queue.add(newtemp);
    }

    root = queue.remove();

    codeMap = new TreeMap<Character,String>();
    codeMap = buildMap(codeMap,root,"");
   }

   public Map<Character,String> buildMap(Map<Character,String> codeMap, TreeNode node, String start){
    if(node.isLeaf())
      codeMap.put(node.letter,start);
    else
      if(node.left!=null)
        codeMap = buildMap(codeMap, node.left, start+"0");
      if(node.right!=null)
        codeMap = buildMap(codeMap, node.right, start+"1");
    return codeMap;
   }
   
   public String encode(String plain){
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < plain.length(); i++){
      Character ch = plain.charAt(i);
      result.append(codeMap.get(ch));
    }
    return result.toString();
   }
   
   public String decode(String code){
    StringBuilder result = new StringBuilder();
    TreeNode temp = root;
    for(int i = 0; i < code.length(); i++){
      if(code.charAt(i) == '0')
        temp = temp.left;
      else
        temp = temp.right;
      if(temp.isLeaf()){
        result.append(temp.letter);
        temp = root;
      }
    }
    return result.toString();
   }
   
   public double bitsperchar(){
      Double totallength = 0.0;
      Double count = 0.0;
      for(Map.Entry<Character,Double> entry : this.freqMap.entrySet()) {
        Character key = entry.getKey();
        Double chfreq = entry.getValue();
        int codelen = this.codeMap.get(key).length();
        totallength += chfreq * codelen;
        count += chfreq;
      }
      return totallength/count;
   }
   
   /*
    The main method in this class reads in a frequency map
    and builds a HuffmanCode from the map.  The input is 
    read from a file specified on the command line, or 
    (if no filename is not given) System.in.  The output
    of the program is a display of the code map.
    */
   public static void main(String[] args) throws IOException{
      Map<Character,Double> tempMap = new TreeMap<Character,Double>();
      Scanner sc;
      if(args.length >= 1)
        sc = new Scanner(new File(args[0]));
      else
        sc = new Scanner(System.in);

      while(sc.hasNextLine()){
        String[] arr = sc.nextLine().split("\\s+");
        int ch = Integer.parseInt(arr[0]);
        Character letter = (char)ch;
        Double freq = Double.parseDouble(arr[1]);
        tempMap.put(letter,freq);
      }

      HuffmanCode huffman = new HuffmanCode(tempMap);

      System.out.println("bits per character: " + huffman.bitsperchar());

      for(Map.Entry<Character,String> entry : huffman.codeMap.entrySet()) {
        Character key = entry.getKey();
        String value = entry.getValue();
        int ascii = (int)key;
        System.out.println(key + " " + ascii + " " + value);
      }
      System.out.println("bits per character: " + huffman.bitsperchar());
   }
   
}






