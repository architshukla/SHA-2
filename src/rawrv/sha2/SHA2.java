package rawrv.sha2;

import java.util.ArrayList;
import java.util.List;

public final class SHA2 {

	private static List<List<Boolean>> W;

	private SHA2() {
		// Private constructor to avoid instantiation of the class
	}

	// public
	public static String hash(String input) {
		SecureHashFunctions sha = new SecureHashFunctions();
		List<Boolean> h0 = sha.convertToList(sha.H[0]), h1 = sha
				.convertToList(sha.H[1]), h2 = sha.convertToList(sha.H[2]), h3 = sha
				.convertToList(sha.H[3]), h4 = sha.convertToList(sha.H[4]), h5 = sha
				.convertToList(sha.H[5]), h6 = sha.convertToList(sha.H[6]), h7 = sha
				.convertToList(sha.H[7]);

		// 1. Convert String into an ArrayList<Boolean>
		List<Boolean> inputByteList = sha.convertToList(input);

		// 2. Use the padding() function to pad the bit string
		sha.padMessage(inputByteList);
		System.out.println("padding bytes.." + " " + inputByteList.size() + " "
				+ inputByteList.size() % 512);

		// 3. Divide each 512 bit string in 16 + 48 blocks
		for (int j = 0; j < inputByteList.size(); j += 512) {

			W = new ArrayList<List<Boolean>>();

			for (int i = j + 0; i < j + 512;) {
				List<Boolean> word = new ArrayList<Boolean>(
						inputByteList.subList(i, i + 32));
				System.out.print(sha.convertToString(word) + " ");
				W.add(word);
				i = i + 32;
			}
			System.out.println();
			System.out.println("Divided message.. ");

			// wi = sigma1(wi-2)+wi-7+sigma0(wi-15)+wi-16 17<=i<= 64
			for (int k = 16; k < 64; k++) {
				List<Boolean> listA = sha.modularAddList(
						sha.sigma1(new ArrayList<Boolean>(W.get(k - 2))),
						W.get(k - 7));
				List<Boolean> listB = sha.modularAddList(
						sha.sigma0(new ArrayList<Boolean>(W.get(k - 15))),
						W.get(k - 16));
				W.add(sha.modularAddList(listA, listB));
				// break; // remember to remove this
			}
			List<Boolean> t1, t2;
			// 4. Use the other utility functions
			List<Boolean> a = new ArrayList<Boolean>(h0), b = new ArrayList<Boolean>(
					h1), c = new ArrayList<Boolean>(h2), d = new ArrayList<Boolean>(
					h3), e = new ArrayList<Boolean>(h4), f = new ArrayList<Boolean>(
					h5), g = new ArrayList<Boolean>(h6), h = new ArrayList<Boolean>(
					h7);

			for (int i = 0; i < 64; i++) {
				t1 = sha.modularAddList(sha.modularAddList(sha.modularAddList(
						sha.modularAddList(h,
								sha.SIGMA1(new ArrayList<Boolean>(e))), sha.Ch(
								new ArrayList<Boolean>(e),
								new ArrayList<Boolean>(f),
								new ArrayList<Boolean>(g))), sha
						.convertToList(sha.K[i])), W.get(i));
				t2 = sha.modularAddList(sha.SIGMA0(new ArrayList<Boolean>(a)),
						sha.Maj(new ArrayList<Boolean>(a),
								new ArrayList<Boolean>(b),
								new ArrayList<Boolean>(c)));
				h = g;
				g = f;
				f = e;
				e = sha.modularAddList(d, t1);
				d = c;
				c = b;
				b = a;
				a = sha.modularAddList(t1, t2);
				System.out.println(i + " " + sha.convertToString(a) + " "
						+ sha.convertToString(b) + " " + sha.convertToString(c)
						+ " " + sha.convertToString(d) + " "
						+ sha.convertToString(e) + " " + sha.convertToString(f)
						+ " " + sha.convertToString(g) + " "
						+ sha.convertToString(h));
//				if(i==4)
//				 break; // remember to remove this
				
			}
			System.out.println("Before addition:" +" "+(j / 512) + " " + sha.convertToString(h0) + " "
					+ sha.convertToString(h1) + " " + sha.convertToString(h2)
					+ " " + sha.convertToString(h3) + " "
					+ sha.convertToString(h4) + " " + sha.convertToString(h5)
					+ " " + sha.convertToString(h6) + " "
					+ sha.convertToString(h7));
			h0 = sha.modularAddList(h0, a);
			h1 = sha.modularAddList(h1, b);
			h2 = sha.modularAddList(h2, c);
			h3 = sha.modularAddList(h3, d);
			h4 = sha.modularAddList(h4, e);
			h5 = sha.modularAddList(h5, f);
			h6 = sha.modularAddList(h6, g);
			h7 = sha.modularAddList(h7, h);
			System.out.println("After addition "+(j / 512) + " " + sha.convertToString(h0) + " "
					+ sha.convertToString(h1) + " " + sha.convertToString(h2)
					+ " " + sha.convertToString(h3) + " "
					+ sha.convertToString(h4) + " " + sha.convertToString(h5)
					+ " " + sha.convertToString(h6) + " "
					+ sha.convertToString(h7));
		}
		return sha.convertToString(h0) + " " + sha.convertToString(h1) + " "
				+ sha.convertToString(h2) + " " + sha.convertToString(h3) + " "
				+ sha.convertToString(h4) + " " + sha.convertToString(h5) + " "
				+ sha.convertToString(h6) + " " + sha.convertToString(h7);

	}
}