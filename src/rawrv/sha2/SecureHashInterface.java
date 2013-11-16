package rawrv.sha2;

import java.util.List;

public interface SecureHashInterface {
	int[] K = { 0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b,
			0x59f111f1, 0x923f82a4, 0xab1c5ed5, 0xd807aa98, 0x12835b01,
			0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7,
			0xc19bf174, 0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc,
			0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da, 0x983e5152,
			0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147,
			0x06ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138, 0x4d2c6dfc,
			0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
			0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819,
			0xd6990624, 0xf40e3585, 0x106aa070, 0x19a4c116, 0x1e376c08,
			0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f,
			0x682e6ff3, 0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208,
			0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2 };
	
	int[] H = { 0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f,
			0x9b05688c, 0x1f83d9ab, 0x5be0cd19 };

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

	public void padMessage(List<Boolean> input);

	// Pads bits to make the length of bit string a multiple of 512

	public List<Boolean> xor(List<Boolean> A, List<Boolean> B);

	public List<Boolean> or(List<Boolean> A, List<Boolean> B);

	public List<Boolean> and(List<Boolean> A, List<Boolean> B);

}
