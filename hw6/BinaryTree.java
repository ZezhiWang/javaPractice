import java.util.*;

public class BinaryTree<E> {

  protected E data;
  protected BinaryTree<E> left,right;

  BinaryTree(){
    data = null;
    left = right = null;
  }

  BinaryTree(E item){
    data = item;
    left = new BinaryTree<E>();
    right = new BinaryTree<E>();
  }

  BinaryTree(E item, BinaryTree<E> left, BinaryTree<E> right)
  {
    data = item;
    this.left = left;
    this.right = right;
  }

  public E getData(){
    return data;
  }

  public BinaryTree<E> getLeft(){
    return left;
  }

  public BinaryTree<E> getRight(){
    return right;
  }

  public void setData(E obj){
    data=obj;
  }

  public void setLeft(BinaryTree<E> tree){
      left = tree;
  }

  public void setRight(BinaryTree<E> tree){
      right = tree;
  }

  public boolean isEmpty(){
    return left == null;
  }

  public boolean isLeaf(){
    return !isEmpty() && left.isEmpty() && right.isEmpty();
  }

  public int nodeCount(){
    if(isEmpty())
      return 0;
    else
      return 1 + left.nodeCount()+right.nodeCount();
  }

  public int leafCount(){
    if(isEmpty())
      return 0;
    else if(isLeaf())
      return 1;
    else
      return left.leafCount() + right.leafCount();
  }

  public BinaryTree<E> mirrorImage(){
    if(isEmpty())
      return this;
    else
      return new BinaryTree<E>(data,right.mirrorImage(),left.mirrorImage());
  }

  public int height(){
    if(isEmpty())
      return -1;
    else
      return Math.max(left.height(),right.height()) + 1;
  }

  public int levelCount(int level){
    if(isEmpty())
      return 0;
    else if(level == 0)
      return 1;
    else
      return left.levelCount(level - 1) + right.levelCount(level - 1);
  }

  public int weightBalanceFactor(){
    if(isEmpty())
      return 0;
    else{
      int wl = left.weightBalanceFactor();
      int wr = right.weightBalanceFactor();
      int dist = Math.abs(left.nodeCount() - right.nodeCount());
      return Math.max(wl,dist,wr);
    }
  }

  public int nodeSum(){
    if(isEmpty())
      return 0;
    else
      return Integer.parseInt((String) getData()) + left.nodeSum() + right.nodeSum();
  }

  @SuppressWarnings("unchecked")
  public void doubles(){
    if(!isEmpty()){
      left.doubles();
      right.doubles();
      String temp = "" + Integer.parseInt((String) data) * 2;
      if(data.getClass() == temp.getClass())
        data = (E)temp;
    }
  }

  public int maxPathSum(){
    if(isEmpty())
      return 0;
    else{
      if(left.maxPathSum() > right.maxPathSum())
        return left.maxPathSum() + Integer.parseInt((String) getData());
      else
        return right.maxPathSum() + Integer.parseInt((String) getData());
    }
  }

  public String preOrder(){
    if(!isEmpty()){
      String l = left.preOrder();
      String r = right.preOrder();
      return data + " " + l + r;
    }
    else
    return "";
  }

  public String inOrder(){
    if(!isEmpty()){
      String l = left.inOrder();
      String r = right.inOrder();
      return l + " " + data + " " + r;
    }
    else
      return "";
  }

  public String postOrder(){
    if(!isEmpty()){
      String l = left.postOrder();
      String r = right.postOrder();
      return l + r + data + " ";
    }
    else
      return "";
  }

  public String levelOrder(){
    Queue<BinaryTree<E>> queue=new LinkedList<BinaryTree<E>>();  
    queue.add(this);
    String result = "";
    while(!queue.isEmpty())  
    {  
      BinaryTree<E> temp=queue.poll();
      result += temp.data + " ";  
      if(!temp.left.isEmpty())  
        queue.add(temp.left);  
      if(!temp.right.isEmpty())  
        queue.add(temp.right); 
    } 
    return result;
  }

  public String toString( String indent ) {
    if(isEmpty())
      return "";
    else
      return right.toString( indent + "   " ) + "\n" +
       indent + "/\n" +
       indent + data + "\n" +
       indent + "\\" +
       left.toString( indent + "   ");
  }

  public String toString() {
      return toString("");
  }
}
