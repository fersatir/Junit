package junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class J04BeforeAll_AfterAll {

	//beforeAll tüm test methodlarından önce çalışır.
	@BeforeAll
	static void beforeAll(TestInfo info) {
		System.out.println(info.getDisplayName()+" open a file");
	}
	
	@Test
	void testWithArrays() {
		String str="Unit test with JUnits5";
		String [] actualResult=str.split(" ");
		String [] expectedResult = {"Unit","test", "with","JUnits5"};
		
		System.out.println("test1");
		assertArrayEquals(expectedResult,actualResult,"Arrays are not equal");
	}
	
	//afterAll tüm test methodlarından sonra çalışır
	@AfterAll
	static void afterAll(TestInfo info) {
		System.out.print(info.getDisplayName()+" close file");
	}
	
	@Test
	void testWithArrays2() {
		String str="Unit test with JUnits5";
		String [] actualResult=str.split(" ");
		String [] expectedResult = {"Unit","test", "with","JUnits5"};
		
		System.out.println("test 2");
		assertArrayEquals(expectedResult,actualResult,"Arrays are not equal");
	}

}
