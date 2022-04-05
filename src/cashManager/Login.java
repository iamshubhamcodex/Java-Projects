package cashManager;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Login extends Account {

	private static Scanner s = new Scanner(System.in);
	private static Map<Integer, Integer> ckm = new HashMap<>();
	private static int accNum, accPin;
	
	private Login(String s) {super(s);}

	public static void main(String[] args) {
		welcome();
	}

	private static void welcome() {
		System.out.println("Welcome to ATM \n1.  Have Account\n2.  Register");
		int inp = sc.nextInt();
		if (inp == 1) {
			login();
		} else if (inp == 2) {
			register();
		} else {
			System.out.println("Please Enter valid Input");
			welcome();
		}
		
	}
	
	private static void login() {
		
		System.out.println("\nEnter Name");
//		s.next();
		String name = s.nextLine();
		if(updt(name)) {
			// break from here for accNum input
			System.out.println("Enter ATM Number");
			accNum = s.nextInt();
			if (check(accNum)) {
				// break from here for accPIN input
				while(true){
					System.out.println("Enter Security Pin");
					accPin = s.nextInt();
					if (check(accNum, accPin)) {
						new Account(name);
						Account.viewBnk();
					} else {
						System.out.println("Enter Correct PIN");
						System.out.println("1.\tRe-enter PIN");
						System.out.println("2.\tBack");
						int res = s.nextInt();
						if(res != 1) {
							break;
						}
					}
				}
				
			} else{
				System.out.println("Enter Correct ATM Number or Register YourSelf");
				s.nextLine();
				login();
			}
		}
	}

	private static void register() {
		System.out.println("Enter your Name");
		String name = s.nextLine();
		System.out.println("Enter your ATM Number");
		int num = s.nextInt();
		System.out.println("Enter your ATM PIN");
		int pin = s.nextInt();
		makefile(name);
		writefile(name, num + "_" + pin + "_Saving:0_Current:0");
	}

	private static boolean check(int ac) {return ((ckm.get(ac) == null) ? false : true);}

	private static boolean check(int ac, int pin) {return (pin == ckm.get(ac));}

	private static boolean updt(String s) {
		String dt = readfile(s);
		if(dt != "no") {
			ckm.put(Integer.valueOf(dt.split("_")[0]), Integer.valueOf(dt.split("_")[1]));
			return true;
		}else {
			return false;
		}
		
	}
}
