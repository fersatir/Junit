package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class J05TestingExceptions {

	//Test ettiğimiz kodun bizim beklediğimiz exceptionu fırlattı mı test örneği
	@Test
	void testException1() {
		String str="Hello Worl";
		
		assertThrows(NullPointerException.class, ()->{
			System.out.println("testExeception1 is run");
			str.length();
		});
	}
	
	@Test
	void testException2() {
		String str="Java";
		//Yazılacak exception tipi ya aynı yada parenti olmalıdır.
		assertThrows(NumberFormatException.class,()->{
			Integer.parseInt(str);
		});
	}
	
	@Test
	void testException3() {
		int x = 123;
		int y = 0;
		
		assertThrows(ArithmeticException.class,()->{
			int resutl = x/y;
		});
	}
	
	
	@Test
	void testException4() {
		int x=123;
		int y = 0;
		
		assertThrows(ArithmeticException.class,()->divide(x,y));
	}
	
	private int divide(int a, int b) {
		return a/b;
	}

	
	@Test
	void testException5() {
		int age=-9;
		assertThrows(IllegalArgumentException.class,()->checkAge(age));
	}
	
	private void checkAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException();
		}else {
			System.out.println(age);
		}
	}
}
