package com.spartan.server.services.user;

import javax.xml.ws.Endpoint;

public class UserPublisher 
{
	public static void main(String args[])
	{
		Endpoint.publish("http://localhost:9877/Register", new UserServiceImpl());
	}
}
