public class BinaryExpression implements Expression{
  private Expression left;
  private Expression right;
  private Operator operator;
  
  public BinaryExpression(Operator oper,Expression x,Expression y){
    this.left = x;
    this.right = y;
    this.operator = oper;
  }
  
  public int valueOf(){
    int Left = this.left.valueOf();
    int Right = this.right.valueOf();
    return this.operator.apply(Left,Right);
  }
  
  public String toPrefix(){
    return (""+this.operator+" "+this.left.toPrefix()+" "+this.right.toPrefix());
  }
  
  public String toPostfix(){
    return ("" + this.left.toPostfix() +" "+ this.right.toPostfix() +" "+ this.operator);
  }
  
  public String toInfix(){
    return ("(" + this.left + this.operator + this.right + ")");
  }
  
  public String toString(){
    return this.toInfix();
  }
}
