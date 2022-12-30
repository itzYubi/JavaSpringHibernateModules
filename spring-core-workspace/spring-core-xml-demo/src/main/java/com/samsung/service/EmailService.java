package com.samsung.service;

public class EmailService implements MessageService{

	public void sendMsg(String message) {
		System.out.println("In message service");
		System.out.println(message);
		
	}

}
