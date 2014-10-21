package com.spartan.server.services.user;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class UserServiceClient 
{
	public static void main(String args[ ]) throws Exception 
	{
        URL url = new URL("http://localhost:9876/Register?wsdl");
        QName qname = new QName("http://user.services.server.spartan.com/", "UserServiceImplService");
        Service service = Service.create(url, qname);
        // Extract the endpoint interface, the service "port".
        UserService eif = service.getPort(UserService.class);
        System.out.println(eif.register("kirakirara","123456","3005698716"));
   }
}
