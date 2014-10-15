package com.spartan.server.operations;

import com.spartan.server.entities.Spot;

public class EventOperations 
{
	//------------------------------------------------------------------
	//Regular event
	//------------------------------------------------------------------

	/**
	 * Aumenta el numero de spots disponibles para un evento 
	 * @param nSpots - Es el nuevo numero de cupos 
	 * Siempre es mayor que la longitud actual 
	 */
	public void upgradeSpots(int nSpots)
	{
		Spot [] uSpots = new Spot[nSpots];
		for (int i = 0; i < this.availableSpots.length; i++)
		{
			uSpots[i] = this.availableSpots[i];
		}
		this.setAvailableSpots(uSpots);	
	}
	
	/**
	 * Retorna el numero de spots libres del evento 
	 * @return numero de spots libres del evento
	 */
	public int getFreeSpots()
	{
		Spot S = null;
		boolean stopMe = false;
		int free = 0;
		for (int k = availableSpots.length - 1; k > 0 && stopMe == false; k--)
		{
			S = availableSpots[k];
			if (S == null)
			{
				free ++;
			}
			else
			{
				stopMe = true;
			}
		}
		return free;
	}
	
	/**
	 * Reduce el numero de spots disponibles al numero indicado 
	 * @param nSpots - Es el numero de spots al que se quieren reducir el cupo
	 * @throws Exception - En el caso de que alguno de los spots que siguen al numero indicado esten ocupados
	 */
	public void downgradeSpots(int nSpots) throws Exception 
	{
		Spot S = null;
		boolean stop = false;
		for (int i = nSpots; i < availableSpots.length && stop == false; i++)
		{
			S = availableSpots[i];
			//Caso I: Los lugares a eliminar estan libres
			if (S == null)
			{
				stop = true;
			}
			
			//Caso II: El spot siguente al indicador del cupo esta ocupado
			else
			{
				int eraseable = this.getFreeSpots();
				throw new Exception ("One of the spots to erase is reserved, you can only downgrade " + eraseable + " spots");
			}
		}
		Spot [] uSpots = new Spot[nSpots];
		for (int i = 0; i < uSpots.length; i++)
		{
			uSpots[i] = availableSpots[i];
		}
		this.setAvailableSpots(uSpots);
	}
	
	/**
	 * 
	 * @param idSpot
	 */
	public void cancelSpot(int idSpot)
	{
		
	}
	
	public void addSpot(Spot S) throws Exception 
	{
		int freeSpots = this.getFreeSpots();
		if (freeSpots > 0)
		{
			int insertPoint = availableSpots.length - freeSpots;
			availableSpots[insertPoint] = S;
		}
		else
		{
			throw new Exception ("All spots taken, sorry");
		}
	}

}
