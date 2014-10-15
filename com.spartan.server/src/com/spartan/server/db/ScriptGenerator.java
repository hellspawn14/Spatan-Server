package com.spartan.server.db;


/**
 * Servicio para la generacion de scripts SQL 
 * @author hellspawn
 */
public class ScriptGenerator 
{
	//------------------------------------------------------------------
	//Constantes
	//------------------------------------------------------------------
	
	//------------------------------------------------------------------
	//Atributos
	//------------------------------------------------------------------

	//------------------------------------------------------------------
	//Construtores
	//------------------------------------------------------------------

	//------------------------------------------------------------------
	//Metodos
	//------------------------------------------------------------------
	
	/**
	 * Retorna la Query para insertar a un nuevo usuario en la tabla Users
	 * @param userName - Es el nombre del usuario 
	 * @param realName - Es el nombre real del usuario 
	 * @param realLastName - Es el apellido 
	 * @param phoneNumber - Es el numero de telefono 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`Users` (`UserName`, `PhoneNumber`)VALUES ('userName' , 'phoneNumber');
	 * COMMIT;
	 */
	public String registerUser(String userName,  String phoneNumber)
	{	
		String query = "START TRANSACTION;" + "\n" + "USE `Spartan`;"  + "\n" + "INSERT INTO `Spartan`.`Users` (`UserName`, `PhoneNumber`)" + "VALUES ('" + userName + "' , '" + phoneNumber + "');" + "\n" +  "COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para registrar los datos de autenticacion de usuarios 
	 * @param userId - Es el identificador del usuario
	 * @param userPassword - Es la contraseña 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`Auth` (`idUserAuth`, `Password`) VALUES( Xx, 'userPassword');
	 * COMMIT;
	 */
	public String registerUserAuth(int userId, String userPassword)
	{
		String query = "START TRANSACTION;" + "\n" + "USE `Spartan`;" + "\n" + "INSERT INTO `Spartan`.`Auth` (`idUserAuth`, `Password`) " +  "VALUES(" + userId + ", '" + userPassword + "');" + "\n" +  "COMMIT;";
		return query;
	}
	
	/**
	 * Retorna la Query para registrar la informacion de un usuario en la tabla ScoreBoard
	 * @param userId - Es el identificador del usuario 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`ScoreBoard` (`idUserBoard`, `Score`) VALUES(Xx , 0.0);
	 * COMMIT;
	 */
	public String registerUserBoard(int userId)
	{
		String query = "START TRANSACTION;" + "\n" + "USE `Spartan`;" + "\n" + "INSERT INTO `Spartan`.`ScoreBoard` (`idUserBoard`, `Score`) " +  "VALUES(" + userId + " , " + 0.0 + ");" + "\n" +  "COMMIT;";
		return query;
	}
	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	public static void main(String args[])
	{
		ScriptGenerator gen = new ScriptGenerator();
		System.out.println(gen.registerUserBoard(7));
	}
}
