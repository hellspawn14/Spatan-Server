package com.spartan.server.services.authentification;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.net.URL;

public class AuthentificationServiceClient 
{
	public static void main(String args[ ]) throws Exception 
	{
        URL url = new URL("http://192.168.0.26:9876/Auth?wsdl");
        QName qname = new QName("http://authentification.services.server.spartan.com/", "AuthentificationServiceImplService");
        Service service = Service.create(url, qname);
        AuthentificationService eif = service.getPort(AuthentificationService.class);
        System.out.println(eif.logIn("hellspawn", "Kira142"));
   }
}
