package rawrv.sha2;

import java.util.ArrayList;

public class SecureHashFuncrions implements SecureHashInterface {
	
	public ArrayList<Boolean> convertToList(String input) {
		byte[] bitVector = input.getBytes();
		ArrayList<Boolean> bitVect = new ArrayList<Boolean>();
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
	public ArrayList<Boolean> RotR(ArrayList<Boolean> A, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boolean> ShR(ArrayList<Boolean> A, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boolean> concat(ArrayList<Boolean> A, ArrayList<Boolean> B) {
		// TODO Auto-generated method stub
		return null;
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
	public void padding(ArrayList<Boolean> input) {
		input.add(true);
		int k = 10; // simply
		// find k
		for (int j = 0; j < k; k++) {
			input.add(false);
		}
	}
}
