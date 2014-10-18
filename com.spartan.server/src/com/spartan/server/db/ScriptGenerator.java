package com.spartan.server.db;


/**
 * Servicio para la generacion de scripts SQL 
 * @author hellspawn
 */
public class ScriptGenerator 
{	
	//------------------------------------------------------------------
	//Servicios de usuario 
	//------------------------------------------------------------------
	/**
	 * Retorna la Query para insertar a un nuevo usuario en la tabla Users
	 * @param userName - Es el nombre del usuario 
	 * @param phoneNumber - Es el numero de telefono 
	 * @param pass - Es la contraseña
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`Users` (`UserName`, `PhoneNumber`)VALUES ('userName' , 'phoneNumber');
	 * INSERT INTO `Spartan`.`Auth` (`idUserAuth`, `Password`) VALUES((SELECT idUser FROM `Spartan`.`Users` WHERE UserName = 'userName'), 'pass');
	 * INSERT INTO `Spartan`.`ScoreBoard` (`idUserBoard`, `Score`) VALUES((SELECT idUser FROM `Spartan`.`Users` WHERE UserName = 'userName') , 0.0);
	 * INSERT INTO `Spartan`.`History` (`idUserHistory`, `nSoccer`, `nBasketball`, `nVoleyball`, `nTennis`, `nPaintball`, `nVideogames`, `nKarts`, `nVictories`, `nLoses`) VALUES ((SELECT idUser FROM `Spartan`.`Users` WHERE UserName = 'userName'), 0, 0, 0, 0, 0, 0, 0, 0, 0);
	 * COMMIT;
	 */
	public String registerUser(String userName,  String phoneNumber, String pass)
	{	
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;"  + "\n" + 
				"INSERT INTO `Spartan`.`Users` (`UserName`, `PhoneNumber`)" + "VALUES ('" + userName + "' , '" + phoneNumber + "');" + "\n" + 
				"INSERT INTO `Spartan`.`Auth` (`idUserAuth`, `Password`) " +  "VALUES(" + "(SELECT idUser FROM `Spartan`.`Users` WHERE UserName = '" + userName + "')" + ", '" + pass + "');" + "\n" +
				"INSERT INTO `Spartan`.`ScoreBoard` (`idUserBoard`, `Score`) " + "VALUES(" + "(SELECT idUser FROM `Spartan`.`Users` WHERE UserName = '" + userName + "')" + " , " + 0.0 + ");" + "\n" +
				"INSERT INTO `Spartan`.`History` (`idUserHistory`, `nSoccer`, `nBasketball`, `nVoleyball`, `nTennis`, `nPaintball`, `nVideogames`, `nKarts`, `nVictories`, `nLoses`) " + "VALUES (" + "(SELECT idUser FROM `Spartan`.`Users` WHERE UserName = '" + userName + "')" + ", 0, 0, 0, 0, 0, 0, 0, 0, 0);" + "\n" +
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para obtener la contraseña de un usuario dado su identificador
	 * @param userId - Es el identificador del usuario
	 * @return Query ->
	 * SELECT Password FROM `Spartan`.`Auth` WHERE idUserAuth = Xx;
	 */
	public String getUserPassword(int userId)
	{
		String query = 
				"SELECT Password FROM `Spartan`.`Auth` WHERE idUserAuth = " + userId + ";";
		return query;
	}
	
	/**
	 * Retorna la Query para actualizar la contraseña de un usuario 
	 * @param userId - Es el id del usuario 
	 * @param nPassword - Es la nueva contraseña
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`; 
	 * UPDATE `Spartan`.`Auth`
	 * SET Password = 'nPassword'
	 * WHERE idUserAuth = Xx; 
	 * COMMIT;
	 */
	public String updateUserPassword(int userId, String nPassword)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`Auth`" +  "\n" + 
				"SET Password = " + "'" + nPassword + "'" + "\n" +  
				"WHERE idUserAuth = " + userId + ";" + "\n" +
				"COMMIT;"; 
		return query;
	}
	
	/**
	 * Genera la Query para actualizar el score de un usuario 
	 * @param userId - Es el id del usuario 
	 * @param nScore - Es el nuevo score 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`ScoreBoard`
	 * SET Score = nScore
	 * WHERE idUserBoard = userId;
	 * COMMIT;
	 */
	public String updateUserScore(int userId, double nScore)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`ScoreBoard`" +  "\n" + 
				"SET Score = " + nScore + "\n" + 
				"WHERE idUserBoard = "  + userId + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Genera la Query para actualizar el historial de juegos de un usuario 
	 * @param userId - Es el identificador de usuario
	 * @param nSoccer - Numero de partidos de soccer
	 * @param nBasketball - Numero de partidos de basket
	 * @param nVoleyball - Numero de partidos de voleyball 
	 * @param nTennis - Numero de partidos de tennis
	 * @param nPaintball - Numero de juegos de paintball
	 * @param nVideogames - Numero de encuentros de videojuegos 
	 * @param nKarts - Numero de juegos de karts 
	 * @param nVictories - Numero de victorias
	 * @param nLoses - Numero de derrotas
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`History`
	 * SET nSoccer = 1 , nBasketball = 0 , nVoleyball = 0 , nTennis = 0,nPaintball = 0 , nVideogames = 0 , nKarts = 0 , nVictories = 1 , nLoses = 0
	 * WHERE idUserHistory = Xx;
	 * COMMIT;
	 */
	public String updateHistory(int userId, int nSoccer, int nBasketball, int nVoleyball,int nTennis, int nPaintball, int nVideogames, int nKarts,int nVictories, int nLoses)
	{
		String query = 
				"START TRANSACTION;" +  "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`History`" +  "\n" +  
				"SET " + "nSoccer = " + nSoccer + " , " + "nBasketball = " + nBasketball + " , " + "nVoleyball = " + nVoleyball + " , " + "nTennis = " + nTennis + "," + "nPaintball = " + nPaintball + " , " + "nVideogames = " + nVideogames + " , " + "nKarts = " + nKarts + " , " + "nVictories = " + nVictories + " , " + "nLoses = " + nLoses + "\n" + 
				"WHERE idUserHistory = " +  userId + ";" + "\n" + 
				"COMMIT;"; 		
		return query;
	}
	
	//------------------------------------------------------------------
	//Servicios equipo
	//------------------------------------------------------------------

	//TODO changeTeamName(int idTeam, String nName)
	
	/**
	 * Retorna la Query para crear un nuevo equipo 
	 * @param teamName - Es el nombre del equipo 
	 * @param idCaptain - Es el identificador del capitan 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`Teams` (`TeamName`, `idCaptain`) VALUES('teamName', idCaptain);
	 * INSERT INTO `Spartan`.`TeamMembers` (`TeamId`, `idMember`) VALUES ((SELECT idTeam FROM `Spartan`.`Teams` WHERE TeamName = 'teamName' AND idCaptain = idCaptain) , idCaptain);
	 * COMMIT;
	 */
	public String registerTeam(String teamName, int idCaptain)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`Teams` (`TeamName`, `idCaptain`) VALUES('" + teamName + "', " + idCaptain + ");" + "\n" + 
				"INSERT INTO `Spartan`.`TeamMembers` (`TeamId`, `idMember`) VALUES (" + "(SELECT idTeam FROM `Spartan`.`Teams` WHERE TeamName = '" + teamName + "' AND idCaptain = " + idCaptain + ")" + " , "  + idCaptain + ");" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para registrar un usuario en un equipo 
	 * @param teamId - Identificador del equipo 
	 * @param idUser - Identificador del usuario 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`TeamMembers` (`TeamId`, `idMember`) VALUES (teamId , idUser);
	 * COMMIT;
	 */
	public String registerUserInTeam(int teamId, int idUser)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`TeamMembers` (`TeamId`, `idMember`) VALUES (" + teamId + " , "  + idUser + ");" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para cambiar el capitan de un equipo 
	 * @param teamId - Es el identificador del equipo
	 * @param nCaptain - Es el identificador del nuevo capitan 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`Teams`
	 * SET idCaptain = nCaptain
	 * WHERE idTeam = teamId;
	 * COMMIT;
	 */
	public String changeTeamLeader(int teamId, int nCaptain)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`Teams`" + "\n" + 
				"SET idCaptain = " + nCaptain + "\n" + 
				"WHERE idTeam = " + teamId + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para verificar si un usuario existe o no en un equipo
	 * @param teamId - Es el identificador del equipo
	 * @param idUser - Es el identificador del usuario 
	 * @return Query ->
	 * SELECT * FROM `Spartan`.`TeamMembers` WHERE TeamId = teamId AND idMember = idUser;
	 */
	public String getUserInTeam(int teamId, int idUser)
	{
		String query = 
				"SELECT * FROM `Spartan`.`TeamMembers` WHERE TeamId = " + teamId + " AND idMember = " + idUser + ";";
		return query;
	}
	
	/**
	 * Retorna la Query para consultar todos los usuarios que pertenecen a un mismo equipo 
	 * @param teamId - Es el identificador del equipo 
	 * @return Query ->
	 * SELECT * FROM `Spartan`.`TeamMembers` WHERE TeamId = teamId;
	 */
	public String getAllUsersInTeam(int teamId)
	{
		String query = 
				"SELECT idMember FROM `Spartan`.`TeamMembers` WHERE TeamId = " + teamId + ";";
		return query;
	}
	
	/**
	 * Retorna la Query para consultar todos los equipos a los que pertenece un usuario 
	 * @param userId - Es el identificador del usuario 
	 * @return Query ->
	 * SELECT TeamId FROM `Spartan`.`TeamMembers` WHERE idMember = userId;
	 */
	public String getAllTeamsUser(int userId)
	{
		String query = 
				"SELECT TeamId FROM `Spartan`.`TeamMembers` WHERE idMember = " + userId + ";";
		return query;
	}
	
	/**
	 * Retorna la Query para remover a un usuario de un equipo 
	 * @param teamId - Es el identificador del equipo 
	 * @param userId - Es el identificador del usuario 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`TeamMembers` 
	 * WHERE idMember = userId AND TeamId = teamId;
	 * COMMIT;
	 */
	public String removeUserFromTeam(int teamId, int userId)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`TeamMembers`" + "\n" + 
				"WHERE idMember = " + userId + " AND TeamId = " + teamId + " ;" + "\n" +  
				"COMMIT;";
		return query;
	}
	
	//------------------------------------------------------------------
	//Servicios evento 
	//------------------------------------------------------------------

	/**
	 * Retorna la query para crear un nuevo evento 
	 * @param sport - Es el deporte a jugar 
	 * @param description - Es la descripcion del deporte
	 * @param date - Es la fecha 
	 * @param eventAuthor - Es el id del autor
	 * @param availableSpots - Es el numero de lugares
	 * @param state - Es el estado del evento 
	 * @param place - Coordenadas del evento 
	 * @param key - Es la clave del evento 
	 * @param details - Detalles adicionales 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`Events` (`Sport`, `Description`, `Date`, `idEventAuthor`, `Spots`, `State`, `Place`, `Key`, `Details`) VALUES ('sport' , 'description' , 'date' , eventAuthor, availableSpots, 'state' , 'place', 'key', 'details');
	 * COMMIT;
	 */
	public String createEvent(String sport, String description, String date, int eventAuthor, int availableSpots, String state, String place, String key, String details)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`Events` (`Sport`, `Description`, `Date`, `idEventAuthor`, `Spots`, `State`, `Place`, `Key`, `Details`) VALUES ('" + sport + "' , '" +  description + "' , '" + date + "' , " + eventAuthor + ", " + availableSpots + ", '" + state + "' , '" + place + "', '" + key + "', '" + details + "');" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para obtener todos los eventos creados por un usuario 
	 * @param userId - Es el id del autor
	 * @return Query ->
	 * SELECT * FROM `Spartan`.`Events` WHERE idEventAuthor = userId;
	 */
	public String getAllEventsFromUser(int userId)
	{
		String query = 
				"SELECT * FROM `Spartan`.`Events` WHERE idEventAuthor = " + userId + ";";
		return query; 
	}
	
	/**
	 * Retorna la Query para obtener todos los eventos que correspondan a un deporte
	 * @param sport - Deporte 
	 * @return Query ->
	 * SELECT * FROM `Spartan`.`Events` WHERE Sport = 'sport' AND Spots > 0;
	 */
	public String getAllEventsSearch(String sport)
	{
		String query = 
				"SELECT * FROM `Spartan`.`Events` WHERE Sport = '" + sport + "' AND Spots > 0;";
		return query;
	}
	
	/**
	 * Genera la Query para reservar un Spot y crear el spot reservado de un usuario 
	 * @param eventId - Es el id del evento 
	 * @param userId - Es el id del usuario 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`Events`
	 * SET Spots = Spots - 1
	 * WHERE idEvent = 1;
	 * INSERT INTO `Spartan`.`Spots` (`idEvent`, `idParticipant`, `Confirmation`) VALUES (eventId, userId, 'ToAssist');
	 * COMMIT;
	 */
	public String reserveSpotInEvent(int eventId, int userId)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`Events`" + "\n" +
				"SET Spots = Spots - 1" + "\n" + 
				"WHERE idEvent = " + eventId + ";" + "\n" + 
				"INSERT INTO `Spartan`.`Spots` (`idEvent`, `idParticipant`, `Confirmation`) VALUES (" + eventId + ", " + userId + ", 'ToAssist');" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para actualizar el numero de spots en un evento 
	 * @param eventId - Id del evento 
	 * @param nSpots - Lugares 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`Events`
	 * SET Spots = Spots + nSpots
	 * WHERE idEvent = eventId;
	 * "COMMIT;"
	 */
	public String upgradeAvailableSpots(int eventId, int nSpots)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`Events`" + "\n" +
				"SET Spots = Spots + " + nSpots + "\n" + 
				"WHERE idEvent = " + eventId + ";" + "\n" +
				"COMMIT;";
		return query;
	}
	
	public String updateEventDate(int eventId, String nDate)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`Events`" + "\n" +
				"SET Date = " + nDate +  "\n" + 
				"WHERE idEvent = " + eventId + ";" + "\n" +
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para cancelar una reservacion en un evento 
	 * @param eventId - Es el id del evento 
	 * @param userId - Es el id del usuario 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`Spots`
	 * WHERE idEvent = eventId AND idParticipant = userId;
	 * UPDATE `Spartan`.`Events`
	 * SET Spots = Spots + 1
	 * WHERE idEvent = eventId;
	 * COMMIT;
	 */
	public String cancelSpotInEvent(int eventId, int userId)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`Spots`" + "\n"+ 
				"WHERE idEvent = " + eventId + " AND idParticipant = " + userId + ";" + "\n" +
				"UPDATE `Spartan`.`Events`" + "\n" +
				"SET Spots = Spots + 1" + "\n" + 
				"WHERE idEvent = " + eventId + ";" + "\n" +
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para cancelar un evento y borrar los spots reservados para ese evento 
	 * @param eventId - Identificador del evento 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`Spots`
	 * WHERE idEvent = eventId;
	 * DELETE FROM `Spartan`.`Events`
	 * WHERE idEvent = eventId;
	 * COMMIT;
	 */
	public String cancelEvent(int eventId)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`Spots`" + "\n" + 
				"WHERE idEvent = " + eventId + ";" + "\n" + 
				"DELETE FROM `Spartan`.`Events`" + "\n" + 
				"WHERE idEvent = " + eventId + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Genera la Query para cambiar la confirmacion de un evento 
	 * @param eventId - Es el id del evento 
	 * @param idUser - Es el id del usuario 
	 * @param confirmation - Estado de la confirmacion 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`Spots`SET Confirmation = 'confirmation'
	 * WHERE idEvent = eventId AND idParticipant = idUser;
	 * COMMIT;
	 */
	public String updateSpotConfirmation(int eventId, int idUser, String confirmation)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`Spots`" + "\n" +
				"SET Confirmation = '" + confirmation + "'" + "\n" + 
				"WHERE idEvent = " + eventId + " AND idParticipant = " + idUser + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para consultar el catalogo publico de eventos 
	 * @return Query -> 
	 * SELECT * FROM `Spartan`.`PublicEvents`
	 */
	public String getPublicEventCatalog()
	{
		String query = 
				"SELECT * FROM `Spartan`.`PublicEvents`;";
		return query;
	}
	
	/**
	 * Retorna la Query para registrar un usuario en un evento del catalogo publico 
	 * @param publicEventId - Es el identificador del evento  
	 * @param userId - Es el identificador del usuario 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`EventAssistence` (`idPublicEvent`, `idUserEvent`, `State`) VALUES (1 , 2, 'ToAssist');
	 * COMMIT;
	 */
	public String registerPublicEventAssistence(int publicEventId, int userId)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`EventAssistence` (`idPublicEvent`, `idUserEvent`, `State`) VALUES (" + publicEventId + " , " + userId + ", 'ToAssist');" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para cancelar la asistencia a un evento publico de un usuario
	 * @param eventId - Es el id del evento 
	 * @param userId - Es el id del usuario 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`EventAssistence`
	 * WHERE idPublicEvent = 1 AND idUserEvent = 2 ;
	 * COMMIT;
	 */
	public String cancelPublicEvent(int eventId, int userId)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`EventAssistence`" + "\n" + 
				"WHERE idPublicEvent = " + eventId + " AND idUserEvent = " + userId + " ;" + "\n" +  
				"COMMIT;";		
		return query;
	}
	
	/**
	 * Retorna la Query para actualizar el estado de una asistencia 
	 * @param eventId - Es el identificador del evento 
	 * @param userId - Es el identificador del usuario 
	 * @param nState - Es el estado de la asistencia
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`EventAssistence`
	 * SET State = 'Ola ke asse'
	 * WHERE idPublicEvent = 1 AND idUserEvent = 1;
	 * COMMIT;
	 */
	public String updatePublicEventState(int eventId, int userId, String nState)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`EventAssistence`" + "\n" +
				"SET State = '" + nState + "'" + "\n" + 
				"WHERE idPublicEvent = " + eventId + " AND idUserEvent = " + userId + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	//------------------------------------------------------------------
	//Servicios torneo grupal
	//------------------------------------------------------------------

	/**
	 * Retorna la Query para crear un torneo grupal 
	 * @param name - Nombre del torneo 
	 * @param description - Descripcion del torneo 
	 * @param sport - Deporte 
	 * @param state - Estado  
	 * @param idOrganizer - Organizador
	 * @param nParticipants - Numero de participantes 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`GroupTournament` (`Name`, `Description`, `Sport`, `State`, `idOrganizerSolo`, `nParticipants`) VALUES ('Ola ke ase' , 'Sexy torneo' , 'Soccer', 'Open' , 1 , 5);
	 * COMMIT;
	 */
	public String createGroupTournament(String name, String description, String sport, String state, int idOrganizer, int nParticipants)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`GroupTournaments` (`Name`, `Description`, `Sport`, `State`, `idOrganizerGroup`, `nParticipants`) VALUES ('" + name + "' , '" + description + "' , '" + sport + "', '" + state + "' , " +  idOrganizer + " , " + nParticipants + ");" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para eliminar un torneo de la base de datos 
	 * @param idTorneo - Es el identificador del torneo
	 * @param idOrganizador - Es el identificador del organizador
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`GroupTournamentParticipants` WHERE idGroupEvent = (SELECT idGroupEvent FROM `Spartan`.`GroupTournamentEvents` WHERE idGroupTournament = 1);
	 * DELETE FROM `Spartan`.`ParticipantGroups` WHERE idGroupTournament = 1;
	 * DELETE FROM `Spartan`.`GroupTournamentEvents` WHERE idGroupTournament = 1;
	 * DELETE FROM `Spartan`.`GroupTournaments` WHERE idTournament = 1;
	 * COMMIT;
	 */
	public String cancelGroupTournament(int idTorneo, int idOrganizador)
	{
		String subQuery = "(SELECT idGroupEvent FROM `Spartan`.`GroupTournamentEvents` WHERE idGroupTournament = " + idTorneo + ")";
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`GroupTournamentParticipants` WHERE idGroupEvent = "  + subQuery + ";" + "\n" +
				"DELETE FROM `Spartan`.`ParticipantGroups` WHERE idGroupTournament = " + idTorneo + ";" + "\n" + 
				"DELETE FROM `Spartan`.`GroupTournamentEvents` WHERE idGroupTournament = " + idTorneo + ";" + "\n" + 
				"DELETE FROM `Spartan`.`GroupTournaments` WHERE idTournament = " + idTorneo + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para registrar un participante en un torneo 
	 * @param idTorneo - Id del torneo 
	 * @param idEquipo - Id del equipo
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`ParticipantGroups` (`ParticipantGroups`, `ParticipantGroups`, `State`, `Position`) VALUES (1 , 2 ,  'In', 0);
	 * COMMIT;
	 */
	public String registerTeamInTournament(int idTorneo, int idEquipo)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`ParticipantGroups` (`ParticipantGroups`, `idParticipantTeam`, `State`, `Position`) VALUES (" + idTorneo + " , " + idEquipo + " ,  'In', 0);" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para eliminar un participante de un torneo grupal 
	 * @param idTorneo - Es el id del torneo
	 * @param idEquipo - Id del equipo 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`GroupTournamentParticipants` WHERE idParticipantTeam = 1;
	 * DELETE FROM `Spartan`.`ParticipantGroups` WHERE idGroupTournament = 2 AND idParticipantTeam = 1;
	 * COMMIT;
	 */
	public String removeTeamFromTournament(int idTorneo, int idEquipo)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`GroupTournamentParticipants` WHERE idParticipantTeam = " + idEquipo + ";" + "\n" +
				"DELETE FROM `Spartan`.`ParticipantGroups` WHERE idGroupTournament = " + idTorneo + " AND idParticipantTeam = " + idEquipo + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la query para actualizar los datos de un participante en un torneo 
	 * @param idTournament - Id del torneo 
	 * @param idEquipo - Id del equipo
	 * @param nState - Estado 
	 * @param nPosition - Posicion en el torneo 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`ParticipantGroups`
	 * SET State = 'Ola ke ase' , Position = 14
	 * WHERE idGroupTournament = 1 AND idParticipantTeam = 1;
	 * COMMIT;
	 */
	public String updateTeamInTournament(int idTournament, int idEquipo, String nState, int nPosition)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`ParticipantGroups`" +  "\n" + 
				"SET State = '" + nState + "' , Position = " + nPosition +  "\n" + 
				"WHERE idGroupTournament = " + idTournament + " AND idParticipantTeam = " + idEquipo + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/** 
	 * Retorna la Query para registrar un evento en un torneo 
	 * @param idTorneo - Id del torneo 
	 * @param date - Fecha del evento 
	 * @param state - Estado 
	 * @param place - Lugar 
	 * @param details - Detalles adicionales
	 * @param nSpots - Lugares dispo
	 * @param key - Llave del evento 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`SoloTournamentEvents` (`idSoloTournament`, `Date`, `State`, `Place`, `Details`, `nSpots`, `Key`) VALUES (1, 'xx', 'yy', 'xy', 'Ola ke ase', 10, '2312');
	 * COMMIT;
	 */
	public String registerGroupTournamentEvent(int idTorneo, String date, String state, String place, String details, int nSpots, String key)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`GroupTournamentEvents` (`idGroupTournament`, `Date`, `State`, `Place`, `Details`, `nSpots`, `Key`) VALUES (" + idTorneo + ", '" + date + "', '" + state + "', '" + place + "', '" + details + "', " + nSpots + ", '" + key + "');" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para registrar un equipo en un evento de torneo
	 * @param idEquipo - Id del equipo
	 * @param idEvento - Id del torneo 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`GroupTournamentParticipants` (`idGroupEvent`, `idParticipantTeam`) VALUES (1 , 3);
	 * COMMIT;
	 */
	public String registerTeamInGroupTournamentEvent(int idEquipo, int idEvento)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`GroupTournamentParticipants` (`idGroupEvent`, `idParticipantTeam`) VALUES (" + idEvento + " , " + idEquipo + ");" + "\n" +
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para actualizar el numero de lugares disponibles en un evento de torneo 
	 * @param idEvent - Id del evento 
	 * @param idTorneo - Id del torneo 
	 * @param nSpots - Numero de lugares a aumentar 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`SoloTournamentEvents`
	 * SET nSpots = nSpots + 3
	 * WHERE idSoloEvent = 1 AND idSoloTournament = 1;
	 * COMMIT;
	 */
	public String updateGroupTournamentEventSpots(int idEvent, int idTorneo, int nSpots)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`GroupTournamentEvents`" + "\n" +
				"SET nSpots = nSpots + " + nSpots + "\n" + 
				"WHERE idGroupEvent = " + idEvent + " AND idGroupTournament = " + idTorneo  + ";" + "\n" +
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para cancelar un evento grupal  
	 * @param idEvent - Es el id del evento 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`GroupTournamentParticipants`
	 * WHERE idGroupEvent = 1 ;
	 * DELETE FROM `Spartan`.`GroupTournamentEvents`
	 * WHERE idGroupEvent = 1 ;
	 * COMMIT;
	 */
	public String cancelGroupTournamentEvent(int idEvent)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`GroupTournamentParticipants`" + "\n" + 
				"WHERE idGroupEvent = " + idEvent +" ;" + "\n" +  
				"DELETE FROM `Spartan`.`GroupTournamentEvents`" + "\n" + 
				"WHERE idGroupEvent = " + idEvent + " ;" + "\n" +  
				"COMMIT;";
		return query;
	}
	
	//------------------------------------------------------------------
	//Servicios torneo individual
	//------------------------------------------------------------------

	/**
	 * Retorna la Query para crear un torneo individual 
	 * @param name - Nombre del torneo 
	 * @param description - Descripcion del torneo 
	 * @param sport - Deporte 
	 * @param state - Estado  
	 * @param idOrganizer - Organizador
	 * @param nParticipants - Numero de participantes 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`SoloTournament` (`Name`, `Description`, `Sport`, `State`, `idOrganizerSolo`, `nParticipants`) VALUES ('Ola ke ase' , 'Sexy torneo' , 'Soccer', 'Open' , 1 , 5);
	 * COMMIT;
	 */
	public String createSingleTournament(String name, String description, String sport, String state, int idOrganizer, int nParticipants)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`SoloTournament` (`Name`, `Description`, `Sport`, `State`, `idOrganizerSolo`, `nParticipants`) VALUES ('" + name + "' , '" + description + "' , '" + sport + "', '" + state + "' , " +  idOrganizer + " , " + nParticipants + ");" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para eliminar un torneo de la base de datos 
	 * @param idTorneo - Es el identificador del torneo
	 * @param idOrganizador - Es el identificador del organizador
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`GroupTournamentParticipants` WHERE idGroupEvent = (SELECT idGroupEvent FROM `Spartan`.`GroupTournamentEvents` WHERE idGroupTournament = 1);
	 * DELETE FROM `Spartan`.`ParticipantGroups` WHERE idGroupTournament = 1;
	 * DELETE FROM `Spartan`.`GroupTournamentEvents` WHERE idGroupTournament = 1;
	 * DELETE FROM `Spartan`.`GroupTournaments` WHERE idTournament = 1;
	 * COMMIT;
	 */
	public String cancelSoloTournament(int idTorneo, int idOrganizador)
	{
		String subQuery = "(SELECT idSoloEvent FROM `Spartan`.`SoloTournamentEvents` WHERE idSoloTournament = " + idTorneo + ")";
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`SoloEventParticipants` WHERE idSoloEvent = "  + subQuery + ";" + "\n" +
				"DELETE FROM `Spartan`.`ParticipantsSolo` WHERE idTournamentSolo = " + idTorneo + ";" + "\n" + 
				"DELETE FROM `Spartan`.`SoloTournamentEvents` WHERE idSoloTournament = " + idTorneo + ";" + "\n" + 
				"DELETE FROM `Spartan`.`SoloTournament` WHERE idTournament = " + idTorneo + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para registrar un participante en un torneo 
	 * @param idTorneo - Id del torneo 
	 * @param idEquipo - Id del equipo
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`ParticipantsSolo` (`idSoloParticipant`, `idTournamentSolo`, `State`, `Position`) VALUES (1 , 2 ,  'In', 0);
	 * COMMIT;
	 */
	public String registerSoloInTournament(int idTorneo, int idSolo)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`ParticipantsSolo` (`idSoloParticipant`, `idTournamentSolo`, `State`, `Position`) VALUES (" + idSolo + " , " + idTorneo + " ,  'In', 0);" + "\n" + 
				"COMMIT;";
		return query;
	}

	/**
	 * Retorna la Query para eliminar un participante de un torneo solo 
	 * @param idTorneo - Es el id del torneo
	 * @param idEquipo - Id del equipo 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`GroupTournamentParticipants` WHERE idParticipantTeam = 1;
	 * DELETE FROM `Spartan`.`ParticipantGroups` WHERE idGroupTournament = 2 AND idParticipantTeam = 1;
	 * COMMIT;
	 */
	public String removeSoloFromTournament(int idTorneo, int idEquipo)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`SoloEventParticipants` WHERE idSoloPart = " + idEquipo + ";" + "\n" +
				"DELETE FROM `Spartan`.`ParticipantsSolo` WHERE idTournamentSolo = " + idTorneo + " AND idSoloParticipant = " + idEquipo + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la query para actualizar los datos de un participante en un torneo 
	 * @param idTournament - Id del torneo 
	 * @param idEquipo - Id del equipo
	 * @param nState - Estado 
	 * @param nPosition - Posicion en el torneo 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`ParticipantGroups`
	 * SET State = 'Ola ke ase' , Position = 14
	 * WHERE idGroupTournament = 1 AND idParticipantTeam = 1;
	 * COMMIT;
	 */
	public String updateSoloInTournament(int idTournament, int idSolo, String nState, int nPosition)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`ParticipantsSolo`" +  "\n" + 
				"SET State = '" + nState + "' , Position = " + nPosition +  "\n" + 
				"WHERE idTournamentSolo = " + idTournament + " AND idSoloParticipant = " + idSolo + ";" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/** 
	 * Retorna la Query para registrar un evento en un torneo 
	 * @param idTorneo - Id del torneo 
	 * @param date - Fecha del evento 
	 * @param state - Estado 
	 * @param place - Lugar 
	 * @param details - Detalles adicionales
	 * @param nSpots - Lugares dispo
	 * @param key - Llave del evento 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`SoloTournamentEvents` (`idSoloTournament`, `Date`, `State`, `Place`, `Details`, `nSpots`, `Key`) VALUES (1, 'xx', 'yy', 'xy', 'Ola ke ase', 10, '2312');
	 * COMMIT;
	 */
	public String registerSoloTournamentEvent(int idTorneo, String date, String state, String place, String details, int nSpots, String key)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`SoloTournamentEvents` (`idSoloTournament`, `Date`, `State`, `Place`, `Details`, `nSpots`, `Key`) VALUES (" + idTorneo + ", '" + date + "', '" + state + "', '" + place + "', '" + details + "', " + nSpots + ", '" + key + "');" + "\n" + 
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para registrar un equipo en un evento de torneo
	 * @param idEquipo - Id del equipo
	 * @param idEvento - Id del torneo 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`SoloEventParticipants` (`idSoloEvent`, `idSoloPart`) VALUES (1 , 3);
	 * COMMIT;
	 */
	public String registerSoloInGroupTournamentEvent(int idSolo, int idEvento)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"INSERT INTO `Spartan`.`SoloEventParticipants` (`idSoloEvent`, `idSoloPart`) VALUES (" + idEvento + " , " + idSolo + ");" + "\n" +
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para actualizar el numero de lugares disponibles en un evento de torneo 
	 * @param idEvent - Id del evento 
	 * @param idTorneo - Id del torneo 
	 * @param nSpots - Numero de lugares a aumentar 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * UPDATE `Spartan`.`SoloTournamentEvents`
	 * SET nSpots = nSpots + 3
	 * WHERE idSoloEvent = 1 AND idSoloTournament = 1;
	 * COMMIT;
	 */
	public String updateSoloTournamentEventSpots(int idEvent, int idTorneo, int nSpots)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"UPDATE `Spartan`.`SoloTournamentEvents`" + "\n" +
				"SET nSpots = nSpots + " + nSpots + "\n" + 
				"WHERE idSoloEvent = " + idEvent + " AND idSoloTournament = " + idTorneo  + ";" + "\n" +
				"COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para cancelar un evento grupal  
	 * @param idEvent - Es el id del evento 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * DELETE FROM `Spartan`.`GroupTournamentParticipants`
	 * WHERE idGroupEvent = 1 ;
	 * DELETE FROM `Spartan`.`GroupTournamentEvents`
	 * WHERE idGroupEvent = 1 ;
	 * COMMIT;
	 */
	public String cancelSoloTournamentEvent(int idEvent)
	{
		String query = 
				"START TRANSACTION;" + "\n" + 
				"USE `Spartan`;" + "\n" + 
				"DELETE FROM `Spartan`.`SoloEventParticipants`" + "\n" + 
				"WHERE idSoloEvent = " + idEvent +" ;" + "\n" +  
				"DELETE FROM `Spartan`.`SoloTournamentEvents`" + "\n" + 
				"WHERE idSoloEvent = " + idEvent + " ;" + "\n" +  
				"COMMIT;";
		return query;
	}
}
