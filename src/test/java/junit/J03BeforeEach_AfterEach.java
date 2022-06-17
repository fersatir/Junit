package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class J03BeforeEach_AfterEach {

	String str;
	
	// her testten önce çalışacak olan method
	@BeforeEach
	void beforeEach() {
		str="Junit5 is better than4";
		System.out.println("beforeEach() is executed");
	}
	
	// her testten sonra çalışacak olan method
	@AfterEach
	void afterEach() {
		str=null;
		System.out.println("afterEach() is executed");
	}
	
	@Test
	void testArray(TestInfo info) {
		String [] actualArr= str.split(" ");
		String [] expectedArr = {"Junit5","is","better","than4"};
		
		System.out.println(info.getDisplayName()+" is executed");
		
		assertTrue(Arrays.equals(actualArr, expectedArr));
	}

	
	@Test
	void testStringLength(TestInfo info) {
		int actualLength=str.length();
		int expectedLength=22;

		assertEquals(actualLength,expectedLength);
	
		System.out.println(info.getDisplayName()+" is executed");
	}
}
