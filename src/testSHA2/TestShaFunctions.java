package testSHA2;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import rawrv.sha2.SecureHashFuncrions;

public class TestShaFunctions {

	static SecureHashFuncrions testShaFunctions;

	@BeforeClass
	public static void testsetUp() {
		testShaFunctions = new SecureHashFuncrions();
	}

	@Test
	public void testconvertToList1() {
		List<Boolean> actual = testShaFunctions.convertToList("a");
		Boolean[] expectedInArray = { false, true, true, false, false, false,
				false, true };
		List<Boolean> expected = new ArrayList(Arrays.asList(expectedInArray));
		assertEquals(expected, actual);
		
		System.out.println(testShaFunctions.convertToList(7));
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
//		System.out.println(testShaFunctions.listToBigInteger(actual));
//		System.out.println();
		Boolean[] expectedInArray = { false, true, true, false, false, false,
				false, true };
		List<Boolean> expected = new ArrayList(Arrays.asList(expectedInArray));
//		System.out.println(testShaFunctions.listToBigInteger(expected));
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
//		System.out.println(testShaFunctions.convertToString(expected3));

	}
}
