package cashManager;

import java.util.Scanner;
import java.io.*;

public class Account {

	static Scanner sc = new Scanner(System.in);
	static int ac, pin, Saving, Current;
	static String name;

	public Account(String name) {
		Account.name = name;
		String data = readfile(name);
		Account.ac = Integer.valueOf(data.split("_")[0]);
		Account.pin = Integer.valueOf(data.split("_")[1]);
		Account.Saving = Integer.valueOf(data.split("_")[2].split(":")[1]);
		Account.Current = Integer.valueOf(data.split("_")[3].split(":")[1]);
	}

	public static void viewBnk() {greet();}

	public static void greet() {
		System.out.println("1 - View Balance");
		System.out.println("2 - Add Balance");
		System.out.println("3 - Withdraw Balance");
		System.out.println("22 - Back");
		switch (sc.nextInt()) {
		case 1:
			viewBlnce();
			break;
		case 2:
			addBlnce();
			break;
		case 3:
			withBlnce();
			break;
		case 22:
			System.out.println("Thankyou for Visiting");
			break;
		default:
			System.out.println("Please Enter valid Numbers\n");
			greet();
		}
	}

	public static void addBlnce() {
		System.out.println("\nAdd to: \n1 - Current Account");
		System.out.println("2 - Saving Account");
		System.out.println("22 - Back");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("Enter Amount to ADD");
			int addCur = sc.nextInt();
			Current += addCur;
			System.out.println("Rs." + addCur + " added. Remaining Balance is Rs." + Current + "\n");
			greet();
			break;
		case 2:
			System.out.println("Enter Amount to ADD");
			int addSav = sc.nextInt();
			Saving += addSav;
			System.out.println("Rs." + addSav + " added. Remaining Balance is Rs." + Saving + "\n");
			greet();
			break;
		case 22:
			System.out.println();
			greet();
			break;
		default:
			System.out.println("Please Enter valid Numbers");
			addBlnce();
			break;
		}
		writefile(name);
	}

	public static void withBlnce() {
		System.out.println("\nWithdraw from: \n1 - Current Account");
		System.out.println("2 - Saving Account");
		System.out.println("22 - Back");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("Enter a Amount to Withdraw from Current Account");
			int withc = sc.nextInt();
			if (!(withc > Current)) {
				Current -= withc;
				System.out.println("Rs." + withc + " withdrawn. Balance is Rs." + Current + "\n");
				greet();
			} else
				System.out.println("You can not withdraw more than Current Balance\n Current Balance is:-\t" + Current);
			withBlnce();
			break;
		case 2:
			System.out.println("Enter a Amount to Withdraw from Current Account");
			int withs = sc.nextInt();
			if (!(withs > Saving)) {
				Saving -= withs;
				System.out.println("Rs." + withs + " withdrawn. Balance is Rs." + Saving + "\n");
				greet();
			} else
				System.out.println("You can not withdraw more than Current Balance\n Current Balance is:-\t" + Saving);
			withBlnce();
			break;
		case 22:
			System.out.println();
			greet();
			break;
		default:
			System.out.println("Please Enter valid Numbers");
			withBlnce();
			break;
		}
		writefile(name);
	}

	public static void viewBlnce() {
		System.out.println("\nFor your Account Number:\t" + ac);
		System.out.println("Current Balance is:\tRs." + Current);
		System.out.println("Saving Balance is:\tRs." + Saving);
		System.out.println("22 - Back");
		if (sc.nextInt() == 22) {
			System.out.println();
			greet();
		} else {
			System.out.println("Please Enter valid Numbers");
			viewBlnce();
		}
	}

	public static void makefile(String s) {
		try {
			File myObj = new File(s + ".txt");
			if (myObj.createNewFile()) {
				System.out.println("Account created: " + myObj.getName().replace(".txt", ""));
			} else {
				System.out.println("Account already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String readfile(String s) {
		String data1 = "";
		try {
			File myObj = new File(s + ".txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				data1 += data;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No Account Exist. Please Create Account.");
			data1 = "no";
//			e.printStackTrace();
			
		}
		return data1;
	}

	public static void writefile(String s) {
		try {
			FileWriter myWriter = new FileWriter(s + ".txt");
			myWriter.write(ac + "_" + pin + "_Saving:" + Saving + "_Current:" + Current);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writefile(String s, String toWrite) {
		try {
			FileWriter myWriter = new FileWriter(s + ".txt");
			myWriter.write(toWrite);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
//		addBlnce();
//		withBlnce();
//		viewBlnce();
//		greet();
//		makefile("hi");
//		writefile("hi");
//		writefile("hi", "hi how are you\ni am fine");
//		readfile("shubham singh");
	}
}