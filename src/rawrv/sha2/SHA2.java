package rawrv.sha2;

import java.util.ArrayList;

public final class SHA2 {

	private static ArrayList<ArrayList<Boolean>> W = new ArrayList<ArrayList<Boolean>>();

	private SHA2() {
		// Private constructor to avoid instantiation of the class
	}

	
	// public
	public static String hash(String input) {
		SecureHashFuncrions sha = new SecureHashFuncrions();
		ArrayList<Boolean> inputByteList = sha.convertToList(input);
		// TODO Implement main hash function
		// 1. Convert String into an ArrayList<Boolean>
		// 2. Use the padding() function to pad the bit string
		// 3. Divide each 512 bit string in 16 + 48 blocks
		// 4. Use the other utility functions
		return null;
	}
}