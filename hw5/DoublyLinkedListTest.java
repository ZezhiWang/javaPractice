import junit.framework.TestCase;
import java.util.*;


public class DoublyLinkedListTest extends TestCase {
  
  public void testString() {
    DoublyLinkedList<String> list0 = new DoublyLinkedList<String>();
    list0.add(0,"50");
    list0.add(0,"20");
    list0.add(0,"10");
    list0.add(2,"30");
    list0.set(3,"40");
    list0.add("50");
    assertEquals(list0.size(),5);
    assertEquals(list0.remove(4),"50");
    list0.add("null");
    list0.remove(list0.size()-1);
    assertEquals(list0.contains("20"),true);
    assertEquals(list0.indexOf("20"),1);
    assertEquals(list0.contains("50"),false);
    assertEquals(list0.indexOf("50"),-1);
    list0.clear();
    assertEquals(list0.size(),0);
  }
  
  public void testInteger(){
    DoublyLinkedList<Integer> list0 = new DoublyLinkedList<Integer>();
    list0.add(0,50);
    list0.add(0,20);
    list0.add(0,10);
    list0.add(2,30);
    list0.set(3,40);
    list0.add(50);
    assertEquals("01",list0.size(),5);
    assertTrue("02",list0.remove(4)==50);
    assertEquals("03",list0.contains(20),true);
    assertEquals("04",list0.indexOf(20),1);
    assertEquals("05",list0.contains(50),false);
    assertEquals("06",list0.indexOf(50),-1);
    
    list0.clear();
    
    
    
    
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    
    assertEquals(list0.toString(),list1.toString());
    
    for(int i = 0; i < 20; i++){
        list0.add(i);
        list1.add(i);
    }
    
    
    assertEquals(list0.get(19),list1.get(19));
    
    int sum0 = 0;
    int sum1 = 0;
    
    for(int j = 0; j < 10; j++){
        sum0 += list0.remove(j);
        sum1 += list1.remove(j);
    }
    assertEquals(sum0,sum1);

    for(int k = 0; k < 10; k++){
        list0.set(k,-k);
        list1.set(k,-k);
    }
    for(int k = 0; k < 10; k++){
      assertEquals(list0.get(k),list1.get(k));
    }
  }
}
