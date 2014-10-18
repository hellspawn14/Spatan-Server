package com.spartan.server.entities;

import java.util.Hashtable;

public class Team 
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Identificador del equipo
	 */
	private int idTeam;
	
	/**
	 * Nombre del equipo
	 */
	private String teamName;
	
	/**
	 * Nombre de usuario del lider del equipo
	 */
	private User teamLeader;
	
	/**
	 * Tabla de hash con los miembros del equipo
	 */
	private Hashtable<Integer, User> miembros;
	
	//------------------------------------------------------------------
	//Construtores
	//------------------------------------------------------------------
	
	/**
	 * Crea un nuevo equipo y agrega al capitan al equipo
	 * @param teamName - El nombre del equipo
	 * @param teamLeader - Lider de equipo
	 */
	public Team(int idTeam, String teamName, User teamLeader) 
	{
		//Inicializa los datos basicos del equipo
		this.setIdTeam(idTeam);
		this.teamName = teamName;
		this.teamLeader = teamLeader;
		miembros = new Hashtable <Integer, User>();
		
		//Agrega al lider 
		miembros.put((teamLeader.getUserName()).hashCode(), teamLeader);
	}

	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the teamLeader
	 */
	public User getTeamLeader() {
		return teamLeader;
	}

	/**
	 * @param teamLeader the teamLeader to set
	 */
	public void setTeamLeader(User teamLeader) {
		this.teamLeader = teamLeader;
	}

	/**
	 * @return the miembros
	 */
	public Hashtable<Integer, User> getMiembros() {
		return miembros;
	}

	/**
	 * @param miembros the miembros to set
	 */
	public void setMiembros(Hashtable<Integer, User> miembros) {
		this.miembros = miembros;
	}


	/**
	 * @return the idTeam
	 */
	public int getIdTeam() {
		return idTeam;
	}


	/**
	 * @param idTeam the idTeam to set
	 */
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}	
}
