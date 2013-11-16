package rawrv.sha2;

import java.util.ArrayList;
import java.util.List;

public class SecureHashFuncrions implements SecureHashInterface {

	public List<Boolean> convertToList(String input) {
		byte[] bitVector = input.getBytes();
		List<Boolean> bitVect = new ArrayList<Boolean>();
		for (byte b : bitVector) {
			ArrayList<Boolean> bytes = new ArrayList<Boolean>();
			for (int i = 0; i < 8; i++) {
				if ((b & 1) == 1)
					bytes.add(0, true);
				else
					bytes.add(0, false);
				b = (byte) (b >> 1);
			}
			bitVect.addAll(bytes);
		}
		return bitVect;
	}

	@Override
	public List<Boolean> RotR(List<Boolean> A, int n) {
		n = n % A.size();
		for (int i = 0; i < n; i++) {
			Boolean temp = A.remove(A.size() - 1);
			A.add(0, temp);
		}
		return A;
	}

	@Override
	public List<Boolean> ShR(List<Boolean> A, int n) {

		n = n % A.size();
		for (int i = 0; i < n; i++) {
			A.remove(A.size() - 1);
			A.add(0, false);
		}
		return A;
	}

	@Override
	public List<Boolean> concat(List<Boolean> A, List<Boolean> B) {
		A.addAll(B);
		return A;
	}

	@Override
	public List<Boolean> Ch(List<Boolean> X, List<Boolean> Y, List<Boolean> Z) {
		return xor(and(X, Y), and(not(X), Z));
	}

	@Override
	public List<Boolean> Maj(List<Boolean> X, List<Boolean> Y, List<Boolean> Z) {
		return xor(xor(and(X, Y), and(X, Z)), and(Y, Z));
	}

	@Override
	public List<Boolean> SIGMA0(List<Boolean> X) {
		return xor(xor(RotR(X, 2), RotR(X, 13)), RotR(X, 22));
	}

	@Override
	public List<Boolean> SIGMA1(List<Boolean> X) {
		return xor(xor(RotR(X, 6), RotR(X, 11)), RotR(X, 25));
	}

	@Override
	public List<Boolean> sigma0(List<Boolean> X) {
		return xor(xor(RotR(X, 7), RotR(X, 18)), ShR(X, 3));
	}

	@Override
	public List<Boolean> sigma1(List<Boolean> X) {
		return xor(xor(RotR(X, 17), RotR(X, 19)), ShR(X, 10));
	}

	@Override
	public List<Boolean> xor(List<Boolean> A, List<Boolean> B) {
		while (A.size() < B.size()) {
			A.add(false);
		}
		while (A.size() > B.size()) {
			B.add(false);
		}
		for (int i = 0; i < A.size(); i++) {
			Boolean temp = A.get(i) ^ B.get(i);
			A.set(i, temp);
		}
		return A;
	}

	@Override
	public List<Boolean> and(List<Boolean> A, List<Boolean> B) {
		while (A.size() < B.size()) {
			A.add(false);
		}
		while (A.size() > B.size()) {
			B.add(false);
		}
		for (int i = 0; i < A.size(); i++) {
			Boolean temp = A.get(i) & B.get(i);
			A.set(i, temp);
		}
		return A;
	}

	@Override
	public List<Boolean> or(List<Boolean> A, List<Boolean> B) {
		while (A.size() < B.size()) {
			A.add(false);
		}
		while (A.size() > B.size()) {
			B.add(false);
		}
		for (int i = 0; i < A.size(); i++) {
			Boolean temp = A.get(i) | B.get(i);
			A.set(i, temp);
		}
		return A;
	}

	private List<Boolean> not(List<Boolean> A) {
		for (int i = 0; i < A.size(); i++) {
			Boolean temp = !A.get(i);
			A.set(i, temp);
		}
		return A;
	}

	@Override
	public void padding(List<Boolean> input) {
		input.add(true);
		int k = 10; // simply
		// find k
		for (int j = 0; j < k; k++) {
			input.add(false);
		}
		// append length l
	}
}
