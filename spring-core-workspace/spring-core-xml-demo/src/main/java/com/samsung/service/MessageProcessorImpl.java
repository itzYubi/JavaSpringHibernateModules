package com.samsung.service;

public class MessageProcessorImpl implements MessageProcessor {

	private MessageService messageService;
	
	public void processMsg(String message) {
		messageService.sendMsg(message);
	}
	
	public void setMessageService(MessageService messageService)
	{
		this.messageService = messageService; 
	}

}
