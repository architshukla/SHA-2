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
		for (Boolean boolean1 : actual) {
			// System.out.println(boolean1);
		}
		Boolean[] expectedInArray = { false, true, true, false, false, false,
				false, true };
		List<Boolean> expected = new ArrayList(Arrays.asList(expectedInArray));
		assertEquals(expected, actual);
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
	public void testListToByte() {
		List<Boolean> actual = testShaFunctions.convertToList("abc");
//		testShaFunctions.listToByte(actual);
//		System.out.println();
		Boolean[] expectedInArray = { false, true, true, false, false, false,
				false, true };
		List<Boolean> expected = new ArrayList(Arrays.asList(expectedInArray));
//		testShaFunctions.listToByte(expected);
	}
	@Test
	public void testPadMessage(){
		List<Boolean> actual = testShaFunctions.convertToList("abc");
//		testShaFunctions.padMessage(actual);
	}
	
	@Test
	public void testmodularAdd(){
		Boolean[] expectedInArray1 = { false, false,true, true, false, false,
				true,true };
		List<Boolean> expected1 = new ArrayList(Arrays.asList(expectedInArray1));
		
		Boolean[] expectedInArray2 = { false, false,true, true, false, true,
				false,false };
		List<Boolean> expected2 = new ArrayList(Arrays.asList(expectedInArray2));
		System.out.println(testShaFunctions.modularAdd(expected1, expected2, 2, 32));
	}
	
	@Test
	public void testmodularAddList(){
		Boolean[] expectedInArray1 = { false, false,true, true, false, false,
				true,true };
		List<Boolean> expected1 = new ArrayList(Arrays.asList(expectedInArray1));
		
		Boolean[] expectedInArray2 = { false, false,true, true, false, true,
				false,false };
		List<Boolean> expected2 = new ArrayList(Arrays.asList(expectedInArray2));
		
		System.out.println(testShaFunctions.modularAddList(expected1, expected2));
	}
}
