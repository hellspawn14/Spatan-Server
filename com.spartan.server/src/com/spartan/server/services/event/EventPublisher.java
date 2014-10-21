package com.spartan.server.services.event;

import javax.xml.ws.Endpoint;


public class EventPublisher 
{
	public static void main(String args[])
	{
		Endpoint.publish("http://localhost:9878/Event", new EventServiceImpl());
	}
}
