package com.spartan.server.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import com.spartan.server.db.DBService;
import com.spartan.server.entities.GroupEvent;
import com.spartan.server.entities.GroupTournament;
import com.spartan.server.entities.PublicEvent;
import com.spartan.server.entities.RegularEvent;
import com.spartan.server.entities.SingleEvent;
import com.spartan.server.entities.SoloTournament;
import com.spartan.server.entities.Spartan;
import com.spartan.server.entities.Spot;
import com.spartan.server.entities.Team;
import com.spartan.server.entities.User;
import com.spartan.server.entities.UserProfile;

/**
 * Carga toda la informacion de la db al servidor
 * @author hellspawn
 */
public class SpartanLoader 
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------
	
	/**
	 * Relacion con el servicio de DB
	 */
	private DBService dbService;
	
	/**
	 * Relacion con la clase principal del modelo
	 */
	private Spartan spartan;
	
	//------------------------------------------------------------------
	//Constructores 
	//------------------------------------------------------------------

	public SpartanLoader()
	{
		dbService = new DBService();
		spartan = new Spartan();
		load();
	}
	
	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------
	
	public void load()
	{
		loadPublicEvents();
		loadUsers();
		loadEvents();
		loadTeams();
		loadTeamMembers();
		loadGroupTournaments();
		loadSingleTournaments();
		loadSpots();
	}
	
	public Spartan getModelInstance()
	{
		return spartan;
	}
	
	/**
	 * Carga los eventos publicos de la base de datos al modelo 
	 */
	public void loadPublicEvents()
	{
		String query = "SELECT * FROM Spartan.PublicEvents";
		DBService myService = new DBService();
		try 
		{
			ResultSet result = myService.sendQueryToDB(query);
			PublicEvent Pu = null;
			int eventId;
			String eventName;
			String sport;
			String organizer;
			String place;
			String details;
			String date;
			while (result.next()) 
			{
				eventId = result.getInt("idPublicEvent");
				eventName = result.getString("EventName");
				sport = result.getString("Sport");
				organizer = result.getString("EventOrganizer");
				place = result.getString("Place");
				details = result.getString("Details");
				date = result.getString("Date");
				Pu = new PublicEvent (eventId, eventName, sport, organizer, place, details, date);
				spartan.getPublicCatalog().put(eventId, Pu);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			myService.close();
			myService = null;
		}
	}
	
	public void loadUsers()
	{
		//Cargar datos basicos del usuario 
		DBService myService = new DBService();
		try
		{
			//Sentencia SQL con todos los datos basicos de los usuarios 
			String getUserData = 
					"SELECT * " + "\n" + 
					"FROM Spartan.Users INNER JOIN Spartan.History ON" + "\n" + 
					"Spartan.Users.idUser = Spartan.History.idUserHistory INNER JOIN" + "\n" +		
					"Spartan.ScoreBoard ON Spartan.Users.idUser = Spartan.ScoreBoard.idUserBoard;";
			ResultSet rsUsuarios = myService.sendQueryToDB(getUserData);
			
			//Datos usuarios
			User U;
			int userId;
			String userName;
			
			//Datos del perfil 
			UserProfile Up;
			String phoneNumber;
			double score;
			int nSoccer;
			int nBasketball;
			int nVoleyball;
			int nTennis;
			int nPaintball;
			int nVideogames;
			int nKarts;
			int nVictories;
			int nLoses;
			while (rsUsuarios.next()) 
			{
				phoneNumber = rsUsuarios.getString("PhoneNumber");
				score = rsUsuarios.getDouble("Score");
				nSoccer = rsUsuarios.getInt("nSoccer");
				nBasketball = rsUsuarios.getInt("nBasketball");
				nVoleyball = rsUsuarios.getInt("nVoleyball");
				nTennis = rsUsuarios.getInt("nTennis");
				nPaintball = rsUsuarios.getInt("nPaintball");
				nVideogames = rsUsuarios.getInt("nVideogames");
				nKarts = rsUsuarios.getInt("nKarts");
				nVictories = rsUsuarios.getInt("nVictories");
				nLoses = rsUsuarios.getInt("nLoses");
				Up = new UserProfile(phoneNumber,score,nSoccer,nBasketball,nVoleyball,nTennis,nPaintball,nVideogames,nKarts,nVictories,nLoses);
				userId = rsUsuarios.getInt("idUser");
				userName = rsUsuarios.getString("UserName");
				
				//Inicializar el usuario 
				U = new User (userId, userName, Up);
				//Agregar el usuario a la estructura principal
				spartan.getActiveUsers().put(userId, U);
				//Agregar las asistencias a eventos publicos 
				U.setPublicEvents(getAllPublicEventsFromUser(U.getUserId()));
				
				
				//Carga los torneos grupales del usuario 
				
				/*
				//Carga los torneos individuales del usuario 
				ArrayList <SoloTournament> soloTournamentUser = this.loadUserSoloTournaments(U.getUserId());
				for (int i = 0; i < soloTournamentUser.size(); i++)
				{
					U.getMyTournaments().add(soloTournamentUser.get(i));
					spartan.getSoloTournaments().put(soloTournamentUser.get(i).getIdTournament(), soloTournamentUser.get(i));
				}*/
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void loadEvents()
	{
		Set <Integer> keys = spartan.getActiveUsers().keySet();
		User U = null;
		for(Integer key: keys)
		{
			U = spartan.getActiveUsers().get(key);
			ArrayList<RegularEvent> eventos = getAllEventByUser(U.getUserId());
			U.setMyCurrentEvents(eventos);
			for (int i = 0; i < eventos.size(); i++ )
			{
				RegularEvent e = eventos.get(i);
				spartan.getCurrentEvents().put(e.getIdEvent(), e);
			}
        }
	}
	
	public void loadSpots()
	{
		Set <Integer> keys = spartan.getActiveUsers().keySet();
		User U = null;
		for(Integer key: keys)
		{
			U = spartan.getActiveUsers().get(key);
			loadUserSpots(U.getUserId());
		}	

	}
	
	public void loadTeamMembers()
	{
		Set <Integer> keys = spartan.getActiveUsers().keySet();
		User U = null;
		for(Integer key: keys)
		{
			U = spartan.getActiveUsers().get(key);
			U.setMyTeams(getUserTeams(U.getUserId()));
		}	
	}
	
	public void loadGroupTournaments()
	{
		Set <Integer> keys = spartan.getActiveUsers().keySet();
		User U = null;
		for(Integer key: keys)
		{
			U = spartan.getActiveUsers().get(key);
			ArrayList <GroupTournament> groupTournamentsUser = this.loadUserGroupTournaments(U.getUserId());
			for (int i = 0; i < groupTournamentsUser.size(); i++)
			{
				U.getMyTournaments().add(groupTournamentsUser.get(i));
				spartan.getGroupTournaments().put(groupTournamentsUser.get(i).getIdTournament(), groupTournamentsUser.get(i));
			}
		}
	}
	
	public void loadSingleTournaments()
	{
		Set <Integer> keys = spartan.getActiveUsers().keySet();
		User U = null;
		for(Integer key: keys)
		{
			U = spartan.getActiveUsers().get(key);
			
			ArrayList <SoloTournament> soloTournamentUser = this.loadUserSoloTournaments(U.getUserId());
			for (int i = 0; i < soloTournamentUser.size(); i++)
			{
				U.getMyTournaments().add(soloTournamentUser.get(i));
				spartan.getSoloTournaments().put(soloTournamentUser.get(i).getIdTournament(), soloTournamentUser.get(i));
			}
		}
	}
	/**
	 * Retorna una lista con la lista de eventos publicos a los que asiste un usuario 
	 * @param idUser - Es el id del usuario 
	 * @return Lista con los eventos publicos a los que asiste un usuario 
	 */
	public ArrayList <PublicEvent> getAllPublicEventsFromUser(int idUser)
	{
		ArrayList <PublicEvent> ans = new ArrayList <PublicEvent>();
		String query = "SELECT * FROM Spartan.EventAssistence WHERE idUserEvent = " + idUser + ";";
		ResultSet rsPublic;
		DBService myService = new DBService();
		try 
		{
			rsPublic = myService.sendQueryToDB(query);
			PublicEvent Pu ;
			int idPublicEvent; 
			while (rsPublic.next()) 
			{
				idPublicEvent = rsPublic.getInt("idPublicEvent");
				Pu = spartan.getPublicCatalog().get(idPublicEvent);
				ans.add(Pu);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			myService.close();
			myService = null;
		}
		return ans;
	}
	
	/**
	 * Retorna una lista con todos los eventos creados por un usuario 
	 * @param idUser - Es el id del usuario  
	 * @return Lista con los eventos creados por el usuario 
	 */
	public ArrayList <RegularEvent> getAllEventByUser(int idUser)
	{
		DBService myService = new DBService();
		ArrayList <RegularEvent> ans = new ArrayList <RegularEvent>();
		String query = "SELECT * FROM Spartan.Events WHERE idEventAuthor = " + idUser + ";";
		ResultSet rs;
		RegularEvent Re;
		
		int idEvent;
		String date;
		String state;
		String place;
		String details;
		int spots;
		String eventKey;
		String sport;
		String description;
		
		try
		{
			rs = myService.sendQueryToDB(query);
			while(rs.next())
			{
				idEvent = rs.getInt("idEvent");
				date = rs.getString("Date");
				state = rs.getString("State");
				place = rs.getString("Place");
				details = rs.getString("Details");
				spots = rs.getInt("Spots");
				eventKey = rs.getString("Key");
				sport = rs.getString("Sport");
				description = rs.getString("Description");
				Re = new RegularEvent(idEvent, date, state, place, details, spots, eventKey, sport, description);
				ans.add(Re);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			myService.close();
			myService = null;
		}
		return ans;
		
	}
		
	/**
	 * Carga los spots del usuario 
	 * @param idUser - Es el id del usuario 
	 */
	public void loadUserSpots(int idUser)
	{
		String query = "SELECT * FROM Spartan.Spots WHERE idParticipant = " + idUser + ";";
		DBService myService = new DBService();
		ResultSet rs;
		try 
		{
			rs = myService.sendQueryToDB(query);
			int idEvent; 
			String confirmation; 
			Spot S; 
			while (rs.next()) 
			{
				idEvent = rs.getInt("idEvent");
				confirmation = rs.getString("Confirmation");
				S = new Spot(confirmation);
				spartan.getActiveUsers().get(idUser).getCurrentSpots().add(S);
				spartan.getCurrentEvents().get(idEvent).getAvailableSpots().add(S);
			}
			myService.close();
			myService = null;
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Carga los equipos 
	 * Agrega el capitan
	 * Agrega los miembros del equipo 
	 */
	public void loadTeams()
	{
		String query = "SELECT * FROM Spartan.Teams";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			int idTeam;
			String teamName;
			int idCaptain;
			Team T; 
			
			User Captain;
			
			while (rs.next()) 
			{
				idTeam = rs.getInt("idTeam");
				teamName = rs.getString("TeamName");
				idCaptain = rs.getInt("idCaptain");
				Captain = spartan.getActiveUsers().get(idCaptain);
				T = new Team(idTeam, teamName, Captain);
				T.setMiembros(getTeamMembers(idTeam));
				spartan.getRegisteredTeams().put(idTeam, T);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	/**
	 * Retorna una lista con los miembros de un equipo
	 * @param idTeam - Identificador del equipo
	 * @return Lista con los miembros del equipo
	 */
	public Hashtable <Integer, User> getTeamMembers(int idTeam)
	{
		Hashtable <Integer, User> ans = new Hashtable<Integer, User>();
		String query = "SELECT * FROM Spartan.TeamMembers WHERE TeamId = " + idTeam + ";";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			int idUser; 
			User U; 
			while (rs.next()) 
			{
				idUser = rs.getInt("idMember");
				U = spartan.getActiveUsers().get(idUser);
				ans.put(U.getUserId(), U);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	/**
	 * Retorna una lista con los equipos a los que pertenece un usuario 
	 * @param userId - Es el identificador del usuario 
	 * @return Lista con los equipos a los que pertenece un usuario 
	 */
	public ArrayList <Team> getUserTeams(int userId)
	{
		ArrayList <Team> ans = new ArrayList<Team>();
		String query = "SELECT * FROM Spartan.TeamMembers WHERE idMember = " + userId + ";";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			int idTeam; 
			while (rs.next()) 
			{
				idTeam = rs.getInt("TeamId");
				Team T = spartan.getRegisteredTeams().get(idTeam);
				ans.add(T);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	/**
	 * Retorna una lista con los torneos grupales organizados por un usuario 
	 * @param idUser - Id del usuario 
	 * @return Lista con los torneos organizados por el usuario 
	 */
	public ArrayList <GroupTournament> loadUserGroupTournaments(int idUser)
	{
		ArrayList <GroupTournament>ans = new ArrayList <GroupTournament>();
		DBService myService = new DBService();
		String query = "SELECT * FROM Spartan.GroupTournaments WHERE idOrganizerGroup = " + idUser + ";";
		try 
		{
			ResultSet rs = myService.sendQueryToDB(query);
			GroupTournament Gt;
			User organizer = spartan.getActiveUsers().get(idUser);
			int idTorneo;
			String name;
			String description;
			String sport;
			String state;
			int nParticipants;
			while (rs.next()) 
			{
				idTorneo = rs.getInt("idTournament");
				name = rs.getString("Name");
				description = rs.getString("Description");
				sport = rs.getString("Sport");
				state = rs.getString("State");
				nParticipants = rs.getInt("nParticipants");
				Gt = new GroupTournament(idTorneo,name,description,sport,state, organizer,nParticipants);
				Gt.setParticipants(this.loadParticipantGroupsInTournament(idTorneo));
				Gt.setTournamentEvents(this.loadGroupTournamentEvents(idTorneo));
				ans.add(Gt);
			}
			myService.close();
			myService = null;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		

		return ans;
	}
	
	/**
	 * Retorna una lista con los participantes de un torneo grupal 
	 * @param idTournament - Identificador del torneo  
	 * @return Lista con los participantes de un torneo 
	 */
	public ArrayList <Team> loadParticipantGroupsInTournament(int idTournament)
	{
		ArrayList <Team> ans = new ArrayList<Team>();
		String query = "SELECT * FROM Spartan.ParticipantGroups WHERE idGroupTournament = " + idTournament + ";";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			int idTeam; 
			Team T; 
			while (rs.next()) 
			{
				idTeam = rs.getInt("idParticipantTeam");
				T = spartan.getRegisteredTeams().get(idTeam);
				ans.add(T);
			}	
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	/**
	 * Retorna una lista con los eventos de un torneo grupal 
	 * @param idTournament - Identificador del torneo
	 * @return Lista con eventos de un torneo grupal
	 */
	public ArrayList <GroupEvent> loadGroupTournamentEvents(int idTournament)
	{
		ArrayList <GroupEvent> ans = new ArrayList <GroupEvent>();
		String query = "SELECT * FROM Spartan.GroupTournamentEvents WHERE idGroupTournament = " + idTournament + "";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			GroupEvent Ge;
			int idEvent;
			String date;
			String state;
			String place;
			String details;
			int spots;
			String key;
			while (rs.next()) 
			{
				idEvent = rs.getInt("idGroupEvent");
				date = rs.getString("Date");
				state = rs.getString("State");
				place = rs.getString("Place");
				details = rs.getString("Details");
				spots = rs.getInt("nSpots");
				key = rs.getString("Key");
				Ge = new GroupEvent(idEvent, date, state, place, details, spots, key);
				Ge.setParticipantTeams(loadTeamsInGroupEvent(idEvent));
				ans.add(Ge);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return ans;
	}

	/**
	 * Retorna una lista con los equipos que compiten en una competencia
	 * @param idEvent - Id del evento 
	 * @return Lista con los equipos que compiten en la competencia
	 */
	public ArrayList <Team> loadTeamsInGroupEvent(int idEvent)
	{
		ArrayList <Team> ans = new ArrayList <Team>();
		String query = "SELECT * FROM Spartan.GroupTournamentParticipants WHERE idGroupEvent = " + idEvent + ";";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			int idTeam;
			Team T;
			while (rs.next()) 
			{
				idTeam = rs.getInt("idParticipantTeam");
				T = spartan.getRegisteredTeams().get(idTeam);
				ans.add(T);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	//Solo
	
	/**
	 * Retorna una lista con los torneos solo organizados por un usuario 
	 * @param idUser - Id del usuario 
	 * @return Lista con los torneos organizados por el usuario 
	 */
	public ArrayList <SoloTournament> loadUserSoloTournaments(int idUser)
	{
		ArrayList <SoloTournament>ans = new ArrayList <SoloTournament>();
		String query = "SELECT * FROM Spartan.SoloTournament WHERE idOrganizerSolo = " + idUser + ";";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			SoloTournament St;
			User organizer = spartan.getActiveUsers().get(idUser);
			int idTorneo;
			String name;
			String description;
			String sport;
			String state;
			int nParticipants;
			while (rs.next()) 
			{
				idTorneo = rs.getInt("idTournament");
				name = rs.getString("Name");
				description = rs.getString("Description");
				sport = rs.getString("Sport");
				state = rs.getString("State");
				nParticipants = rs.getInt("nParticipants");
				St = new SoloTournament(idTorneo,name,description,sport,state, organizer,nParticipants);
				St.setParticipants(this.loadParticipantSolosInTournament(idTorneo));
				St.setTournamentEvents(this.loadSingleTournamentEvents(idTorneo));
				ans.add(St);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return ans;
	}

	
	/**
	 * Retorna una lista con los participantes de un torneo individual 
	 * @param idTournament - Identificador del torneo  
	 * @return Lista con los participantes de un torneo 
	 */
	public ArrayList <User> loadParticipantSolosInTournament(int idTournament)
	{
		ArrayList <User> ans = new ArrayList<User>();
		String query = "SELECT * FROM Spartan.ParticipantsSolo WHERE idTournamentSolo = " + idTournament + ";";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			int idUser; 
			User U; 
			while (rs.next()) 
			{
				idUser = rs.getInt("idTournamentSolo");
				U = spartan.getActiveUsers().get(idUser);
				ans.add(U);
			}	
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ans;
	}
	
	
	/**
	 * Retorna una lista con los eventos de un torneo individual 
	 * @param idTournament - Identificador del torneo
	 * @return Lista con eventos de un torneo grupal
	 */
	public ArrayList <SingleEvent> loadSingleTournamentEvents(int idTournament)
	{
		ArrayList <SingleEvent> ans = new ArrayList <SingleEvent>();
		String query = "SELECT * FROM Spartan.SoloTournamentEvents WHERE idSoloTournament = " + idTournament + "";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			SingleEvent Se;
			int idEvent;
			String date;
			String state;
			String place;
			String details;
			int spots;
			String key;
			while (rs.next()) 
			{
				idEvent = rs.getInt("idSoloEvent");
				date = rs.getString("Date");
				state = rs.getString("State");
				place = rs.getString("Place");
				details = rs.getString("Details");
				spots = rs.getInt("nSpots");
				key = rs.getString("Key");
				Se = new SingleEvent(idEvent, date, state, place, details, spots, key);
				Se.setParticipants(this.loadUsersInSoloEvent(idEvent));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return ans;
	}
	
	/**
	 * Retorna una lista con los equipos (solo) que compiten en una competencia
	 * @param idEvent - Id del evento 
	 * @return Lista con los usuarios que compiten en la competencia
	 */
	public ArrayList <User> loadUsersInSoloEvent(int idEvent)
	{
		ArrayList <User> ans = new ArrayList <User>();
		String query = "SELECT * FROM Spartan.SoloEventParticipants WHERE idSoloEvent = " + idEvent + ";";
		try 
		{
			ResultSet rs = dbService.sendQueryToDB(query);
			int idUser;
			User U;
			while (rs.next()) 
			{
				idUser = rs.getInt("idSoloPart");
				U = spartan.getActiveUsers().get(idUser);
				ans.add(U);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ans;
	}
}
