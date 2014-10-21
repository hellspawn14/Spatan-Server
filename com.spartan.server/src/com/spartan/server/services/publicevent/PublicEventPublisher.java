package com.spartan.server.services.publicevent;

import javax.xml.ws.Endpoint;


public class PublicEventPublisher 
{
	public static void main(String args[])
	{
		Endpoint.publish("http://localhost:9879/PublicEvent", new PublicEventServiceImpl());
	}
}
