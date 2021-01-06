package game.ayan.Tic_Tac_Toe;

import java.util.Random;
import java.util.Scanner;

public class Starter {

	static String player_one_name;
	static String player_two_name;

	static String player_one_symbol;
	static String player_two_symbol;

	static Integer no_of_players;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		besicInfo(sc);

		Play_Game p = new Play_Game(player_one_name,player_two_name,player_one_symbol,player_two_symbol,no_of_players);
		p.play_start();
	}

	private static void besicInfo(Scanner sc) {
		System.out.print("Enter number of players : 1 -> 1 Player | 2 -> Players : ");
		no_of_players = sc.nextInt();
		UI ui = new UI();
		if (no_of_players == 1) {
			ui.LandingUI2(1);
			player_one_name = sc.next();
			player_two_name = "BOT";

		} else if (no_of_players == 2) {
			ui.LandingUI2(1);
			player_one_name = sc.next();

			ui.LandingUI2(2);
			player_two_name = sc.next();

		} else {
			System.out.println("!!! You Entered Wrong input, Please try again... ");
			besicInfo(sc);
		}

		// randomly choose players symbols

		int k = new Random().nextInt(1000);

		switch (k % 2) {
		case 0:
			player_one_symbol = "X";
			player_two_symbol = "O";
			break;
		case 1:
			player_one_symbol = "O";
			player_two_symbol = "X";
			break;
		}
		displayUserInfo();

	}

	private static void displayUserInfo() {
		
		UI ui = new UI();
		ui.LandingUI3(no_of_players,player_one_name,player_two_name,player_one_symbol,player_two_symbol );
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
	}

}
