package com.spartan.server.services.publicevent;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class PublicEventServiceClient 
{
	public static void main(String args[ ]) throws Exception 
	{
        URL url = new URL("http://localhost:9879/PublicEvent?wsdl");
        QName qname = new QName("http://publicevent.services.server.spartan.com/", "PublicEventServiceImplService");
        Service service = Service.create(url, qname);
        PublicEventService eif = service.getPort(PublicEventService.class);
        System.out.println(eif.getAllPublicEvents());
   }
}
