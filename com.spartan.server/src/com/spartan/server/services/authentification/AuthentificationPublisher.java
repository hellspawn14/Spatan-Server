package com.spartan.server.services.authentification;

import javax.xml.ws.Endpoint;

public class AuthentificationPublisher 
{
	public static void main(String args[])
	{
		Endpoint.publish("http://157.253.227.203:9876/Auth", new AuthentificationServiceImpl());
	}
}
