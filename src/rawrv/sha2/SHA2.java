package rawrv.sha2;

import java.util.ArrayList;
import java.util.List;

public final class SHA2 {

	private static List<List<Boolean>> W = new ArrayList<List<Boolean>>();

	private SHA2() {
		// Private constructor to avoid instantiation of the class
	}

	
	// public
	public static String hash(String input) {
		SecureHashFuncrions sha = new SecureHashFuncrions();
		List<Boolean> inputByteList = sha.convertToList(input);
		// TODO Implement main hash function
		// 1. Convert String into an ArrayList<Boolean>
		// 2. Use the padding() function to pad the bit string
		// 3. Divide each 512 bit string in 16 + 48 blocks
		int j = 0;
		for (int i = 0; i < 16; i++) {
			List<Boolean> word = inputByteList.subList(i, i+8);
			W.add(word);
		}
		
		for (int k = 16; k < 64; k++) {
			
		}
		
		// 4. Use the other utility functions
		return null;
	}
}