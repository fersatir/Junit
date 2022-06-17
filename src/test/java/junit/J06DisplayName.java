package junit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class J06DisplayName {

	@Test
	//test ismi aşağıdaki annotasyon ile görünmek istediği şekilde değiştirebilirsiniz.
	@DisplayName("Test Parse() to check if it is throwing for not digit value")
	void testException() {
		String str = "Merhaba";

		assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt(str);
		});
	}

}
