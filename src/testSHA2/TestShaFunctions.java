package testSHA2;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import rawrv.sha2.SecureHashFunctions;

public class TestShaFunctions {

	static SecureHashFunctions testShaFunctions;

	@BeforeClass
	public static void testsetUp() {
		testShaFunctions = new SecureHashFunctions();
	}

	@Test
	public void testconvertToList1() {
		List<Boolean> actual = testShaFunctions.convertToList("a");
		Boolean[] expectedInArray = { false, true, true, false, false, false,
				false, true };
		List<Boolean> expected = new ArrayList(Arrays.asList(expectedInArray));
		assertEquals(expected, actual);
		int a = 0xbb67ae85;
		// System.out.println(testShaFunctions.convertToList(testShaFunctions.H[0])+" "+testShaFunctions.H[0]+" "+0x6a09e667);
//		System.out.println(testShaFunctions
//				.convertToList(testShaFunctions.H[1])
//				+ " "
//				+ Integer.toHexString(testShaFunctions.H[1]));
		// System.out.println(testShaFunctions.convertToList(testShaFunctions.H[2])+" "+testShaFunctions.H[0]+" "+0x3c6ef372);
		// System.out.println(testShaFunctions.convertToList(testShaFunctions.H[3])+" "+testShaFunctions.H[0]+" "+0xa54ff53a);
		// System.out.println(testShaFunctions.convertToList(testShaFunctions.H[4])+" "+testShaFunctions.H[0]+" "+0x510e527f);
		// System.out.println(testShaFunctions.convertToList(testShaFunctions.H[5])+" "+testShaFunctions.H[0]+" "+0x9b05688c);
		// System.out.println(testShaFunctions.convertToList(testShaFunctions.H[6])+" "+testShaFunctions.H[0]+" "+0x1f83d9ab);
		// System.out.println(testShaFunctions.convertToList(testShaFunctions.H[7])+" "+testShaFunctions.H[0]+" "+0x5be0cd19);
	}

	@Test
	public void testconvertToList2() {
		List<Boolean> actual = testShaFunctions.convertToList("ab");
		for (Boolean boolean1 : actual) {
			// System.out.println(boolean1);
		}
		Boolean[] expectedInArray = { false, true, true, false, false, false,
				false, true, false, true, true, false, false, false, true,
				false };
		List<Boolean> expected = new ArrayList(Arrays.asList(expectedInArray));
		assertEquals(expected, actual);
	}

	@Test
	public void testListToBigInteger() {
		List<Boolean> actual = testShaFunctions.convertToList("abc");
		// System.out.println(testShaFunctions.listToBigInteger(actual));
		// System.out.println();
		Boolean[] expectedInArray = { false, true, true, false, false, false,
				false, true };
		List<Boolean> expected = new ArrayList(Arrays.asList(expectedInArray));
		// System.out.println(testShaFunctions.listToBigInteger(expected));
	}

	@Test
	public void testPadMessage() {
		List<Boolean> actual = testShaFunctions.convertToList("abc");
		// testShaFunctions.padMessage(actual);
	}

	@Test
	public void testmodularAdd() {
		Boolean[] expectedInArray1 = { false, false, true, true, false, false,
				true, true };
		List<Boolean> expected1 = new ArrayList(Arrays.asList(expectedInArray1));

		Boolean[] expectedInArray2 = { false, false, true, true, false, true,
				false, false };
		List<Boolean> expected2 = new ArrayList(Arrays.asList(expectedInArray2));
		// System.out.println(testShaFunctions.modularAdd(expected1, expected2,
		// 2,
		// 32));
	}

	@Test
	public void testmodularAddList() {
		Boolean[] expectedInArray1 = { false, false, true, true, false, false,
				true, true };
		List<Boolean> expected1 = new ArrayList(Arrays.asList(expectedInArray1));

		Boolean[] expectedInArray2 = { false, false, true, true, false, true,
				false, false };
		List<Boolean> expected2 = new ArrayList(Arrays.asList(expectedInArray2));

		// System.out.println(testShaFunctions
		// .modularAddList(expected1, expected2));
	}

	@Test
	public void testConvertToList() {
		// System.out.println("Convert to list: 10  "
		// + testShaFunctions.convertToList(BigInteger.valueOf(10)));
		// System.out.println("Convert to list: 16  "+testShaFunctions.convertToList(BigInteger.valueOf(0x10)));
	}

	@Test
	public void testHalfByte() {
		Boolean[] expectedInArray1 = { false, false, true, true };
		List<Boolean> expected1 = new ArrayList(Arrays.asList(expectedInArray1));
		Boolean[] expectedInArray2 = { false, true, true, true };
		List<Boolean> expected2 = new ArrayList(Arrays.asList(expectedInArray2));
		assertEquals(3, testShaFunctions.getHalfByte(expected1));
		Boolean[] expectedInArray3 = { true, false, true, true };
		List<Boolean> expected3 = new ArrayList(Arrays.asList(expectedInArray3));
		assertEquals(3, testShaFunctions.getHalfByte(expected1));
		assertEquals(7, testShaFunctions.getHalfByte(expected2));
		assertEquals(11, testShaFunctions.getHalfByte(expected3));

	}

	@Test
	public void testConvertToString() {
		Boolean[] expectedInArray1 = { false, false, true, true };
		List<Boolean> expected1 = new ArrayList(Arrays.asList(expectedInArray1));
		Boolean[] expectedInArray2 = { false, true, true, true };
		List<Boolean> expected2 = new ArrayList(Arrays.asList(expectedInArray2));
		Boolean[] expectedInArray3 = { true, false, true, true };
		List<Boolean> expected3 = new ArrayList(Arrays.asList(expectedInArray3));

		assertEquals("3", testShaFunctions.convertToString(expected1));
		assertEquals("7", testShaFunctions.convertToString(expected2));
		assertEquals("b", testShaFunctions.convertToString(expected3));
		// System.out.println(testShaFunctions.convertToString(expected3));

	}

	@Test
	public void testmodularAddList2(){
		int a = 0x506E3058;
		int b = 0x6A09E667;
		List<Boolean> a1 = testShaFunctions.convertToList(a);
		List<Boolean> b1 = testShaFunctions.convertToList(b);
		System.out.println(testShaFunctions.convertToString(testShaFunctions.modularAddList(a1, b1)));
	}
}
