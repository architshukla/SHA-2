package rawrv.sha2;

import java.util.ArrayList;
import java.util.List;

public final class SHA2 {

	private static List<List<Boolean>> W;
	static SecureHashFunctions SHA = new SecureHashFunctions();

	private SHA2() {
		// Private constructor to avoid instantiation of the class
	}

	public static String hash(String input, boolean isTesting) {
		SHA.testing = isTesting;
		return hash(input);
	}

	public static String hash(String input) {
		List<Boolean> h0 = SHA.convertToList(SHA.H[0]), h1 = SHA
				.convertToList(SHA.H[1]), h2 = SHA.convertToList(SHA.H[2]), h3 = SHA
				.convertToList(SHA.H[3]), h4 = SHA.convertToList(SHA.H[4]), h5 = SHA
				.convertToList(SHA.H[5]), h6 = SHA.convertToList(SHA.H[6]), h7 = SHA
				.convertToList(SHA.H[7]);

		// 1. Convert String into an ArrayList<Boolean>
		List<Boolean> inputByteList = SHA.convertToList(input);

		// 2. Use the padding() function to pad the bit string
		SHA.padMessage(inputByteList);
		if (SHA.testing) {
			System.out.println("padding message..\n");

			System.out.println("Padded Message is : "
					+ SHA.convertToString(inputByteList) + "\n");
		}

		for (int j = 0; j < inputByteList.size(); j += 512) {

			W = new ArrayList<List<Boolean>>();
			// 3. Divide each 512 bit string in 16 + 48 blocks

			if (SHA.testing)
				System.out
						.println("Message divided into 16 32 bits Words : \n");
			for (int i = j + 0; i < j + 512;) {
				List<Boolean> word = new ArrayList<Boolean>(
						inputByteList.subList(i, i + 32));
				if (SHA.testing)
					System.out.print(SHA.convertToString(word) + " ");
				W.add(word);
				i = i + 32;
			}
			if (SHA.testing)
				System.out
						.println("\nProducing the remaning 48 Blocks from the 16 Blocks... \n");
			// wi = sigma1(wi-2)+wi-7+sigma0(wi-15)+wi-16 17<=i<= 64
			for (int k = 16; k < 64; k++) {
				List<Boolean> listA = SHA.modularAddList(
						SHA.sigma1(new ArrayList<Boolean>(W.get(k - 2))),
						W.get(k - 7));
				List<Boolean> listB = SHA.modularAddList(
						SHA.sigma0(new ArrayList<Boolean>(W.get(k - 15))),
						W.get(k - 16));
				W.add(SHA.modularAddList(listA, listB));
				// break; // remember to remove this
			}
			List<Boolean> t1, t2;
			// 4. Use the other utility functions
			List<Boolean> a = new ArrayList<Boolean>(h0), b = new ArrayList<Boolean>(
					h1), c = new ArrayList<Boolean>(h2), d = new ArrayList<Boolean>(
					h3), e = new ArrayList<Boolean>(h4), f = new ArrayList<Boolean>(
					h5), g = new ArrayList<Boolean>(h6), h = new ArrayList<Boolean>(
					h7);

			if (SHA.testing) {
				System.out.println("Processing the 64 blocks of message : ");
			}
			for (int i = 0; i < 64; i++) {
				t1 = SHA.modularAddList(SHA.modularAddList(SHA.modularAddList(
						SHA.modularAddList(h,
								SHA.SIGMA1(new ArrayList<Boolean>(e))), SHA.Ch(
								new ArrayList<Boolean>(e),
								new ArrayList<Boolean>(f),
								new ArrayList<Boolean>(g))), SHA
						.convertToList(SHA.K[i])), W.get(i));
				t2 = SHA.modularAddList(SHA.SIGMA0(new ArrayList<Boolean>(a)),
						SHA.Maj(new ArrayList<Boolean>(a),
								new ArrayList<Boolean>(b),
								new ArrayList<Boolean>(c)));
				h = g;
				g = f;
				f = e;
				e = SHA.modularAddList(d, t1);
				d = c;
				c = b;
				b = a;
				a = SHA.modularAddList(t1, t2);

				if (SHA.testing)
					System.out.println("Round " + i + ":	"
							+ SHA.convertToString(a) + " "
							+ SHA.convertToString(b) + " "
							+ SHA.convertToString(c) + " "
							+ SHA.convertToString(d) + " "
							+ SHA.convertToString(e) + " "
							+ SHA.convertToString(f) + " "
							+ SHA.convertToString(g) + " "
							+ SHA.convertToString(h));

			}
			System.out.println("\nAdding the new values to its previous values");
			h0 = SHA.modularAddList(h0, a);
			h1 = SHA.modularAddList(h1, b);
			h2 = SHA.modularAddList(h2, c);
			h3 = SHA.modularAddList(h3, d);
			h4 = SHA.modularAddList(h4, e);
			h5 = SHA.modularAddList(h5, f);
			h6 = SHA.modularAddList(h6, g);
			h7 = SHA.modularAddList(h7, h);
		}
		System.out.println();
		return SHA.convertToString(h0) + " " + SHA.convertToString(h1) + " "
				+ SHA.convertToString(h2) + " " + SHA.convertToString(h3) + " "
				+ SHA.convertToString(h4) + " " + SHA.convertToString(h5) + " "
				+ SHA.convertToString(h6) + " " + SHA.convertToString(h7);

	}
}