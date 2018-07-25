import junit.framework.TestCase;

public class LinkedQueueTest extends TestCase {
  
  public void testString() {
     LinkedQueue<String> LQ0 = new LinkedQueue<String>();
     assertEquals("isEmpty1",true,LQ0.isEmpty());
     LQ0.enqueue("BC");
     assertEquals("isEmpty2",false,LQ0.isEmpty());
     String temp0 = LQ0.dequeue();
     assertEquals("dequeue1","BC",temp0);
     
     LinkedQueue<String> LQ1 = new LinkedQueue<String>();
     LQ0.enqueue("BC");
     LQ1.enqueue("CS");
     LQ0.append(LQ1);
     String temp1 = "";
     while(!LQ0.isEmpty())
       temp1 += LQ0.dequeue();
     assertEquals("append","BCCS",temp1);
  }
  
  public void testInteger(){
     LinkedQueue<Integer> LQ2 = new LinkedQueue<Integer>();
     assertEquals("isEmpty1",true,LQ2.isEmpty());
     LQ2.enqueue(5);
     assertEquals("isEmpty2",false,LQ2.isEmpty());
     int temp2 = LQ2.dequeue();
     assertEquals("dequeue",5,temp2);
     
     LinkedQueue<Integer> LQ3 = new LinkedQueue<Integer>();
     LQ2.enqueue(33);
     LQ3 = LQ2;
     LQ2.append(LQ3);
     int temp3 = 0;
     for(int i = 0; i < 2; i++)
       temp3 += LQ2.dequeue();
     assertEquals("append",66,temp3);
  }
}
