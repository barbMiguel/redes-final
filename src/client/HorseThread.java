package client;

import java.io.IOException;
import java.util.Random;

public class HorseThread extends Thread {

	//Horse's name 
	private String name;
	
	//Number associated to the horse
	private int number;
	
	//Value of bet made on this horse
	private float bet;
	
	//Goal to reach
	public static float GOAL = 100;
	
	//Current location of the horse through the turf
	private float currentLocation;
	
	//Indicates if the horse have won
	private boolean win;
	
	
	public HorseThread(String n, int number){
		this.name = n;
		currentLocation = 0;
		win = false;
		this.number = number;
		
		
	}

	public float getBet() {
		return bet;
	}

	public void toBet(float b) {
		this.bet = b;
	}

	public String getNombre() {
		return name;
	}
	
	public void run(){
		try{
			while(currentLocation < GOAL){
				HorseThread.sleep(1000);
				
				float randomNumber = (float) (Math.random() * 1) + 0;
				int number = (int) (randomNumber * 1000);
				
				HorseThread.sleep(number);
				
				currentLocation ++;
				
			}
			
			if(currentLocation == GOAL){
				win = true;
			}
			
		}catch(Exception ioe){
			ioe.printStackTrace();
		}
	}
	
	
	
}
