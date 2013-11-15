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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> ShR(List<Boolean> A, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> concat(List<Boolean> A, List<Boolean> B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> Ch(List<Boolean> X, List<Boolean> Y,
			List<Boolean> Z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> Maj(List<Boolean> X, List<Boolean> Y,
			List<Boolean> Z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> SIGMA0(List<Boolean> X) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> SIGMA1(List<Boolean> X) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> sigma0(List<Boolean> X) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> sigma1(List<Boolean> X) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void padding(List<Boolean> input) {
		input.add(true);
		int k = 10; // simply
		// find k
		for (int j = 0; j < k; k++) {
			input.add(false);
		}
	}
}
