package com.spartan.server.services.authentification;

import javax.xml.ws.Endpoint;

public class AuthentificationPublisher 
{
	public static void main(String args[])
	{
		Endpoint.publish("http://localhost:9877/Auth", new AuthentificationServiceImpl());
	}
}
