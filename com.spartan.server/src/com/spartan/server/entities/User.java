package com.spartan.server.entities;

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
	private String userId;
	
	/**
	 * Nombre de usuario
	 */
	private String userName;
	
	/**
	 * Perfil del usuario
	 */
	private UserProfile profile;

	//------------------------------------------------------------------
	//Construtores
	//------------------------------------------------------------------

	/**
	 * Crea un nuevo usuario en el sistema
	 * @param userId - Es el identificador del usuario
	 * @param userName - Es el nombre del usuario
	 * @param profile - Es el perfil 
	 */
	public User(String userId, String userName, UserProfile profile) 
	{
		this.userId = userId;
		this.userName = userName;
		this.profile = profile;
	}
	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}



	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
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

	


}
