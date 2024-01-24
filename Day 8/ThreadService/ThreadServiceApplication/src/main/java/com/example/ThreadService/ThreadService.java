package com.example.ThreadService;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadService {

	public static void main(String[] args) {

		Thread t1=new Thread(()->{
			LoggerService.getInstance().log("Received message from thread1");
		});

		Thread t2=new Thread(()->{
			LoggerService.getInstance().log("Received message from thread2");
		});

		t1.start();
		t2.start();
	}

}
