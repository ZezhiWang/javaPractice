import junit.framework.TestCase;
public class MRUListTest extends TestCase {
  public void testString() {
    MRUList<String> list0 = new MRUList<String>();
    list0.add("10");
    list0.add(10,"20");
    list0.add(99,"30");
    list0.add(2,"40");
    list0.add(1,"50");
    assertEquals("00",list0.indexOf("50"),0);
    assertEquals("01",list0.indexOf("40"),1);
    assertEquals("02",list0.indexOf("50"),1);
    assertEquals("03",list0.contains("10"),true);
    assertEquals("04",list0.indexOf("50"),1);
    assertEquals("05",list0.indexOf("60"),-1);
    assertEquals("06",list0.contains("60"),false);
  }
  
  public void testInteger(){
    MRUList<Integer> list0 = new MRUList<Integer>();
    list0.add(10);
    list0.add(10,20);
    list0.add(99,30);
    list0.add(2,40);
    list0.add(1,50);
    assertEquals("00",list0.indexOf(50),0);
    assertEquals("01",list0.indexOf(40),1);
    assertEquals("02",list0.indexOf(50),1);
    assertEquals("03",list0.contains(10),true);
    assertEquals("04",list0.indexOf(50),1);
    assertEquals("05",list0.indexOf(60),-1);
    assertEquals("06",list0.contains(60),false);
  }
  
}
