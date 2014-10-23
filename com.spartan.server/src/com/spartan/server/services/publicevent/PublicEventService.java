package com.spartan.server.services.publicevent;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;



@WebService
@SOAPBinding(style = Style.RPC) 
public interface PublicEventService extends java.rmi.Remote
{
	@WebMethod public String getPublicEventsSearchParam(String sport);
	@WebMethod public String getAllPublicEvents();
	@WebMethod public String registerInPublicEvent(int eventId, int userId);
	@WebMethod public String cancelPublicEventAssistence(int eventId, int userId);
}
