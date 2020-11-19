import java.util.*;
public class casinoCraps
{
   public static void main(String[] args)
   {       
      Scanner kb = new Scanner(System.in);
      Random rand = new Random();
      description();
      play(rand,kb);
   }  
   public static void play(Random rand, Scanner kb)
   {
      boolean startANewGame = true;;
      while(startANewGame == true)
      {
         int numOfWins = 0;
         int numOfLosses = 0;
         int comeOutRoll = 0;
         int d1 = 1;
         int d2 = 1;
         boolean playAnotherRound = true;
         System.out.println("Lets start playing\n");
         while(playAnotherRound==true)
         {
         
            d1 = rand.nextInt(6 - 1) + 1;
            d2 = rand.nextInt(6 - 1) + 1;
            comeOutRoll = d1 + d2;
         
            System.out.println("I am rolling the dice for you. Hit enter to see that you got.");
            kb.nextLine();
            System.out.println("You rolled: " + comeOutRoll);
         
            String result = winOrLose(comeOutRoll);
         //System.out.println(result); 
            // Check for initial win or loss
            if(result.equals("win"))
            {
               numOfWins++;
               System.out.println("You Win");
            }
            else if(result.equals("loss"))
            {
               numOfLosses++;
               System.out.println("You Lost");
            }
            else if(result.equals("point"))
            {
               System.out.println("You got " + comeOutRoll + ". No loss, no win. This is your come out roll ");
               System.out.println("I have to keep rolling until you get a 7 or you match your come out roll.");
               System.out.println("If you get 7 you loose, if you get your come out roll you win.");
               System.out.println("Hit enter to see result");
               kb.nextLine();
               
               String displayPoint = keepRolling(comeOutRoll, rand);
               
               System.out.println(displayPoint);
            
               if(displayPoint.equals("You Win"))
               {
                  numOfWins++;
               }     
               if(displayPoint.equals("You Lose"))
               {
                  numOfLosses++;
               }
                        
            }
            System.out.println("Would you like to play another round");
            String user = kb.nextLine();
            if(user.equals("yes"))
            {
               playAnotherRound=true;
            }   
            else if(user.equals("no"))
            {
               playAnotherRound=false;
               System.out.print("Win Percentage: ");
               System.out.println((winProbability(numOfWins, numOfLosses))*100 + "%");
            }  
         } 
         System.out.println("\nWould you like to start a new game?");
         String user2 = kb.nextLine();

         if(user2.equals("yes"))
         {
            startANewGame = true;
         }
         else if(user2.equals("no"))
         {
            startANewGame = false;
            System.out.println("Thank you for playing!");
            System.out.println("Have a nice day");
         } 
      
      }
   }
  	
    
//*******************************************************	
   
   public static String winOrLose(int comeOutRoll)
   {
   //can only have one return statement
      String temp = " ";
      if((comeOutRoll==7) || (comeOutRoll==11))
      {
         temp = "win";
      }
      else if((comeOutRoll==2) || (comeOutRoll==3) || (comeOutRoll==12))
      {
         temp = "loss";
      }
      else
      {
         temp = "point";
      }
      return temp;
      //((comeOutRoll==4) || (comeOutRoll==5) || (comeOutRoll==6) || (comeOutRoll==8) || (comeOutRoll==9) || (comeOutRoll==10))
   }
//**********************************************************

   public static String keepRolling(int comeOutRoll, Random rand)
   {
      //need to have only one return statement
      int d1 = rand.nextInt(6 - 1) + 1;
      int d2 = rand.nextInt(6 - 1) + 1;
      int sum = d1 + d2;
      //System.out.println("Hello");
      
      while((sum != comeOutRoll) && (sum != 7))
      {
         d1 = rand.nextInt(6 - 1) + 1;
         d2 = rand.nextInt(6 - 1) + 1;
         sum = d1 + d2;
         
      } 
      String temp = " ";
      if(sum==comeOutRoll)
      {
         temp = "You Win";
      }	
      else
      {
         temp = "You Lose";
      }	
      return temp; 
   }
//********************************************************************8
   public static double winProbability(int numOfWins, int numOfLosses)
   {
      
      double prob = (double)numOfWins/(numOfWins+numOfLosses);	
      return prob;
   }
//********************************************************************
   public static void description()
   {
      System.out.println("The computer will play a game of craps for you. Here are the rules of the game: ");
      System.out.println("Two dice are rolled ");
      System.out.println("Come out roll: The first roll of the dice in a Craps game ");
      System.out.println("A come out roll of 7 or 11 automatically wins ");
      System.out.println("A come out roll of 2, 3, or 12 automatically losses ");
      System.out.println("A come out roll of 4, 5, 6, 8, 9, or 10 becomes The Point ");
      System.out.println("If the player gets the point they will keep playing by rolling ");
      System.out.println("the dice until he/she gets a 7 or the point.");
      System.out.println("If the point is rolled first, then the player wins the bet. ");
      System.out.println("If a 7 is rolled first, then the player loses. ");
   }

 
} 