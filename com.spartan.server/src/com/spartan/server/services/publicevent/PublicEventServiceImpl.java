package com.spartan.server.services.publicevent;

import java.sql.ResultSet;

import javax.jws.WebService;

import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;
import com.spartan.server.entities.PublicEvent;

@WebService(endpointInterface = "com.spartan.server.services.publicevent.PublicEventService")
public class PublicEventServiceImpl implements PublicEventService
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------
	
	/*
	 * Ver eventos publicos 
	 * Inscribirse en eventov publico 
	 * Ver catalogo 
	 * 
	 */
	
	/**
	 * Relacion con el servicio de conexion a base de datos
	 */
	private DBService dbService;
	
	/**
	 * Relacion con el servicio de generacion de Queries
	 */
	private ScriptGenerator generator;

	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	public PublicEventServiceImpl()
	{
		dbService = new DBService();
		generator = new ScriptGenerator();
	}
	
	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------
	
	public String getPublicEventsSearchParam(String sport)
	{
		String ans = "";
		try 
		{
			String query = generator.getPublicEventParam(sport);
			ResultSet rs = dbService.sendQueryToDB(query);
			//Evento vacio con propositos generales 
			PublicEvent Pe = new PublicEvent (0, "Name", "Sport", "Organizer", "Place", "Details", "Date");
			while (rs.next()) 
			{
				Pe.setEventId(rs.getInt("IdPublicEvent"));
				Pe.setEventName(rs.getString("EventName"));
				Pe.setSport(rs.getString("Sport"));
				Pe.setOrganizer(rs.getString("EventOrganizer"));
				Pe.setPlace(rs.getString("Place"));
				Pe.setDetails(rs.getString("Details"));
				Pe.setDate(rs.getString("Date"));
				//return "@" + this.getEventId() + "%" + this.getEventName() + "%" + this.getSport() + "%" + this.getOrganizer() + "%" + this.getPlace() + "%" + this.getDetails() + this.getDate() + "@";
				ans += Pe.getString();
			}
		}
		catch(Exception e)
		{
			ans = "There's some thing wrong";
			e.printStackTrace();
		}
		return ans; 
	}
	
	public String getAllPublicEvents()
	{
		String ans = "";
		try 
		{
			String query = generator.getPublicEventCatalog();
			ResultSet rs = dbService.sendQueryToDB(query);
			//Evento vacio con propositos generales 
			PublicEvent Pe = new PublicEvent (0, "Name", "Sport", "Organizer", "Place", "Details", "Date");
			while (rs.next()) 
			{
				Pe.setEventId(rs.getInt("IdPublicEvent"));
				Pe.setEventName(rs.getString("EventName"));
				Pe.setSport(rs.getString("Sport"));
				Pe.setOrganizer(rs.getString("EventOrganizer"));
				Pe.setPlace(rs.getString("Place"));
				Pe.setDetails(rs.getString("Details"));
				Pe.setDate(rs.getString("Date"));
				//return "@" + this.getEventId() + "%" + this.getEventName() + "%" + this.getSport() + "%" + this.getOrganizer() + "%" + this.getPlace() + "%" + this.getDetails() + this.getDate() + "@";
				ans += Pe.getString();
			}
		}
		catch(Exception e)
		{
			ans = "There's some thing wrong";
			e.printStackTrace();
		}
		return ans; 
	}
	
	/**
	 * Registra a un usuario en un evento publico 
	 * @param eventId - Id del evento 
	 * @param userId - Id del usuario 
	 * @return Resultado de la operacion 
	 */
	public String registerInPublicEvent(int eventId, int userId)
	{
		String ans = "";
		String query = generator.registerPublicEventAssistence(eventId, userId);
		try
		{
			dbService.sendExcuteUpdate(query);
			ans = "Event registered";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ans = "Ooops";
		}
		return ans;
	}
	
	/**
	 * Cancela una asistencia a un evento publico 
	 * @param eventId - Identificador del evento 
	 * @param userId - identificador del usuario 
	 * @return Resultado de la operacion 
	 */
	public String cancelPublicEventAssistence(int eventId, int userId)
	{
		String ans = "";
		String query = generator.cancelPublicEvent(eventId, userId);
		try 
		{
			dbService.sendExcuteUpdate(query);
			ans = "Event deleted";
		}
		catch(Exception e)
		{
			ans = "Oops";
			e.printStackTrace();
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		PublicEventServiceImpl Pe = new PublicEventServiceImpl();	
		System.out.println(Pe.getPublicEventsSearchParam("Videogame"));
	}

}
