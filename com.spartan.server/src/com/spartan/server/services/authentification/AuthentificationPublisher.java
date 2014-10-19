package com.spartan.server.services.authentification;

import javax.xml.ws.Endpoint;

public class AuthentificationPublisher 
{
	public static void main(String args[])
	{
		Endpoint.publish("http://192.168.0.26:9876/Auth", new AuthentificationServiceImpl());
	}
}
