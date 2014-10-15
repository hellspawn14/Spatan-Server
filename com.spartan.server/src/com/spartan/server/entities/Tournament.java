package com.spartan.server.entities;

/**
 * Representa un torneo basico 
 * @author hellspawn
 */
public abstract class Tournament 
{
	//------------------------------------------------------------------
	//Constantes
	//------------------------------------------------------------------
	
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Es el id del torneo
	 */
	private int idTournament;
	
	/**
	 * Es el nombre del torneo 
	 */
	private String tournamentName;
	
	/**
	 * Es la descripcion del torneo
	 */
	private String tournamentDescription;
	
	/**
	 * Es el deporte a jugar 
	 */
	private String sport;
	
	/**
	 * Es el estado del torneo 
	 */
	private String state;
	
	/**
	 * Es el tipo de torneo 
	 */
	private String type;
	
	/**
	 * Numero max de participantes 
	 */
	private int nParticipants;

	
	//------------------------------------------------------------------
	//Construtores
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo torneo generico 
	 * @param idTournament - Es el identificador del torneo 
	 * @param tournamentName - Es el nombre del torneo
	 * @param tournamentDescription - Es la descripcion del torneo 
	 * @param sport - Es el deporte a jugar 
	 * @param state - Es el estado 
	 * @param organizer - Es el organizador 
	 * @param type - Es el tipo de torneo 
	 * @param nParticipants - Indica el numero de participantes permitido 
	 */
	public Tournament(int idTournament, String tournamentName,String tournamentDescription, String sport, String state,User organizer, String type, int nParticipants)
	{
		this.idTournament = idTournament;
		this.tournamentName = tournamentName;
		this.tournamentDescription = tournamentDescription;
		this.sport = sport;
		this.state = state;
		this.type = type;
		this.nParticipants = nParticipants;
	}

	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	/**
	 * @return the idTournament
	 */
	public int getIdTournament() {
		return idTournament;
	}


	/**
	 * @param idTournament the idTournament to set
	 */
	public void setIdTournament(int idTournament) {
		this.idTournament = idTournament;
	}


	/**
	 * @return the tournamentName
	 */
	public String getTournamentName() {
		return tournamentName;
	}


	/**
	 * @param tournamentName the tournamentName to set
	 */
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}


	/**
	 * @return the tournamentDescription
	 */
	public String getTournamentDescription() {
		return tournamentDescription;
	}


	/**
	 * @param tournamentDescription the tournamentDescription to set
	 */
	public void setTournamentDescription(String tournamentDescription) {
		this.tournamentDescription = tournamentDescription;
	}


	/**
	 * @return the sport
	 */
	public String getSport() {
		return sport;
	}


	/**
	 * @param sport the sport to set
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the nParticipants
	 */
	public int getnParticipants() {
		return nParticipants;
	}


	/**
	 * @param nParticipants the nParticipants to set
	 */
	public void setnParticipants(int nParticipants) {
		this.nParticipants = nParticipants;
	}
}
