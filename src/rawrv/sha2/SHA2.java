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

	private ArrayList<Boolean> RotR(ArrayList<Boolean> A, int n) {
		n = n % A.size();
		for(int i = 0; i < n; i++)
		{
			Boolean temp = A.remove(A.size() - 1);
			A.add(0, temp);
		}
		return A;
	}

	private ArrayList<Boolean> ShR(ArrayList<Boolean> A, int n) {
		n = n % A.size();
		for(int i = 0; i < n; i++)
		{
			A.remove(A.size() - 1);
			A.add(0, false);
		}
		return A;
	}

	private ArrayList<Boolean> concat(ArrayList<Boolean> A, ArrayList<Boolean> B) {
		A.addAll(B);
		return A;
	}

	private ArrayList<Boolean> Ch(ArrayList<Boolean> X, ArrayList<Boolean> Y,
			ArrayList<Boolean> Z) {
		return xor(and(X,Y),and(not(X),Z));
	}

	private ArrayList<Boolean> Maj(ArrayList<Boolean> X, ArrayList<Boolean> Y,
			ArrayList<Boolean> Z) {
		return xor(xor(and(X,Y),and(X,Z)),and(Y,Z));
	}

	private ArrayList<Boolean> SIGMA0(ArrayList<Boolean> X) {
		return xor(xor(RotR(X,2),RotR(X,13)),RotR(X,22));
	}

	private ArrayList<Boolean> SIGMA1(ArrayList<Boolean> X) {
		return xor(xor(RotR(X,6),RotR(X,11)),RotR(X,25));
	}

	private ArrayList<Boolean> sigma0(ArrayList<Boolean> X) {
		return xor(xor(RotR(X,7),RotR(X,18)),ShR(X,3));
	}

	private ArrayList<Boolean> sigma1(ArrayList<Boolean> X) {
		return xor(xor(RotR(X,17),RotR(X,19)),ShR(X,10));
	}

	private ArrayList<Boolean> padding(ArrayList<Boolean> input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ArrayList<Boolean> xor(ArrayList<Boolean> A, ArrayList<Boolean> B) {
		while(A.size() < B.size())
		{
			A.add(false);
		}
		while(A.size() > B.size())
		{
			B.add(false);
		}
		for(int i = 0; i < A.size(); i++)
		{
			Boolean temp = A.get(i) ^ B.get(i);
			A.set(i, temp);
		}
		return A;
	}
	
	private ArrayList<Boolean> and(ArrayList<Boolean> A, ArrayList<Boolean> B) {
		while(A.size() < B.size())
		{
			A.add(false);
		}
		while(A.size() > B.size())
		{
			B.add(false);
		}
		for(int i = 0; i < A.size(); i++)
		{
			Boolean temp = A.get(i) & B.get(i);
			A.set(i, temp);
		}
		return A;
	}
	
	private ArrayList<Boolean> not(ArrayList<Boolean> A) {
		for(int i = 0; i < A.size(); i++)
		{
			Boolean temp = !A.get(i);
			A.set(i, temp);
		}
		return A;
	}
}