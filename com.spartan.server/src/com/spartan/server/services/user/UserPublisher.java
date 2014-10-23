package com.spartan.server.services.user;

import javax.xml.ws.Endpoint;

public class UserPublisher 
{
	public static void main(String args[])
	{
		Endpoint.publish("http://192.168.0.26:9877/Register", new UserServiceImpl());
	}
}
