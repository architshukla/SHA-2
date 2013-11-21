package rawrv.sha2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Test {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println("=================== SHA-2 ===================\n\n");
		
		System.out
				.println("1.Enter a message to Hash \n2.Use predefined messages ?");
		int choice = scan.nextInt();
		switch (choice) {
		case 2:
			useTestCases();
			break;
		default:
			standardInput();
		}
	}

	private static void standardInput() throws NoSuchAlgorithmException {
		String result;
		System.out.println("Show workflow? y/n");
		String option = scan.next();
		System.out.print("Enter message: ");
		String message = scan.next();
		switch (option) {
		case "y":
			result = SHA2.hash(message, true);
			break;

		default:
			result = SHA2.hash(message, false);
			break;
		}
		printResult(result, message);

	}

	private static void printResult(String result, String message)
			throws NoSuchAlgorithmException {
		System.out.println("Input		: " + message);

		System.out.println("Expected	: " + useStandardHash(message));

		System.out.println("Actual		: " + result);
	}

	private static void useTestCases() throws NoSuchAlgorithmException {

		String message1 = "123";
		String message2 = "abc";
		String message3 = "abcdefghi";
		String message4 = "abcdefghijklmnopqrstuvwxyz";
		String message5 = "hash this string";
		String message6 = "Hash this string";
		String message7 = "THIS IS A SAMPLE MESSAGE TO HASH A VERY LARGE INPUT TEXT, abc def ghi jkl mno pqr stuv";
		String message8 = "a";
		String message9 = "!@#$%^*(()()";
		String message10 = "ghijksdksbchjasbhjbdhbashbhc hashhdbhabsdasdbasbda asda sdjhabsd dahsbe14324 23 2be f&*&*T&TT^R^R sfsahbdas jknsadasbdanasndkjasndjkasjkdjasjdbabsdbsajhbdbasdbsabdbsahbdjghijksdksbchjasbhjbdhbashbhc hashhdbhabsdasdbasbda asda sdjhabsd dahsbe14324 23 2be f&*&*T&TT^R^R sfsahbdas jknsadasbdanasndkjasndjkasjkdjasjdbabsdbsajhbdbasdbsabdbsahbdjhsabjhdbsahjbdhbashdbahsjbdhjbasjhdbhjasbdhjbashjdbhjasbdhjbacbuyfbcdsyubcyusbeyfubyuyudcbjsdhbfjhbsdhjfjsadyugadbhajbdhjbhjbchjbhjbhjcbshjbdhcbdhjsbfhjbasjhdgashdasdjabxasbjhbcsahjbhjbhjcbdhjshjbdshjb";

		printResult(SHA2.hash(message1, false), message1);
		printResult(SHA2.hash(message2, false), message2);
		printResult(SHA2.hash(message3, false), message3);
		printResult(SHA2.hash(message4, false), message4);
		printResult(SHA2.hash(message5, false), message5);
		printResult(SHA2.hash(message6, false), message6);
		printResult(SHA2.hash(message7, false), message7);
		printResult(SHA2.hash(message8, false), message8);
		printResult(SHA2.hash(message9, false), message9);
		printResult(SHA2.hash(message10, false), message10);

	}

	private static String useStandardHash(String password)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		byte[] byteData = hashMessage(password, md);

		return getExpectedOutput(byteData);
	}

	private static byte[] hashMessage(String password, MessageDigest md) {
		md.update(password.getBytes());

		byte byteData[] = md.digest();
		return byteData;
	}

	private static String getExpectedOutput(byte[] byteData) {
		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			if ((i + 1) % 4 == 0)
				hexString.append(hex + " ");
			else
				hexString.append(hex);
		}
		return hexString.toString();
	}
}