package com.app.service;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class MessageServiceTest1 {
	//Junit adı üzerinde birim testi belirli methodu test etmek için kullanılır.
	//bağımlılıkların olduğu durumlarda bu bağımlılıklardan kurtulmak gerekir service-->repository-->db
	//böylece bağımlılıkların yan etkilerinin önlenmesi sağlanır.
	//Gerçek nesneler  beklenmedik durumlara neden olabilir.db üzerinde çalışmak verimli olmaz testin uzamasını ve sağlıklı sonuç alamamızı sağlar.
	//Gerçek nesneler yavaş çalışabilir ve zor bir şekilde yapılandırılır.
	//Gerçek nesneler tekrar edilebilir olmayabilir.
	// bu sebeplerden dolayı sanal ortam oluşturma ihtiyacı oluşmuş
	//JAva da mocking işlemlerini yapabilmek için Mockito, JMockit ve EasyMock kütüphaneler kullanılabilir.
	//Mockito 3. parti yazılım olduğu için kütüphaneye eklemek gerekiyor. pom.xml ekliyoruz.
	
	
	//message servisi test ediliyor, bu nedenle mockito üzerinden message servisi oluşturuluyor mockitonun özelliklerini kullanabilmek için
	@Test
	void addMessageTest() {
		MessageService service = mock(MessageService.class);

		service.addMessage("Merhaba");
		service.addMessage("Mockito");

		verify(service).addMessage("Mockito");// verify işlemin gerçekleşip gerçekleşmediğini kontrol etmek için kullanılır.

	}

	@Test
	void howManyCallTest() {
		MessageService service = mock(MessageService.class);

		service.addMessage("Merhaba");
		service.addMessage("Merhaba");
		service.addMessage("Mockito");

		// verify(service,times(2)).addMessage("Merhaba");//Doğrulama işlemi yapar

		// verify(service,never()).removeMessage(any());//hiç mesaj silinmediğini kontrol ederiz.

		verify(service, atLeast(2)).addMessage("Merhaba");//2 defa merhaba eklenip eklenmediğini test ediyor.

	}

	@Test
	void callOrderTest() {
		MessageService service = mock(MessageService.class);

		service.addMessage("Merhaba");
		service.addMessage("Mockito");
		
		InOrder inOrder=inOrder(service);//servisin sırayla çalışıp çalışmadığını kontrol eder.
		
		inOrder.verify(service).addMessage("Merhaba");
		inOrder.verify(service).addMessage("Mockito");
		
		
	}

}
