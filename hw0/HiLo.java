/*
 Guess number
 Author: Zezhi Wang
*/
import java.util.Scanner;
import java.util.Random;

public class HiLo
{
 public static void main(String[] args)
 {
  Random rnd = new Random();
  int target = rnd.nextInt(1000) + 1;


  System.out.println("Let's play a game!\nI'm thinking of a number between 1 and 1000,\nTry to guess what it is in less than 20 tries.");
  
  int guess = -1;
  int counter = 0;
  
  Scanner input = new Scanner(System.in);
  
  while(counter < 20 && guess != target)
  {
   String line = input.nextLine();
   Scanner s2 = new Scanner(line);
   if (s2.hasNextInt())
   {
    counter += 1;
    guess = s2.nextInt();
    if(guess > target)
    {
     System.out.println("Too high!");
    }
    else
    {
     System.out.println("Too low!");
    }
   }
   else
   {
    System.out.println("That's not a number, try again.");
    continue;
   }
  }

  if(counter > 19)
  {
   System.out.println("Out of tries, You lose");
  }
  else
  {
   System.out.printf("You guessed my number!  It took you %d tries." ,counter);
  }
 }
}
