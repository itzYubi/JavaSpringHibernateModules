package com.samsung.service;

public class TwitterService implements MessageService {

	public void sendMsg(String message) {
		System.out.println("In twitter service");
		System.out.println(message);
		
	}

}
