package junit;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class J09PerformanceTest {

	@Test
	//testin disable edilmesini sağlar
	@Disabled
	void testPrintPerformance() {
		assertTimeout(Duration.ofSeconds(2),
				()->IntStream.rangeClosed(10, 100).forEach(System.out::println));
	}
	
	@Test
	void testPrintPerformance2() {
		assertTimeout(Duration.ofSeconds(1), 
			()->IntStream.rangeClosed(1, 10000).reduce((x,y)->Math.addExact(x, y)));
	}

}
