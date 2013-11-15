package rawrv.sha2;

import java.util.ArrayList;

public final class SHA2 implements SecureHash {
	
	private SHA2() {
		// Private constructor to avoid instantiation of the class
	}
	
	public static String hash(String input) {
		// TODO Implement main hash function
		// 1. Convert String into an ArrayList<Boolean>
		// 2. Use the padding() function to pad the bit string
		// 3. Divide each 512 bit string in 16 + 48 blocks
		// 4. Use the other utility functions
		return null;
	}

	@Override
	public ArrayList<Boolean> RotR(ArrayList<Boolean> A, int n) {
		n = n % A.size();
		for(int i = 0; i < n; i++)
		{
			Boolean temp = A.remove(A.size() - 1);
			A.add(0, temp);
		}
		return A;
	}

	@Override
	public ArrayList<Boolean> ShR(ArrayList<Boolean> A, int n) {
		n = n % A.size();
		for(int i = 0; i < n; i++)
		{
			A.remove(A.size() - 1);
			A.add(0, false);
		}
		return A;
	}

	@Override
	public ArrayList<Boolean> concat(ArrayList<Boolean> A, ArrayList<Boolean> B) {
		A.addAll(B);
		return A;
	}

	@Override
	public ArrayList<Boolean> Ch(ArrayList<Boolean> X, ArrayList<Boolean> Y,
			ArrayList<Boolean> Z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boolean> Maj(ArrayList<Boolean> X, ArrayList<Boolean> Y,
			ArrayList<Boolean> Z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boolean> SIGMA0(ArrayList<Boolean> X) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boolean> SIGMA1(ArrayList<Boolean> X) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boolean> sigma0(ArrayList<Boolean> X) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boolean> sigma1(ArrayList<Boolean> X) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boolean> padding(ArrayList<Boolean> input) {
		// TODO Auto-generated method stub
		return null;
	}
}