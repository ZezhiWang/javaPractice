import junit.framework.TestCase;
import java.util.*;

public class Test extends TestCase {
  public void testBE() {
    Expression e1 = new Number(46);
    assertEquals("e1",46,e1.valueOf());
    Expression e2 = new BinaryExpression(new Operator("/"),new Number(120),new Number(7));
    assertEquals("e2",17,e2.valueOf());
    Expression e3 = new BinaryExpression(new Operator("-"),new Number(50),new Number(15));
    assertEquals("e3",35,e3.valueOf());
    Expression e4 = new BinaryExpression(new Operator("*"),e2,e3);
    assertEquals("e4",595,e4.valueOf());
    Expression e5 = new BinaryExpression(new Operator("^"),new Number(2),new Number(3));
    assertEquals("e5",8,e5.valueOf());
    Expression e6 = new BinaryExpression(new Operator("+"),new Number(120),new Number(7));
    assertEquals("e6",127,e6.valueOf());
    Expression e7 = new BinaryExpression(new Operator("*"),new Number(63),new Number(55));
    assertEquals("e7",3465,e7.valueOf());
    
    assertEquals("infix.e1","46",e1.toInfix());
    assertEquals("infix.e2","(120/7)",e2.toInfix());
    assertEquals("infix.e3","(50-15)",e3.toInfix());

    assertEquals("Postfix.e1","46",e1.toPostfix());
    assertEquals("Postfix.e2","120 7 /",e2.toPostfix());
    assertEquals("Postfix.e3","50 15 -",e3.toPostfix());

    assertEquals("Prefix.e1","46",e1.toPrefix());
    assertEquals("Prefix.e2","/ 120 7",e2.toPrefix());
    assertEquals("Prefix.e3","- 50 15",e3.toPrefix());
  }
  public void testEMBE() {
    ExpressionManager expressionManager = new ExpressionManager();
    ArrayList<Token> postfix = new ArrayList<Token>();
    postfix.add(new Number(37));
    Expression e1 = expressionManager.buildExpression(postfix);
    assertEquals("build test 1",37,e1.valueOf());
    postfix.clear();
    postfix.add(new Number(20));
    postfix.add(new Number(13));
    postfix.add(new Operator("*"));
    Expression e2 = expressionManager.buildExpression(postfix);
    assertEquals("build test 2",260,e2.valueOf());
    assertEquals("build test 3","(20*13)",e2.toString());
    assertEquals("build test 4","* 20 13",e2.toPrefix());

    ExpressionManager expressionManager0 = new ExpressionManager();
    ArrayList<Token> postfix0 = new ArrayList<Token>();
    postfix0.add(new Number(73));
    Expression e3 = expressionManager0.buildExpression(postfix0);
    assertEquals("build test 5",73,e3.valueOf());
    postfix0.clear();
    postfix0.add(new Number(99));
    postfix0.add(new Number(77));
    postfix0.add(new Operator("*"));
    Expression e4 = expressionManager0.buildExpression(postfix0);
    assertEquals("build test 6",260,e2.valueOf());
    assertEquals("build test 7","(99*77)",e4.toString());
    assertEquals("build test 8","* 99 77",e4.toPrefix());
  }
  public void testEMITP(){
    ExpressionManager expressionManager = new ExpressionManager();
    List<Token> infix = new ArrayList<Token>();
    infix.add(new Number(20));
    infix.add(new Operator("+"));
    infix.add(new Number(20));
    infix.add(new Operator("+"));
    infix.add(new Number(13));
    infix.add(new Operator("+"));
    infix.add(new Number(13));
    List<Token> postfix = expressionManager.infixToPostfix(infix);
    Expression e1 = expressionManager.buildExpression(postfix);
    assertEquals("infix to postfix test 1",66,e1.valueOf());
    
    List<Token> infix2 = new ArrayList<Token>();
    infix2.add(new Number(2));
    infix2.add(new Operator("*"));
    infix2.add(new Number(2));
    infix2.add(new Operator("*"));
    infix2.add(new Operator("("));
    infix2.add(new Number(20));
    infix2.add(new Operator("-"));
    infix2.add(new Number(13));
    infix2.add(new Operator("+"));
    infix2.add(new Number(1));
    infix2.add(new Operator(")"));
    List<Token> postfix2 = expressionManager.infixToPostfix(infix2);
    Expression e2 = expressionManager.buildExpression(postfix2);
    assertEquals("test 3",32,e2.valueOf());
    
    List<Token> infix3 = new ArrayList<Token>();
    infix3.add(new Number(2));
    infix3.add(new Operator("*"));
    infix3.add(new Number(2));
    infix3.add(new Operator("+"));
    infix3.add(new Number(1));
    List<Token> postfix3 = expressionManager.infixToPostfix(infix3);
    Expression e3 = expressionManager.buildExpression(postfix3);
    assertEquals("test 3",5,e3.valueOf());
  }
}
