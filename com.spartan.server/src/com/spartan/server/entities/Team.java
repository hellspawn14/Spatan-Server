package com.spartan.server.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Team 
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	/**
	 * Nombre del equipo
	 */
	private String teamName;
	
	/**
	 * Nombre de usuario del lider del equipo
	 */
	private User teamLeader;
	
	/**
	 * Lista de los miembros del equipo
	 */
	private ArrayList <String> miembrosEquipo;
	
	/**
	 * Tabla de hash con los miembros del equipo
	 */
	private Hashtable<Integer, String> miembros;
	
	//------------------------------------------------------------------
	//Construtores
	//------------------------------------------------------------------
	
	/**
	 * Crea un nuevo equipo y agrega al capitan al equipo
	 * @param teamName - El nombre del equipo
	 * @param teamLeader - Lider de equipo
	 */
	public Team(String teamName, User teamLeader) 
	{
		//Inicializa los datos basicos del equipo
		this.teamName = teamName;
		this.teamLeader = teamLeader;
		miembrosEquipo = new ArrayList<String>();
		miembros = new Hashtable <Integer, String>();
		
		//Agrega al lider a las dos estructuras de control
		miembrosEquipo.add(teamLeader.getUserName());
		miembros.put((teamLeader.getUserName()).hashCode(), teamLeader.getUserName());
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
	 * @return the miembrosEquipo
	 */
	public ArrayList<String> getMiembrosEquipo() {
		return miembrosEquipo;
	}

	/**
	 * @param miembrosEquipo the miembrosEquipo to set
	 */
	public void setMiembrosEquipo(ArrayList<String> miembrosEquipo) {
		this.miembrosEquipo = miembrosEquipo;
	}

	/**
	 * @return the miembros
	 */
	public Hashtable<Integer, String> getMiembros() {
		return miembros;
	}

	/**
	 * @param miembros the miembros to set
	 */
	public void setMiembros(Hashtable<Integer, String> miembros) {
		this.miembros = miembros;
	}	
}
