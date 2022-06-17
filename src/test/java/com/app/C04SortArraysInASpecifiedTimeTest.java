package com.app;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.stream.IntStream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class C04SortArraysInASpecifiedTimeTest {
	
	@Test
	void sortArrayInASpecifiedTimeTest1() { // 5 saniyede 1'den 10000 e kadar olacak şekilde methodun çalışması test ediliyor.
		C04SortArraysInASpecifiedTime obj=new C04SortArraysInASpecifiedTime();
		
		assertTimeout(Duration.ofSeconds(1), 
				()->IntStream.rangeClosed(1, 10000).forEach(t->obj.sortArraysInASpecifiedTime()));
	}
	
	C04SortArraysInASpecifiedTime obj=new C04SortArraysInASpecifiedTime();
	
	
	
	@RepeatedTest(1000)//annotation ile 10000 defa bu işlemin yapılacağı ifade ediliyor.
	void sortArrayInASpecifiedTimeTest2() {
		assertTimeout(Duration.ofMillis(1),()->obj.sortArraysInASpecifiedTime());
	}

}
