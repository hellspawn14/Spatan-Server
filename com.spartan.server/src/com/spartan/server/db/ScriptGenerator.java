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
	
	/**
	 * Retorna la Query para registrar la informacion de un usuario en la tabla History
	 * @param userId - Es el identificador del usuario 
	 * @return Query ->
	 * START TRANSACTION;
	 * USE `Spartan`;
	 * INSERT INTO `Spartan`.`History` (`idUserHistory`, `nSoccer`, `nBasketball`, `nVoleyball`, `nTennis`, `nPaintball`, `nVideogames`, `nKarts`, `nVictories`, `nLoses`) VALUES (Xx, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	 * COMMIT;
	 */
	public String registerUserHistory(int userId)
	{
		String query = "START TRANSACTION;" + "\n" +  "USE `Spartan`;" + "\n" + "INSERT INTO `Spartan`.`History` (`idUserHistory`, `nSoccer`, `nBasketball`, `nVoleyball`, `nTennis`, `nPaintball`, `nVideogames`, `nKarts`, `nVictories`, `nLoses`) " + "VALUES (" + userId + ", 0, 0, 0, 0, 0, 0, 0, 0, 0);" + "\n" + "COMMIT;";
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
		String query = "SELECT Password FROM `Spartan`.`Auth` WHERE idUserAuth = " + userId + ";";
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
		String query = "START TRANSACTION;" + "\n" + "USE `Spartan`;" + "\n" + "UPDATE `Spartan`.`Auth`" +  "\n" + "SET Password = " + "'" + nPassword + "'" + "\n" +  "WHERE idUserAuth = " + userId + ";" + "\n" + "COMMIT;"; 
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
		String query = "START TRANSACTION;" + "\n" + "USE `Spartan`;" + "\n" + "UPDATE `Spartan`.`ScoreBoard`" +  "\n" + "SET Score = " + nScore + "\n" + "WHERE idUserBoard = "  + userId + ";" + "\n" + "COMMIT;";
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
		String query = "START TRANSACTION;" +  "\n" + "USE `Spartan`;" + "\n" + "UPDATE `Spartan`.`History`" +  "\n" +  "SET " + "nSoccer = " + nSoccer + " , " + "nBasketball = " + nBasketball + " , " + "nVoleyball = " + nVoleyball + " , " + "nTennis = " + nTennis + "," + "nPaintball = " + nPaintball + " , " + "nVideogames = " + nVideogames + " , " + "nKarts = " + nKarts + " , " + "nVictories = " + nVictories + " , " + "nLoses = " + nLoses + "\n" + "WHERE idUserHistory = " +  userId + ";" + "\n" + "COMMIT;"; 		
		return query;
	}
	
	//------------------------------------------------------------------
	//Getters & Setters
	//------------------------------------------------------------------
	
	public static void main(String args[])
	{
		ScriptGenerator gen = new ScriptGenerator();
		System.out.println(gen.updateHistory(7, 1, 0, 0, 0, 0, 0, 0, 1, 0));
	}
}
