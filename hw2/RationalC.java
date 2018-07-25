public class RationalC 
  implements Rational{
  
  private int numerator,denominator;

  public RationalC(int num, int denom){
    if(num == 0){
      numerator = 0;
      denominator = 1;
    }
    else{
      numerator = Math.abs(num);
      denominator = Math.abs(denom);
      
      int temp = 1;
      for(int i = numerator; i >= numerator/2; i--){
        if (numerator % i == 0 && denominator % i == 0){
          temp = i;
          break;
        }
      }
      numerator /= temp;
      denominator /= temp;
      if((num*denom) < 0)
        numerator = - numerator;
    }       
  }

  public RationalC(int num){
    numerator = num;
    denominator = 1;
  }

  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }

  public Rational add(Rational other){
    int x = numerator * other.getDenominator() + denominator * other.getNumerator();
    int y = denominator * other.getDenominator();
    return new RationalC(x,y);
  }

  public Rational multiply(Rational other){
    int x = numerator * other.getNumerator();
    int y = denominator * other.getDenominator();
    return new RationalC(x,y);
  }

  public int compareTo(Rational other){
    int result = 0;
    int temp = numerator*other.getDenominator() - denominator*other.getNumerator();
    if(temp > 0)
      result = 1;
    else if(temp == 0)
      result = 0;
    else
      result = -1;
    return result;
  }

  public boolean equals(Object other){
    if(this==other)
      return true;
    if(other==null)
      return false;
    if(getClass()!=other.getClass())
      return false;
    Rational Other = (RationalC)other;
    return Other.getNumerator()*this.getDenominator() == Other.getDenominator()*this.getNumerator();
  }

  public String toString(){
    String result = numerator+"/"+denominator;
    return result;
  }
}
