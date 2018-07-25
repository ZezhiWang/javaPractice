import java.util.*;

class TreeNode implements Comparable<TreeNode> {
   double freq;
   char letter;
   TreeNode left,right;
   
   TreeNode(double freq,TreeNode left,TreeNode right){
      this.freq = freq;
      this.left = left;
      this.right = right;
   }
   
   TreeNode(double freq){
      this(freq,null,null);
   }
   
   TreeNode(char letter, double freq){
      this.freq = freq;
      this.letter = letter;
      this.left = this.right = null;
   }
   
   public boolean isLeaf(){
      return left==null && right==null;
   }
   
   public int compareTo(TreeNode other){
     int result;
     if(other.freq-this.freq < 0)
       result = 1;
     else if(other.freq-this.freq > 0)
       result = -1;
     else
       result = 0;
     return result;
   }
}









