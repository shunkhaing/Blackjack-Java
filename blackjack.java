/************Algorithm************
1. Generate random initial cards for the player and dealer.
2. Calculate initial totals for both.
3. Display initial cards.
4. If player total is 21, display "BLACKJACK!! You Win! Game Over." and end.
5. Prompt player to hit or stand.
      a. If hit, draw a card and update total until stand or bust (over 21).
6. Reveal dealer's second card and simulate dealer's turn (hit until total is at least 17).
7. Determine the winner:
      a. If player has 21 or higher total than dealer (but less than 21), player wins.
      b. If player busts, display "Player busted - you lose :(".
      c. If dealer has a higher total than player (but less than 21), dealer wins.
      d. If dealer busts, display "Dealer Busted - All Player win!".
      e. If totals are equal, display "No winner - it's a push."
**********************************/

/************Header************
Author: Shun Lae Thawtar Khaing 
Date of Last Modification: 02/26/2024 
Course: CS111B 
Instructor: C. Conner 
Assignment #3
File Name: WiFiTest.java
---> blackjack (NO ACES. NO FACE CARDS. JUST NUMBERS.)
**********************************/

/************Documentation************
added (playerTotal != dealerTotal) not to execute "player Wins" when both are 21
removed (playerTotal == 21) && (playerTotal != dealerTotal) in player Wins
**********************************/

import java.util.Scanner;
import java.util.Random;
public class blackjack
{
	public static void main(String[] args) 
   {
	Scanner scnr = new Scanner(System.in);
       Random randGen = new Random();                       //Generate random initial cards for the player and dealer.
       int playerCard1 = randGen.nextInt(10) + 2;
       int playerCard2 = randGen.nextInt(10) + 2;
       int dealerCard1 = randGen.nextInt(10) + 2;
       int dealerCard2 = randGen.nextInt(10) + 2;
       
       int playerTotal = playerCard1 + playerCard2;         //Calculate initial totals for both.
       int dealerTotal = dealerCard1 + dealerCard2;
       
       System.out.println("Dealer shows card: " + dealerCard1);                  //Display initial cards.
       System.out.println();
       System.out.println("Player cards: " + playerCard1 + ", " + playerCard2);
       System.out.println();
       System.out.println("Player Total: " + playerTotal);
    
       // If player total is 21, display "BLACKJACK!! You Win! Game Over." and end.
       if(playerTotal == 21)
       {
           System.out.println("BLACKJACK!! You Win! Game Over.");
   	 }
   	else
       {
   	    System.out.print("Hit (h) or Stand (s)? ");          //Prompt player to hit or stand.
   	    char userInput;
   	    userInput = scnr.next().charAt(0);
   	    
   	    if(userInput == 'h')
          {
   	        while(userInput == 'h' && playerTotal <= 21)     //a. If hit, draw a card and update total until stand or bust (over 21).
              {
   	             int playerCardNew = randGen.nextInt(10) + 2;
   	             System.out.println("Player Card: " + playerCardNew);
   	             playerTotal += playerCardNew;
   	             System.out.println("Player Total: " + playerTotal);
   
   	             System.out.print("Hit (h) or Stay (s)? ");
   	        
   	             userInput = scnr.next().charAt(0);
   	        }
   	    }
          
      	    
          if(userInput == 's')
          {
      	      System.out.println("Player Total Hand: " + playerTotal);
      	 } 
          else System.out.println("Player Total Hand: " + playerTotal);
      	    
          
      	 System.out.println();
             
                 //dealer
                 
          System.out.println("Dealer Second Card: " + dealerCard2);        //6. Reveal dealer's second card and simulate dealer's turn (hit until total is at least 17).
          System.out.println("Dealer Total : " + dealerTotal);
             
          while(dealerTotal < 17)
          {
               int dealerCardNew = randGen.nextInt(10) + 2;
               System.out.println("Dealer Card: " + dealerCardNew);
               dealerTotal += dealerCardNew;
               System.out.println("Dealer Total: " + dealerTotal);
                 
          }
          
             System.out.println("Dealer Total Hand: " + dealerTotal);
             System.out.println();
             
             if((playerTotal > dealerTotal) && (playerTotal <= 21)){
                 System.out.println("Congratulations - Player Wins!");
             }
             else if(playerTotal > 21){
                 System.out.println("Player busted - you lose :(");
             }
             else if((playerTotal < 21) && (dealerTotal > playerTotal) && (dealerTotal <= 21)){
                 System.out.println("Sorry - Dealer Wins :(");
             }
             else if(dealerTotal > 21){
                 System.out.println("Dealer Busted - All Players win !");
             }
             else if(playerTotal == dealerTotal){
               System.out.println("No winner - it's a push.");
      	    }
   	    
   
       }

	    
	    
    }
}

