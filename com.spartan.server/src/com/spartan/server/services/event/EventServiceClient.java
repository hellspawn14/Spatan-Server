package com.spartan.server.services.event;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class EventServiceClient 
{
	public static void main(String args[ ]) throws Exception 
	{
		//endpointInterface = "com.spartan.server.services.event.EventService"
        URL url = new URL("http://192.168.0.26:9878/Event?wsdl");
        QName qname = new QName("http://event.services.server.spartan.com/", "EventServiceImplService");
        Service service = Service.create(url, qname);
        EventService eif = service.getPort(EventService.class);
        System.out.println(eif.startEvent(1));
   }
}
