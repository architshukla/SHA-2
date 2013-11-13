package rawrv.sha2;

import java.util.ArrayList;

public interface SecureHash {
	public ArrayList<Boolean> RotR(ArrayList<Boolean> A, int n);
	// Circular Right shift of A by n bits
	
	public ArrayList<Boolean> ShR(ArrayList<Boolean> A, int n);
	// Right shift of A by n bits
	
	public ArrayList<Boolean> concat(ArrayList<Boolean> A, ArrayList<Boolean> B);
	// Concatenation of bit arrays
	
	public ArrayList<Boolean> Ch(ArrayList<Boolean> X, ArrayList<Boolean> Y, ArrayList<Boolean> Z);
	// Ch(X,Y,Z) = (X & Y) ^ (NotX & Y)
	
	public ArrayList<Boolean> Maj(ArrayList<Boolean> X, ArrayList<Boolean> Y, ArrayList<Boolean> Z);
	// Maj(X,Y,Z) = (X & Y) ^ (X & Z) ^ (Y & Z)

	public ArrayList<Boolean> SIGMA0(ArrayList<Boolean> X);
	// RotR(X,2) ^ RotR(X,13) ^ RotR(X,22)
	
	public ArrayList<Boolean> SIGMA1(ArrayList<Boolean> X);
	// RotR(X,6) ^ RotR(X,11) ^ RotR(X,25)
	
	public ArrayList<Boolean> sigma0(ArrayList<Boolean> X);
	// RotR(X,7) ^ RotR(X,18) ^ RotR(X,3)
	
	public ArrayList<Boolean> sigma1(ArrayList<Boolean> X);
	// RotR(X,17) ^ RotR(X,19) ^ RotR(X,10)
	
	public ArrayList<Boolean> padding(ArrayList<Boolean> input);
	// Pads bits to make the length of bit string a multiple of 512
}
