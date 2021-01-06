package game.ayan.Tic_Tac_Toe;

public class Test {

	public static void main(String[] args) {
		UI ui = new UI();
		// ui.LandingUI();
		// ui.LandingUI2();
		// ui.LandingUI3();
		// ui.playgame();
		// ui.endgame();

		// 0 1 2
		// 3 4 5
		// 6 7 8
		int[][] m = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
				{ 2, 4, 6 } };
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i][0] + "   " + m[i][1] + "   " + m[i][2]);
		}

	}

}
