import junit.framework.TestCase;
import java.util.*;
/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class RationalTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testRationalC() {
    Rational test = new RationalC(10,3);
    assertEquals("Numerator after construction of 10/3", 10, test.getNumerator());
    assertEquals("Denominator after construction of 10/3", 3, test.getDenominator());
    test = new RationalC(10,2);
    assertEquals("Numerator after construction of 10/2", 5, test.getNumerator());
    assertEquals("Denominator after construction of 10/2", 1, test.getDenominator());
    test = new RationalC(0,12);
    assertEquals("Numerator after construction of 0/12", 0, test.getNumerator());
    assertEquals("Denominator after construction of 0/12", 1, test.getDenominator());
    test = new RationalC(24,-18);
    assertEquals("Numerator after construction of 24/-18", -4, test.getNumerator());
    assertEquals("Denominator after construction of 24/-18", 3, test.getDenominator());
    test = new RationalC(10,2);
    assertEquals("Numerator after construction of 10/2", 5, test.getNumerator());
    assertEquals("Denominator after construction of 10/2", 1, test.getDenominator());
  }
  
  public void testCompareTo(){
    Rational a = new RationalC(2,3);
    Rational b = new RationalC(3,5);
    Rational c = new RationalC(2,3);
    Rational d = new RationalC(30,50);
    Rational e = new RationalC(3,-5);

    assertTrue("compare 2/3, 3/5", a.compareTo(b) > 0);
    assertTrue("compare 3/5, 2/3", b.compareTo(a) < 0);
    assertTrue("compare 2/3, 2/3", a.compareTo(c) == 0);
    assertTrue("compare 3/5, 30/50", b.compareTo(d) == 0);
    assertTrue("compare 30/50, 3/5", d.compareTo(b) == 0);
    assertTrue("compare 3/5, -3/5", b.compareTo(e) > 0);
  }
  
  public void testAdd(){
    Rational a = new RationalC(0,3);
    Rational b = new RationalC(3,5);
    Rational c = new RationalC(30,-50);
    Rational d = new RationalC(-30,50);

    assertEquals("0/3 + 3/5", a.add(b), new RationalC(3,5));
    assertEquals("3/5 + 30/-50", b.add(c), new RationalC(0,1));
    assertEquals("0/3 + 30/-50", a.add(c), new RationalC(-3,5));
    assertEquals("-30/50", d, new RationalC(-3,5));
    
    ArrayList<Rational> temp = new ArrayList<Rational>();
    for(int i = 1;i < 10; i++){
      temp.add(new RationalC(i,i+1));
    }
    Rational sum = new RationalC(0,1);
    for(Rational r : temp){
      sum = sum.add(r);
    }
    assertEquals("Numerators of sum", 17819, sum.getNumerator());
    assertEquals("Denominators of sum", 2520, sum.getDenominator());
  }

  public void testMultiply(){
    Rational a = new RationalC(0,3);
    Rational b = new RationalC(3,5);
    Rational c = new RationalC(30,-50);

    assertEquals("0/3 * 3/5", a.multiply(b), new RationalC(0,1));
    assertEquals("3/5 * 30/-50", b.multiply(c), new RationalC(-9,25));
    assertEquals("0/3 * 30/-50", a.multiply(c), new RationalC(0,1));
    
    ArrayList<Rational> temp = new ArrayList<Rational>();
    for(int i = 1;i < 10; i++){
      temp.add(new RationalC(i,i+1));
    }
    Rational sum = new RationalC(1,1);
    for(Rational r : temp){
      sum = sum.multiply(r);
    }
    assertEquals("Numerators of multiply", 1, sum.getNumerator());
    assertEquals("Denominators of multiply", 10, sum.getDenominator());
  }

  public void testEquals(){
    Rational a1 = new RationalC(2,3);
    Rational a2 = new RationalC(-2,-3);
    Rational b1 = new RationalC(3,5);
    Rational b2 = new RationalC(3,-5);
    Rational c1 = new RationalC(-30,50);
    Rational c2 = new RationalC(30,-50);

    assertTrue("2/3, -2/-3", a1.equals(a2));
    assertFalse("3/5, 3/-5", b1.equals(b2));
    assertTrue("-30/50, 30/-50", c1.equals(c2));
    assertFalse("2/3, -30/50", a1.equals(c1));
    assertTrue("3/-5, -30/50", b2.equals(c1));
    assertFalse("3/5, 2/3", a1.equals(b1));
  }
  public void testToString(){
    Rational m = new RationalC(10,30);
    assertEquals("1/3",m.toString());
  }
}

