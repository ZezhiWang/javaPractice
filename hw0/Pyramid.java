/*
 Drawing a Pyramid
 Author: Zezhi Wang
*/
import java.util.Scanner;

public class Pyramid
{
 public static void main(String[] args)
 { 
  Scanner input = new Scanner(System.in);
  System.out.print("Enter the height of the Pyramid: ");
  int height = input.nextInt();
  for(int i = 0; i < height; i++)
  {
    for (int j = 0; j < height - i; j++)
    {
      System.out.print(" "); 
    }
    for (int k = 0; k <= 2*i; k++)
    {
      System.out.print("*");
    }
    System.out.println("");
  }
 }
}
