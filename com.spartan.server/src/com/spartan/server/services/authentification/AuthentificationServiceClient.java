package com.spartan.server.services.authentification;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.net.URL;

public class AuthentificationServiceClient 
{
	public static void main(String args[ ]) throws Exception 
	{

		//http://localhost:9876/Auth
		//TODO Cambiar IP a conveniencia
        URL url = new URL("http://157.253.227.203:9876/Auth?wsdl");
        QName qname = new QName("http://authentification.services.server.spartan.com/", "AuthentificationServiceImplService");
        // Create, in effect, a factory for the service.
        Service service = Service.create(url, qname);
        // Extract the endpoint interface, the service "port".
        AuthentificationService eif = service.getPort(AuthentificationService.class);
        System.out.println(eif.logIn("hellspawn", "Kira142"));
  
   }
}
