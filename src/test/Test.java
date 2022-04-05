package test;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int noE = sc.nextInt();
			int b1 = sc.nextInt();
			int b2 = sc.nextInt();
			int p = 0;

			for (int i = 1; i <= noE; i++) {
				if (i != noE) {
					if (i != b1 && i != b2 && i + 1 != b1 && i + 1 != b2)
						p++;
				} else {
					if(i != b1 && i != b2 &&  1 != b1 && 1 != b2)
						p++;
				}
			}
			int ret = (noE == 5 ? 1 : (p * (noE - 4)) - (noE - 6)); 
			System.out.println(ret);
		}

		sc.close();
	}

}
