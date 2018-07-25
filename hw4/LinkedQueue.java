import java.util.*;

public class LinkedQueue<T> implements QueueADT<T> {
   
   class ListNode {         
      T data;
      ListNode next;
      ListNode(T data, ListNode next){
         this.data = data;
         this.next = next;
      }
   }
   
   private ListNode front = null;
   private ListNode rear = null;

   public LinkedQueue(){
      front = null;
      rear = null;
   }
   
   public boolean isEmpty(){
      return front == null;
   }
   
   public void enqueue(T item){
      if(isEmpty())
        front = rear = new ListNode(item,null);
      else{
        ListNode temp = rear;
        rear = new ListNode(item,null);
        temp.next = rear;
      }
   }
   
   public T dequeue(){
      if(isEmpty())
         throw new NoSuchElementException("Empty");
      T frontItem = front.data;
      front = front.next;
      if(isEmpty())
         rear = null;
      return frontItem;
   }
   
   public void clear(){
      front = null;
      rear = null;      
   }

   public void append(LinkedQueue<T> other){
     if(other.isEmpty()){}
     else if(this.isEmpty()){
       front = other.front;
       rear = other.rear;
     }
     else{
       ListNode temp = rear;
       temp.next = other.front;
       rear = other.rear;
     }
   }
}