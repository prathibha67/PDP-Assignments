package com.example.ThreadService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ThreadServiceTests {
	@Test
	void testSingletonBehavior() {
		// Given
		LoggerService spyLoggerService = Mockito.spy(LoggerService.getInstance());

		// When
		Thread t1 = new Thread(() -> {
			spyLoggerService.log("Received message from thread1");
		});

		// Only one thread logs
		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Then
		// Verify that log is called only once since only one thread logs
		verify(spyLoggerService, times(1)).log("Received message from thread1");
		verify(spyLoggerService, times(1)).getInstance();
	}


	@Test
	void testLogOutput() {
		// Given
		LoggerService loggerService = LoggerService.getInstance();
		Thread t1 = new Thread(() -> {
			loggerService.log("Received message from thread1");
		});

		Thread t2 = new Thread(() -> {
			loggerService.log("Received message from thread2");
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	void contextLoads() {
	}

}
