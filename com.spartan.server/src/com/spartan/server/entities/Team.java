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
	private String teamLeader;
	
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
	public Team(String teamName, String teamLeader) 
	{
		//Inicializa los datos basicos del equipo
		this.teamName = teamName;
		this.teamLeader = teamLeader;
		miembrosEquipo = new ArrayList<String>();
		miembros = new Hashtable <Integer, String>();
		
		//Agrega al lider a las dos estructuras de control
		miembrosEquipo.add(teamLeader);
		miembros.put(teamLeader.hashCode(), teamLeader);
	}

	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------
	
	/**
	 * Agrega un nuevo usuario al equipo
	 * @param teamMember - Es el usuario a agregar
	 * @throws Exception - En el caso de que el usuario ya este registrado
	 */
	public void addNewMember(String teamMember) throws Exception 
	{
		String getUser = getMemberByName(teamMember);
		if (getUser == null)
		{
			miembrosEquipo.add(teamMember);
			miembros.put(teamMember.hashCode(), teamMember);
		}
		else
		{
			throw new Exception ("The user already is in team");
		}
	}
	
	/**
	 * Retorna un usuario dado su nombre 
	 * @param teamMember - Es el nombre de usuario  
	 * @return null o el nombre del usuario dado 
	 */
	public String getMemberByName(String teamMember)
	{
		return miembros.get(teamMember.hashCode());
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
	public String getTeamLeader() {
		return teamLeader;
	}

	/**
	 * @param teamLeader the teamLeader to set
	 */
	public void setTeamLeader(String teamLeader) {
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
