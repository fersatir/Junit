package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.repository.MessageRepository;

@ExtendWith(MockitoExtension.class)//junit5 ile mockitoyu kullanmayı sağlar.
public class MessageServiceTest2 {

	//repository testi yapılıyor
	@Mock
	MessageRepository repository;//gerçek olmayan repository nesnesi üretmek
	
	@InjectMocks
	MessageService service;//message servisin ihtiyaç duyduğu nesneleri yani repositaları service nesnesine injet et.
	
	//bu kısımda repository üzerinden getMessage methodunu çağır ve db'den izole olarak sanki db'den mesaj
	//çekiyormuş gibi liste ile verileri getiriyor.
	@Test
	void testGetMessageWithLengthLessThanFive() {
		try {
			when(repository.getMessages()).
				thenReturn(Arrays.asList("Junit","Mockito","Mock","Test","Message"));//sanal olarak db'den veriler geliyor gibi 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//getmessage ile dönen verileri liste atar
		List<String> actualList = service.getMessageWithLengthLessThanFive();
		
		assertNotNull(actualList);
		assertEquals(4, actualList.size());
	}
	
	//service aracılığı ile repository'den getMessage çağırıldığında gerçekte objeye gitmiyor,
	//benim istediğim verileri sanki objeden alıyormuş gibi döndürüyor.
	//bu işleme genel olarak mocklama deniyor.
	@Test
	void testException() {
		try {
			when(repository.getMessages()).thenThrow(new SQLException("Connection Exception"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> messages = service.getMessages();
		
		assertNotNull(messages);
		assertEquals(0, messages.size());
	}
	

}
