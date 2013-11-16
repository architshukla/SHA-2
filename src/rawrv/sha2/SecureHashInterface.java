package rawrv.sha2;

import java.util.List;

public interface SecureHashInterface {

	public List<Boolean> convertToList(String input);

	public List<Boolean> RotR(List<Boolean> A, int n);
	// Circular Right shift of A by n bits

	public List<Boolean> ShR(List<Boolean> A, int n);
	// Right shift of A by n bits

	public List<Boolean> concat(List<Boolean> A, List<Boolean> B);
	// Concatenation of bit arrays

	public List<Boolean> Ch(List<Boolean> X, List<Boolean> Y, List<Boolean> Z);
	// Ch(X,Y,Z) = (X & Y) ^ (NotX & Y)

	public List<Boolean> Maj(List<Boolean> X, List<Boolean> Y, List<Boolean> Z);
	// Maj(X,Y,Z) = (X & Y) ^ (X & Z) ^ (Y & Z)

	public List<Boolean> SIGMA0(List<Boolean> X);
	// RotR(X,2) ^ RotR(X,13) ^ RotR(X,22)

	public List<Boolean> SIGMA1(List<Boolean> X);
	// RotR(X,6) ^ RotR(X,11) ^ RotR(X,25)

	public List<Boolean> sigma0(List<Boolean> X);
	// RotR(X,7) ^ RotR(X,18) ^ RotR(X,3)

	public List<Boolean> sigma1(List<Boolean> X);
	// RotR(X,17) ^ RotR(X,19) ^ RotR(X,10)

	public void padding(List<Boolean> input);
	// Pads bits to make the length of bit string a multiple of 512

	public List<Boolean> xor(List<Boolean> A, List<Boolean> B);

	public List<Boolean> or(List<Boolean> A, List<Boolean> B);

	public List<Boolean> and(List<Boolean> A, List<Boolean> B);

}
