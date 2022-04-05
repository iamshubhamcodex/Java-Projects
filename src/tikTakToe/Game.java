package tikTakToe;

import java.util.Scanner;

public class Game {

	static int nr = 1;
	static int np = 2;
	static char[] num = { '.', '.', '.', '.', '.', '.', '.', '.', '.' };
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		board();
		game();
	}

	public static void game() {
		boolean dr = true;
		for(int i = 0; i < 9; i++) {
			int plyr = i%2 + 1;
			if (plr(plyr, (plyr == 1) ? 'X': 'O')) {
				dr = false;
				System.out.println("Player " + plyr + " won. Three in a Row");
				break;
			}
		}
		if(dr)
			System.out.println("Match Draw. No Three in a Row");
//		\nWanna PLAY AGAIN???(y/n)");
//		sc.nextLine();
//		char pg = sc.nextLine().charAt(0);
//		if(pg == 'y') game();
	}

	private static boolean plr(int no, char c) {
		if (checkWin(c))
			return true;
		System.out.println("Player " + no + " chance. Enter:-\t");
		int ed1 = sc.nextInt();
		if (num[ed1 - 1] == '.')
			num[ed1 - 1] = c;
		else {
			System.out.println("You can not enter at that place");
			plr(no, c);
		}
		board();
		if (checkWin(c))
			return true;
		return false;
	}

	private static boolean checkWin(char c) {
		
		
		if (num[0] == c) {
			if (num[0] == num[1] && num[1] == num[2])
				return true;
			else if (num[0] == num[3] && num[3] == num[6])
				return true;
			else if (num[0] == num[4] && num[4] == num[8])
				return true;
		} else if (num[4] == c) {
			if (num[1] == num[4] && num[4] == num[7])
				return true;
			else if (num[3] == num[4] && num[4] == num[5])
				return true;
			else if (num[6] == num[4] && num[4] == num[2])
				return true;
		} else if (num[8] == c) {
			if (num[2] == num[5] && num[5] == num[8])
				return true;
			else if (num[6] == num[7] && num[7] == num[8])
				return true;
		}
		return false;
	}

	public static void board() {
		for (int i = 1; i < 9; i++) {
			switch (i % 3) {
			case 1:
				System.out.println("     |     |     ");
				break;
			case 2:
				rows();
				break;
			case 0:
				System.out.println("_____|_____|______");
				break;
			}
		}
		System.out.println("     |     |     ");
		nr = 1;
	}

	public static void rows() {
		if (num[nr - 1] == '.')
			System.out.print("  " + nr);
		else
			System.out.print("  " + num[nr - 1]);
		nr++;
		if (num[nr - 1] == '.')
			System.out.print("  |  " + nr);
		else
			System.out.print("  |  " + num[nr - 1]);
		nr++;
		if (num[nr - 1] == '.')
			System.out.print("  |  " + nr);
		else
			System.out.print("  |  " + num[nr - 1]);
		nr++;
		System.out.println();
	}
}
