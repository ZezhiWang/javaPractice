public class Number implements Token, Expression {
   
   int number;
   
   public Number(int number){
      this.number = number;
   }
      
   public boolean isNumber(){
      return true;
   }
   
   public boolean isOperator(){
      return false;
   }
   
   public int valueOf(){
     return this.number;
   }
   
   public String toPrefix(){
     String result = "";
     return (result + this.number);
   }
   
   public String toInfix(){
     String result = "";
     return (result + this.number);
   }
   
   public String toPostfix(){
     String result = "";
     return (result + this.number);
   }
   
   public String toString(){
     String result = "";
     return (result + this.number);
   }
}