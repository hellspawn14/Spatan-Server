package com.spartan.server.services.user;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class UserServiceClient 
{
	public static void main(String args[ ]) throws Exception 
	{
        URL url = new URL("http://192.168.0.26:9877/Register?wsdl");
        QName qname = new QName("http://user.services.server.spartan.com/", "UserServiceImplService");
        Service service = Service.create(url, qname);
        UserService eif = service.getPort(UserService.class);
        System.out.println(eif.register("kuvirah","123456","tireaa"));
   }
}
