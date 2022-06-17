package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class J01Assertions {

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
	@Test//assertings methodlar'dan assertEquals beklenen ile gerçekleşeni kıyaslar
	void testlenght() {
		int actualLength="Merhaba".length();
		int expectedLength = 7;
		
		//assertEquals(expectedLength,actualLength);
		
		//3.parametre olarak hata aldığında mesaj yazdırabiliriz.
		//assertEquals(expectedLength,actualLength,"Length ar not matched");
		
		//method true döndüğünde testi geçer, false döndüğünde hata verir
		//assertTrue(actualLength==expectedLength,"Actual length is not matchint with expected length");
	
		//method false döndüğünde testi geçer, true döndüğünde hata verir
		//assertFalse(actualLength==expectedLength);
	}

	@Test
	void testUpperCase() {
		String actualValue="hello".toUpperCase();
		String expectedValue="HELLo";
		
		assertEquals(expectedValue,actualValue,"Eşit değil");
	}
	
	@Test
	void testContainsMethod() {
		//sonucun false olması durumunda testi geçer
		assertEquals(false, "Bekir".contains("t"));
	}
	
	@Test
	void emekliOlabilirMi() {
		int yas = 60;
		int emeklilikYasi=65;
		assertTrue(yas>emeklilikYasi);
	}
	
}
