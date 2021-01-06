package game.ayan.Tic_Tac_Toe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Play_Game {

	private String player_one_name;
	private String player_two_name;

	private String player_one_symbol;
	private String player_two_symbol;

	private Integer no_of_players;

	private String[] moves = new String[9];

	public Play_Game(String player_one_name, String player_two_name, String player_one_symbol, String player_two_symbol,
			Integer no_of_players) {
		this.player_one_name = player_one_name;
		this.player_two_name = player_two_name;
		this.player_one_symbol = player_one_symbol;
		this.player_two_symbol = player_two_symbol;
		this.no_of_players = no_of_players;
	}

	public void play_start() {
		Scanner sc = new Scanner(System.in);
		UI ui = new UI();

		for (int i = 0; i < 9; i++) {
			moves[i] = " ";
		}
		play_next(0, sc, ui);
	}

	public void play_next(int step, Scanner sc, UI ui) {
		if (step >= 9) {
			System.out.println("game end, no one wins !!!..............");
			// display score board
			return;
		}

		if (step % 2 == 0) {
			// player_one_step
			ui.playgame(step + 1, player_one_name, player_one_symbol, moves);
			int pos = sc.nextInt();
			if (!add_symbol(player_one_symbol, pos - 1)) {
				return;
			}
			if (!check_winner(player_one_name, player_one_symbol)) {
				return;
			}
			play_next(step + 1, sc, ui);

		} else {
			// player_two_step // choose bot vs p-2
			ui.playgame(step + 1, player_two_name, player_two_symbol, moves);

			if (player_two_name == "BOT") {
				bot_move();
			} else {

				int pos = sc.nextInt();
				if (!add_symbol(player_two_symbol, pos - 1)) {
					return;
				}
			}
			if (!check_winner(player_two_name, player_two_symbol)) {
				return;
			}
			play_next(step + 1, sc, ui);
		}

	}

	private void bot_move() {
		ArrayList<Integer> m = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (moves[i] != " ") {
				m.add(i + 1);
			}
		}
		int pos = random_bot_move(m.size());

		if (!add_symbol(player_two_symbol, m.get(pos))) {
			return;
		}
	}

	private int random_bot_move(int size) {
		int no = (Math.abs(new Random().nextInt())) % size;
		return no;
	}

	private boolean check_winner(String player_name, String player_symbol) {

		// 0 1 2
		// 3 4 5
		// 6 7 8

		int[][] m = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
				{ 2, 4, 6 } };

		UI ui = new UI();
		for (int i = 0; i < m.length; i++) {
			if (moves[m[i][0]].equals("X") && moves[m[i][1]].equals("X") && moves[m[i][2]].equals("X")) {
				ui.endgame(player_name);
				return false;
			}
		}

		for (int i = 0; i < m.length; i++) {
			if (moves[m[i][0]].equals("O") && moves[m[i][1]].equals("O") && moves[m[i][2]].equals("O")) {
				ui.endgame(player_name);
				return false;
			}
		}

		return true;
	}

	private boolean add_symbol(String player_symbol, int pos) {
		if (pos > 9) {
			System.out.println("You Entered wrong position...");
			return false;
		}

		if (moves[pos] == "X" || moves[pos] == "O") {
			System.out.println("You Entered wrong input, please try again");
			return false;
		}

		if (moves[pos] == " ") {
			moves[pos] = player_symbol;
			return true;
		}

		return false;
	}
}
