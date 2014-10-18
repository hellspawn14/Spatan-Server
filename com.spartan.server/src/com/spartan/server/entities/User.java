package com.spartan.server.entities;

import java.util.ArrayList;

/**
 * Representa la informacion basica de un usuario en el sistema
 * @author hellspawn
 */
public class User 
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------
	
	/**
	 * Identificador del usuario en base de datos 
	 */
	private int userId;
	
	/**
	 * Nombre de usuario
	 */
	private String userName;
	
	/**
	 * Perfil del usuario
	 */
	private UserProfile profile;
	
	/**
	 * Lista de equipos a los que pertenece el usuario 
	 */
	private ArrayList <Team> myTeams;
	
	/**
	 * Lugares reservados en el momento actual 
	 */
	private ArrayList <Spot> currentSpots;
	
	/**
	 * Lista de eventos actuales creados por el usuario 
	 */
	private ArrayList <RegularEvent> myCurrentEvents;
	
	/**
	 * Lista de eventos publicos a los que asiste el usuario
	 */
	private ArrayList <PublicEvent> publicEvents;
	
	/**
	 * Lista de torneos organizados por el usuario 
	 */
	private ArrayList <Tournament> myTournaments;

	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo usuario en el sistema
	 * @param userId - Es el identificador del usuario
	 * @param userName - Es el nombre del usuario
	 * @param profile - Es el perfil 
	 */
	public User(int userId, String userName, UserProfile profile) 
	{
		this.userId = userId;
		this.userName = userName;
		this.profile = profile;
		myTeams = new ArrayList <Team>();
		setMyCurrentEvents(new ArrayList<RegularEvent>());
		setCurrentSpots(new ArrayList <Spot>());
		setMyTournaments(new ArrayList <Tournament>());
		setPublicEvents(new ArrayList <PublicEvent>());
	}

	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the profile
	 */
	public UserProfile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}

	/**
	 * @return the myTeams
	 */
	public ArrayList<Team> getMyTeams() {
		return myTeams;
	}

	/**
	 * @param myTeams the myTeams to set
	 */
	public void setMyTeams(ArrayList<Team> myTeams) {
		this.myTeams = myTeams;
	}

	/**
	 * @return the currentSpots
	 */
	public ArrayList <Spot> getCurrentSpots() {
		return currentSpots;
	}

	/**
	 * @param currentSpots the currentSpots to set
	 */
	public void setCurrentSpots(ArrayList <Spot> currentSpots) {
		this.currentSpots = currentSpots;
	}

	/**
	 * @return the myCurrentEvents
	 */
	public ArrayList <RegularEvent> getMyCurrentEvents() {
		return myCurrentEvents;
	}

	/**
	 * @param myCurrentEvents the myCurrentEvents to set
	 */
	public void setMyCurrentEvents(ArrayList <RegularEvent> myCurrentEvents) {
		this.myCurrentEvents = myCurrentEvents;
	}

	/**
	 * @return the myTournaments
	 */
	public ArrayList <Tournament> getMyTournaments() {
		return myTournaments;
	}

	/**
	 * @param myTournaments the myTournaments to set
	 */
	public void setMyTournaments(ArrayList <Tournament> myTournaments) {
		this.myTournaments = myTournaments;
	}

	/**
	 * @return the publicEvents
	 */
	public ArrayList <PublicEvent> getPublicEvents() {
		return publicEvents;
	}

	/**
	 * @param publicEvents the publicEvents to set
	 */
	public void setPublicEvents(ArrayList <PublicEvent> publicEvents) {
		this.publicEvents = publicEvents;
	}
}
