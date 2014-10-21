package com.spartan.server.services.event;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC) 
public interface EventService extends java.rmi.Remote 
{
	@WebMethod public String createEvent(String sport, String description, String date, int eventAuthor, int availableSpots, String state, String place, String key, String details);
	@WebMethod public String cancelEvent(int idEvent);
	@WebMethod public String registerInEvent(int eventId, int userId);
	@WebMethod public String cancelRegistration(int idEvent, int idParticipant);
	@WebMethod public String getEventsSearchParam(String sport);
	@WebMethod public String getUserAssistences(int idUser);
	@WebMethod public String confirmAssistence(int userId, int eventId);
	@WebMethod public String startEvent(int idEvent);
	@WebMethod public String endEvent(int idEvent);
	
}
