package com.spartan.server.services.event;

import javax.xml.ws.Endpoint;


public class EventPublisher 
{
	public static void main(String args[])
	{
		Endpoint.publish("http://192.168.0.26:9878/Event", new EventServiceImpl());
	}
}
