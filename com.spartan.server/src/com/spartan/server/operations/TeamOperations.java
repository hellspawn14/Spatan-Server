package com.spartan.server.operations;

public class TeamOperations 
{
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
	 * Borra a un miembro del equipo 
	 * @param teamMember - Es el nombre del miembro 
	 * @throws Exception - En el caso de que no exista 
	 */
	public void deleteMember(String teamMember) throws Exception
	{
		String getUser = getMemberByName(teamMember);
		if (getUser != null)
		{
			boolean termino = false;
			for (int i = 0; i < miembrosEquipo.size() && termino == false; i++)
			{
				getUser = miembros.get(i);
				if (getUser.equals(teamMember))
				{
					miembros.remove(i);
					termino = true;
				}
			}
			miembros.remove(teamMember.hashCode(), teamMember);
		}
		else
		{
			throw new Exception ("User was not found");
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

}
