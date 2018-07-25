import java.util.*;
   
class ExpressionManager {
   
    public List<Token> infixToPostfix(List<Token> list){
      if(list.size() == 0)
        throw new ArithmeticException("Empty");
      ArrayList<Token> result = new ArrayList<Token>();
      Stack<Operator> stack = new Stack<Operator>();
      if(list.get(0).isOperator() && list.size() == 1)
        throw new ArithmeticException("Missing Number");
      for(Token temp : list){
        if(temp.isNumber())
          result.add(temp);
        else if(temp.isOperator()){
          Operator oper = (Operator)temp;
          if(stack.isEmpty())
            stack.push(oper);
          else{
            while(!stack.isEmpty()){
              Operator inlist = stack.peek();
              if(oper.getPriority() == 6){
                while(stack.peek().getPriority() != 5){
                  result.add(stack.pop());
                }
                stack.pop();
                break;
              }
              else if(inlist.getPriority() == 5){
                stack.push(oper);
                break;
              }
              else if(inlist.getPriority() == 4 && oper.getPriority() == 4){
                stack.push(oper);
                break;
              }
              else if(inlist.getPriority() < oper.getPriority()){
                stack.push(oper);
                break;
              }
              else if(inlist.getPriority() >= oper.getPriority()){
                result.add(stack.pop());
              }
            }
          }
        }
      }
      while(!stack.isEmpty())
        result.add(stack.pop());
      return result;
    }
    
    public Expression buildExpression(List<Token> postfixList){
      Stack<Expression> stack = new Stack<Expression>();
      for(Token temp : postfixList){
        if(temp.isNumber())
          stack.push((Number)temp);
        else if(temp.isOperator()){
          Expression y = stack.pop();
          if (stack.isEmpty())
              throw new ArithmeticException("Missing Number");
          Expression x = stack.pop();
          stack.push(new BinaryExpression((Operator)temp,x,y));
        }
      }
      return stack.pop(); 
    }   
}
