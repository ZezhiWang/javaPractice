import junit.framework.TestCase;
import java.util.*;

public class MyTreeMapTest extends TestCase {
  
  public void testMTM() {
   MyTreeMap<Integer,String> map = new MyTreeMap<Integer,String>();
   
   map.put(1,"1");
   map.put(2,"2");
   map.put(3,"3");

   assertEquals("test1",map.get(1),"1");
   assertEquals("test2",map.get(2),"2");
   assertEquals("test3",map.get(3),"3");
   assertEquals("test4",map.put(1,"10"),"1");
   assertEquals("test5",map.put(2,"20"),"2");
   assertEquals("test6",map.put(3,"30"),"3");
   
   map = new MyTreeMap<Integer,String>();
   for(int i = 0; i<20; i++){
     String temp = map.get(i);
     if(temp == null)
       temp = ""+i;
     map.put(i,temp);
   }
   
   for(int j = 0; j<20; j++)
     assertEquals(map.get(j),""+j);
   

  }
}

  
