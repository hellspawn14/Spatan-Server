package com.spartan.server.services.event;

import java.sql.ResultSet;

import javax.jws.WebService;

import com.spartan.server.db.DBService;
import com.spartan.server.db.ScriptGenerator;
import com.spartan.server.entities.RegularEvent;

@WebService(endpointInterface = "com.spartan.server.services.event.EventService")
public class EventServiceImpl implements EventService
{	
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------
	
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

	public EventServiceImpl()
	{
		dbService = new DBService();
		generator = new ScriptGenerator();
	}
	
	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------
	
	/**
	 * Crea un nuevo evento 
	 * @param sport - Es el deporte 
	 * @param description - Es la descripcion 
	 * @param date - Es la fecha del evento 
	 * @param eventAuthor - Es el autor 
	 * @param availableSpots - Es el numero de lugares disponibles 
	 * @param state - Estado del evento 
	 * @param place - Lugar 
	 * @param key - Clave 
	 * @param details - Detalles adicionales 
	 * @return Resultado de la creacion del evento 
	 */
	public String createEvent(String sport, String description, String date, int eventAuthor, int availableSpots, String state, String place, String key, String details)
	{
		String query = generator.createEvent(sport, description, date, eventAuthor, availableSpots, state, place, key, details);
		System.out.println(query);
		String ans = "Ok";
		try
		{
			dbService.sendExcuteUpdate(query);
			System.out.println(query);
			ans = "Event created";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ans = "Opps something went wrong";
		}
		return ans;
	}
	
	/**
	 * Cancela un evento y las asistencias 
	 * @param idEvent - Identificador del evento 
	 * @return Resultado de la operacion 
	 */
	public String cancelEvent(int idEvent)
	{
		String query = generator.updateEventState(idEvent, "Canceled");
		String ans = "Ok";
		try
		{
			dbService.sendExcuteUpdate(query);
			query = generator.cancelSpotsInEvent(idEvent);
			dbService.sendExcuteUpdate(query);
			ans = "Event canceled";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ans = "Opps something went wrong";
		}
		return ans;
	}
	
	/**
	 * Registra una asistencia para un usuario en un evento
	 * @param eventId - Identificador del evento 
	 * @param userId - Identificador del usuario 
	 * @return Resultado de la operacion 
	 */
	public String registerInEvent(int eventId, int userId)
	{
		String ans = "ok";
		String query = generator.reserveSpotEvent(eventId, userId);
		try
		{
			dbService.sendExcuteUpdate(query);
			query = generator.createSpot(eventId, userId);
			dbService.sendExcuteUpdate(query);
			query = generator.getEventKey(eventId);
			String key = "X1";
			ResultSet rs = dbService.sendQueryToDB(query);
			while (rs.next()) 
			{
				key = rs.getString("Key");
			}
			ans = "Spot confirmed with key: " + key;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ans = "Opps something went wrong";
		}
		return ans;
	}
	
	/**
	 * Cancela un registro 
	 * @param idEvent - Id del evento 
	 * @param idParticipant - Id del usuario 
	 * @return Resultado de la operacion 
	 */
	public String cancelRegistration(int idEvent, int idParticipant)
	{
		String ans = "Ok";
		String query = generator.cancelSpot(idEvent, idParticipant);
		try
		{
			dbService.sendExcuteUpdate(query);
			query = generator.cancelSpotInEvent(idEvent);
			dbService.sendExcuteUpdate(query);
			ans = "Your spot has been canceled";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ans = "Opps something went wrong";
		}
		return ans;
	}
	
	/**
	 * Retorna una cadena en String con la informacion basica de los eventos disponibles en el momento 
	 * @param sport - Parametro de busqueda 
	 * @return @1%Videogame%Let's play DOTA%2014/10/31 22:00%1%Open%51.508742,-0.120850%We're playing dota to have fun :) @
	 */
	public String getEventsSearchParam(String sport)
	{
		String ans = "";
		try 
		{
			String query = generator.getAllEventsSearch(sport);
			ResultSet rs = dbService.sendQueryToDB(query);
			System.out.println(query);
			//Evento vacio con propositos generales 
			RegularEvent Re = new RegularEvent (0, "date", "state", "place","details", 0, "key", "sport", "description");
			//return this.getIdEvent() + ":" + this.getSport() + ":" + this.getDescription() + ":" + this.getDate() + ":" + this.getSpots() + ":" + this.getState() + ":" + this.getPlace() + ":" + this.getDetails();
			while (rs.next()) 
			{
				Re.setIdEvent(rs.getInt("idEvent"));
				Re.setSport(rs.getString("Sport"));
				Re.setDescription(rs.getString("Description"));
				Re.setDate(rs.getString("Date"));
				Re.setSpots(rs.getInt("Spots"));
				Re.setState(rs.getString("State"));
				Re.setPlace(rs.getString("Place"));
				Re.setDetails(rs.getString("Details"));
				ans += Re.getString();
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
	 * Retorna una cadena con las asistencias actuales del usuario 
	 * @param idUser - Es el identificador del usuario 
	 * @return @1%ToAssist@/There's no results to display
	 */
	public String getUserAssistences(int idUser)
	{
		String query = generator.getAllSpotsFromUser(idUser + "");
		String ans = "There's no results to display";
		try
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			String temp = "";
			boolean empty = true;
			while (rs.next()) 
			{
				temp += "@" + rs.getInt("idEvent") + "%" + rs.getString("Confirmation") + "@";
				empty = false;
			}
			if (empty)
			{
				ans = "There's no results to display";
			}
			else
			{
				ans = temp;
			}
		}
		catch(Exception e)
		{
			ans = "Oops there's something wrong";
			e.printStackTrace();
		}
		return ans;
	}
	
	/**
	 * Confirma la asistencia de un usuario a un evento 
	 * @param userId - Id del usuario  
	 * @param eventId - Id del evento  
	 * @return Mensaje de confirmacion de la operacion 
	 */
	public String confirmAssistence(int userId, int eventId)
	{
		String ans = "";
		//(int eventId, int idUser, String confirmation)
		String query = generator.updateSpotConfirmation(eventId, userId, "Confirmed");
		try
		{
			dbService.sendExcuteUpdate(query);
			ans = "You've been confirmed";
		}
		catch(Exception e)
		{
			ans = "Oops something went wrong";
			e.printStackTrace();
		}
		return ans;
	}
	
	public String startEvent(int idEvent)
	{
		String ans = "";
		String query = generator.updateEventState(idEvent, "Started");
		try
		{
			dbService.sendExcuteUpdate(query);
			ans = "Event started";
		}
		catch(Exception e)
		{
			ans = "Oops something went wrong";
			e.printStackTrace();
		}
		return ans;
	}
	
	public String endEvent(int idEvent)
	{
		String ans = "";
		String query = generator.updateEventState(idEvent, "Ended");
		try
		{
			dbService.sendExcuteUpdate(query);
			ans = "Event ended";
		}
		catch(Exception e)
		{
			ans = "Oops something went wrong";
			e.printStackTrace();
		}
		return ans;
	}
	
	
	public String getAllEventsFromUser(int userId)
	{
		String ans = "";
		try 
		{
			String query = "SELECT * FROM Spartan.Events WHERE idEventAuthor = " + userId + " AND State = 'Open';";
			ResultSet rs = dbService.sendQueryToDB(query);
			//Evento vacio con propositos generales 
			RegularEvent Re = new RegularEvent (0, "date", "state", "place","details", 0, "key", "sport", "description");
			//return this.getIdEvent() + ":" + this.getSport() + ":" + this.getDescription() + ":" + this.getDate() + ":" + this.getSpots() + ":" + this.getState() + ":" + this.getPlace() + ":" + this.getDetails();
			while (rs.next()) 
			{
				Re.setIdEvent(rs.getInt("idEvent"));
				Re.setSport(rs.getString("Sport"));
				Re.setDescription(rs.getString("Description"));
				Re.setDate(rs.getString("Date"));
				Re.setSpots(rs.getInt("Spots"));
				Re.setState(rs.getString("State"));
				Re.setPlace(rs.getString("Place"));
				Re.setDetails(rs.getString("Details"));
				ans += Re.getString().trim();
			}
		}
		catch(Exception e)
		{
			ans = "There's some thing wrong";
			e.printStackTrace();
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		EventServiceImpl Es = new EventServiceImpl();
		System.out.println(Es.endEvent(1));
	}
	
	
}
