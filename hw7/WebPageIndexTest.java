import junit.framework.TestCase;
import java.util.*;

public class WebPageIndexTest extends TestCase {
  
  public void testGoogle() {
    WebPageIndex map = new WebPageIndex("http://www.google.com/");

    assertEquals("getWordCount",map.getWordCount(),38);
    assertEquals("getUrl",map.getUrl(),"http://www.google.com/");
    assertEquals("contains",map.contains("google"),true);
    assertEquals("getCount",map.getCount("google"),1);
    assertEquals("getFrequency",map.getFrequency("google"),0.02631578966975212);
    List<Integer> temp = new ArrayList<Integer>();
    temp.add(34);
    assertEquals("getLocations",map.getLocations("google"),temp); 
    
    assertEquals("containsPhrase",map.containsPhrase("2016 privacy"),true);
    assertEquals("getPhraseCount",map.getPhraseCount("2016 privacy"),1);
    assertEquals("getPhraseFrequency",map.getPhraseFrequency("2016 privacy"),0.02631578966975212);
    List<Integer> temp2 = new ArrayList<Integer>();
    temp2.add(35);
    assertEquals("getPhraseLocations",map.getPhraseLocations("2016 privacy"),temp2);
  }
  
  public void testBC() {
    WebPageIndex map = new WebPageIndex("http://www.bc.edu/");
    
    assertEquals("getWordCount",map.getWordCount(),555);
    assertEquals("getUrl",map.getUrl(),"http://www.bc.edu/");
    assertEquals("contains",map.contains("and"),true);
    assertEquals("getCount",map.getCount("and"),11);
    assertEquals("getFrequency",map.getFrequency("and"),0.019819820299744606);
    List<Integer> temp = new ArrayList<Integer>(Arrays.asList(139,143,185,269,332,336,346,361,386,429,475));
    assertEquals("getLocations",map.getLocations("and"),temp);
    
    assertEquals("containsPhrase",map.containsPhrase("official dance team"),true);
    assertEquals("getPhraseCount",map.getPhraseCount("official dance team"),1);
    assertEquals("getPhraseFrequency",map.getPhraseFrequency("official dance team"),0.0018018018454313278);
    List<Integer> temp2 = new ArrayList<Integer>();
    temp2.add(458);
    assertEquals("getPhraseLocations",map.getPhraseLocations("official dance team"),temp2);
  }
  
}
