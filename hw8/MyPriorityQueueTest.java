import junit.framework.TestCase;
import java.util.*;

public class MyPriorityQueueTest extends TestCase {
  
  public void testMPQTest() {
    MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer x, Integer y){
            return x-y;
        }
    });
    
    for(int i = 0; i < 20; i++)
      queue.add(i);
    
    for(int j = 19; j >= 0; j--)
      assertTrue(queue.remove()==j);
    
    assertTrue(queue.remove()==null);
  }
  
  public void testRandom() {
    MyPriorityQueue<Integer> queue = new MyPriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer x, Integer y){
            return x-y;
        }
    });
    
    queue.add(67);
    queue.add(52742);
    queue.add(2757);
    queue.add(78278);
    queue.add(76785);
    queue.add(7578);
    queue.add(7278);
    
    assertTrue(queue.remove()==78278);
    assertTrue(queue.remove()==76785);
    assertTrue(queue.remove()==52742);
    assertTrue(queue.remove()==7578);
    assertTrue(queue.remove()==7278);
    assertTrue(queue.remove()==2757);
    assertTrue(queue.remove()==67);
    
    assertTrue(queue.remove()==null);
  }
  
}
