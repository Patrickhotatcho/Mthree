package com.JavaBasic.RockPaperScissors;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		boolean play = true;
		while (play) {
			System.out.println("How many round do you want to play?(1 - 10)");
			int userWin = 0;
			int computerWin = 0;
			try {
				int round = input.nextInt();
				for (int i = 0; i < round; i++) {
					System.out.println("Please select the number (1. Rock 2. Paper 3. Scissors)");

					int player1 = input.nextInt();
					if (!(player1 == 1 || player1 == 2 || player1 == 3)) {
						System.out.println("Invalid input, please input again!");
						i--;
						continue;

					}
					int player2 = rand.nextInt(3) + 1;
					int judge = player1 - player2;

					switch (judge) {
					case 0:
						System.out.println("tie");
						break;
					case 1:
					case -2:
						System.out.println("user win");
						userWin++;
						break;
					case -1:
					case 2:
						System.out.println("computer win");
						computerWin++;
						break;
					default:
					}//end of switch
				}//end of forloop
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("User won:"+userWin);
			System.out.println("Computer won:"+computerWin);
			if(userWin==computerWin)
				System.out.println("Tie");
			else if(userWin>computerWin)
				System.out.println("User won the game");
			else
				System.out.println("Computer won the game");
			boolean enable = true;
			while(enable) {
				System.out.println("Do you want to play again?(Yes/No)");
				String check = input.next();

				if(check.equals("Yes")) {
					play = true;
					break;
				}
				else if(check.equals("No")) {
					System.out.println("Thanks for playing!");
					break;
				}
			}
			

		}//end of while loop
	}//end of main
}//end of class RockPaperScissors
