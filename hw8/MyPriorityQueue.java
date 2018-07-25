import java.util.*;

class MyPriorityQueue<E> implements PriorityQueueADT<E> {
   
   ArrayList<E> heap;
   Comparator<E> comparator;
   int size;
      
   MyPriorityQueue(Comparator<E> comparator){
      this.comparator = comparator;
      heap = new ArrayList<E>();
      size = 0;
   }
   
   public boolean add(E item){
      heap.add(item);
      size++;
      siftUp(size-1);
      return true;
   }
   
   public E remove(){
      E result = null;
      if(size == 1){
         result = heap.remove(0);
         size = 0;
      }
      if(!isEmpty()){
         result = heap.get(0);
         heap.set(0,heap.remove(size-1));
         size--;
         siftDown(0);
      }
      return result;
   }
   
   public boolean isEmpty(){
      return size == 0;
   }
   
   public String toString(){
      return heap.toString();
   }
   
   private void siftUp(int pos){
      E val = heap.get(pos);
      while(pos > 0 && comparator.compare(heap.get((pos-1)/2),val) < 0){
         heap.set(pos,heap.get((pos-1)/2));
         pos = (pos-1)/2;
      }
      heap.set(pos,val);
   }
         
   private void siftDown(int pos){
      E val = heap.get(pos);
      while(2*pos + 1 < size){
         int left = 2*pos + 1;
         E l = heap.get(left);
         int right = left;
         E r = l;
         if(right+1<size){
            right += 1;
            r = heap.get(right);
         }
         if(comparator.compare(val,r) < 0 || comparator.compare(val,l) < 0){
            if(comparator.compare(l,r) > 0){
               heap.set(pos,l);
               pos = left;
            }
            else{
               heap.set(pos,r);
               pos = right;
            }   
         }
         else
            break;
      }
      heap.set(pos,val);
   }   
   
}