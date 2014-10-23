package com.spartan.server.entities;

/**
 * Representa el perfil de un usuario 
 * @author hellspawn
 */
public class UserProfile 
{
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------
	
	/**
	 * Numero telefonico del usuario (preferiblemente celular)
	 */
	private String phoneNumber;
	
	/**
	 * Puntaje del usuario 
	 */
	private double score;
	
	/**
	 * Numero de juegos de soccer
	 */
	private int nSoccer;
	
	/**
	 * Numero de juegos de basketball 
	 */
	private int nBasketball;
	
	/**
	 * Numero de juegos de voleyball
	 */
	private int nVoleyball;
	
	/**
	 * Numero de juegos de tennis
	 */
	private int nTennis;
	
	/**
	 * Numero de juegos de paintball
	 */
	private int nPaintball;
	
	/**
	 * Numero de juegos de videojuegos
	 */
	private int nVideogames;
	
	/**
	 * Numero de juegos de karts 
	 */
	private int nKarts;
	
	/**
	 * Numero de victorias
	 */
	private int nVictories;
	
	/**
	 * Numero de derrotas
	 */
	private int nLoses;

	
	//------------------------------------------------------------------
	//Constructores
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo perfil de usuario en el sistema
	 * @param name - Es el nombre real de usuario 
	 * @param lastName - Es el apellido real del usuario 
	 * @param phoneNumber - Es el numero de telefono de usuario 
	 * @param score - Es el puntaje del usuario 
	 * @param nSoccer - Es el numero de encuentros de partidos de soccer
	 * @param nBasketball - Es el numero de encuentros de basketball
	 * @param nVoleyball - Es el numero de encuentros de Voleyball 
	 * @param nTennis - Es el numero de encuentros de tennis
	 * @param nPaintball - Es el numero de encuentros de paintball
	 * @param nVideogames - Es el numero de encuentros de videojuegos
	 * @param nKarts - Es el numero de encuentros de karts 
	 * @param nVictories - Es el numero de victorias obtenidas
	 * @param nLoses - Es el numero de derrotas
	 */
	public UserProfile(String phoneNumber,double score, int nSoccer, int nBasketball, int nVoleyball,int nTennis, int nPaintball, int nVideogames, int nKarts,int nVictories, int nLoses)
	{
		this.phoneNumber = phoneNumber;
		this.score = score;
		this.nSoccer = nSoccer;
		this.nBasketball = nBasketball;
		this.nVoleyball = nVoleyball;
		this.nTennis = nTennis;
		this.nPaintball = nPaintball;
		this.nVideogames = nVideogames;
		this.nKarts = nKarts;
		this.nVictories = nVictories;
		this.nLoses = nLoses;
	}

	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}


	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}


	/**
	 * @return the nSoccer
	 */
	public int getnSoccer() {
		return nSoccer;
	}


	/**
	 * @param nSoccer the nSoccer to set
	 */
	public void setnSoccer(int nSoccer) {
		this.nSoccer = nSoccer;
	}


	/**
	 * @return the nBasketball
	 */
	public int getnBasketball() {
		return nBasketball;
	}


	/**
	 * @param nBasketball the nBasketball to set
	 */
	public void setnBasketball(int nBasketball) {
		this.nBasketball = nBasketball;
	}


	/**
	 * @return the nVoleyball
	 */
	public int getnVoleyball() {
		return nVoleyball;
	}


	/**
	 * @param nVoleyball the nVoleyball to set
	 */
	public void setnVoleyball(int nVoleyball) {
		this.nVoleyball = nVoleyball;
	}


	/**
	 * @return the nTennis
	 */
	public int getnTennis() {
		return nTennis;
	}


	/**
	 * @param nTennis the nTennis to set
	 */
	public void setnTennis(int nTennis) {
		this.nTennis = nTennis;
	}


	/**
	 * @return the nPaintball
	 */
	public int getnPaintball() {
		return nPaintball;
	}


	/**
	 * @param nPaintball the nPaintball to set
	 */
	public void setnPaintball(int nPaintball) {
		this.nPaintball = nPaintball;
	}


	/**
	 * @return the nVideogames
	 */
	public int getnVideogames() {
		return nVideogames;
	}


	/**
	 * @param nVideogames the nVideogames to set
	 */
	public void setnVideogames(int nVideogames) {
		this.nVideogames = nVideogames;
	}


	/**
	 * @return the nKarts
	 */
	public int getnKarts() {
		return nKarts;
	}


	/**
	 * @param nKarts the nKarts to set
	 */
	public void setnKarts(int nKarts) {
		this.nKarts = nKarts;
	}


	/**
	 * @return the nVictories
	 */
	public int getnVictories() {
		return nVictories;
	}


	/**
	 * @param nVictories the nVictories to set
	 */
	public void setnVictories(int nVictories) {
		this.nVictories = nVictories;
	}


	/**
	 * @return the nLoses
	 */
	public int getnLoses() {
		return nLoses;
	}


	/**
	 * @param nLoses the nLoses to set
	 */
	public void setnLoses(int nLoses) {
		this.nLoses = nLoses;
	}

}
