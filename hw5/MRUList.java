import java.util.*;

class MRUList<T> extends DoublyLinkedList<T> {
 	public MRUList(){
  		super();
 	}
    public boolean add(T x){
      super.add(0,x);
      return true;
    }
    public void add(int index, T x){
      super.add(0,x);
    }

    public boolean contains(Object obj){
      boolean checker = false;
      Iterator<T> itr = super.iterator();
      int index = 0;
      while(index < super.size()){
       		T temp = itr.next();
       		if(temp.equals(obj)){
        		add(temp);
        		itr.remove();
        		checker = true;
        		break;
       		}
       		index += 1;
      	}
      return checker;
    }

    public int indexOf(Object obj){
      int index = 0;
      boolean checker = false;
      Iterator<T> itr = super.iterator();
      while(index < super.size()){
       T temp = itr.next();
       if(temp.equals(obj)){
        add(temp);
        itr.remove();
        checker = true;
        break;
       }
       index += 1;
      }
      if(!checker)
       index = -1;
      return index;
    }
}
