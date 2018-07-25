import java.util.*;

public class DoublyLinkedList<T> extends AbstractList<T> {
   int size;
   ListNode header, trailer;
   
   protected class ListNode {
      T datum;
      ListNode prior, next;
      
      ListNode(){
         this(null);
      }
      
      ListNode(T data){
         this(data,null,null);
      }
      
      ListNode(T data, ListNode prior, ListNode next){
         this.datum = data;
         this.prior = prior;
         this.next = next;
      }
   }
   
   DoublyLinkedList(){
      header = trailer = new ListNode(null,null,null);
      size = 0;
   }
   
   private ListNode getNthNode(int n) {
      ListNode node = header;
      for(int i=0; i<n; i++)
         node = node.next;
      return node;
   }
   
   public int size() {
      return size;
   }
   
   public T get(int position) {
    if(position > size - 1)
      throw new IndexOutOfBoundsException();
    ListNode temp = getNthNode(position);
    return temp.datum;
   }
   
   public T set(int position, T data) {
    if(data.equals(null))
      throw new NullPointerException();
    if(position > size - 1)
      throw new IndexOutOfBoundsException();
    ListNode temp = getNthNode(position);
    T val = temp.datum;
    temp.datum = data;
    if(position != 0)
      temp.prior.next = temp;
    if(position != size - 1)
      temp.next.prior = temp;
    return val;
   }
   
   public boolean add(T data) {
    if(isEmpty())
      header = trailer = new ListNode(data,null,null);
    else{
      ListNode temp = new ListNode(data,trailer,null);
      if(trailer != null)
        trailer.next = temp;
      trailer = temp;
      if(header == null)
        header = temp;
    }
    size++;
    return true;
   }
   
   public void add(int position, T data) {
    if(data.equals(null))
      throw new NullPointerException();
    else if(position > size - 1 && size != 0)
      throw new IndexOutOfBoundsException();

    else if(position == 0){
      ListNode temp = new ListNode(data,null,header);
      if(header != null )
        header.prior = temp;
      header = temp;
      if(trailer == null)
        trailer = temp;
      size++;
    }

    else{
      ListNode node = getNthNode(position);
      ListNode temp = new ListNode(data,node.prior,node);
      node.prior = temp;
      if(position != size - 1)
        node.next.prior = node;
      if(position != 0)
        temp.prior.next = temp;
      size++;
    }
   }
   
   public T remove(int index) {
     T val;
    if(index > size - 1)
      throw new IndexOutOfBoundsException();
    else if(index == size - 1){
      val = trailer.datum;
      trailer = trailer.prior;
      trailer.next = null;
      size--;
    }
    else if(index == 0){
      val = header.datum;
      header = header.next;
      header.prior = null;
      size--;
    }
    else{
      ListNode temp = getNthNode(index);
      val = temp.datum;
      temp.prior.next = temp.next;
      temp.next.prior = temp.prior;
      size--;
    }
    return val;
   }
   
   /*
    * Searches the list for the given object
    */
   public boolean contains(Object obj){
    ListNode temp = header;
    boolean checker = false;
    int index = 0;
    while(index < size){
      if(obj.equals(temp.datum)){
        checker = true;
        break;
      }
      temp = temp.next;
      index += 1;
    }
    return checker;
   }
   
   /*
    * Returns the position of the given object
    */
   public int indexOf(Object obj){
      int index = 0;
      boolean checker = false;
      ListNode temp = header;
      while(index < size){
        if(obj.equals(temp.datum)){
          checker = true;
          break;
        }
        index += 1;
        temp = temp.next;
      }
      if(!checker)
        index = -1;
      return index;
   }
   
   public void clear() {
       header = trailer = new ListNode(null,null,null);
       size = 0;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public Iterator<T> iterator(){
      return new Iterator<T>(){
         ListNode current = header;
         
         public boolean hasNext(){
            return current!=trailer;
         }
         public T next(){
            T item = current.datum;
            current = current.next;
            return item;
         }
         public void remove(){
            ListNode prior = current.prior.prior;
            prior.next = current;
            current.prior = prior;
            size--;
         }
      };
   }
}

