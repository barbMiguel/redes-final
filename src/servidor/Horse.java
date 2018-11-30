package servidor;

import java.util.ArrayList;

public class Horse {

	/**
	 * Name of the horse
	 */
	private String name;
	
	/**
	 * String with the path of the image
	 */
	private String imgPath;
	
	/**
	 * Number that identifies the horse
	 */
	private int number;
	
	/**
	 *  Stores the sum up of the whole amount of bets on this horse
	 */
	private double historicBet;
	
	/**
	 *  Stores the bet made on this horse by the current user
	 */
	private double bet;
	
	/**
	 *  Stores the bet made on this horse in the current round
	 */
	private double GameBet;
	
	/**
	 * Horse's position in the race
	 * pre: all horses start with position 0
	 * pos: the final position of the horse by the end of the race
	 */
	private int position;
	
	/**
	 * Distance covered by the moment for the horse
	 */
	private int distanceCovered;
	
	/**
	 * The horse has won the race
	 */
	private boolean won;
	
	/**
	 * Path of the icon's image
	 */
	private String iconImage;
	
	/**
	 * It shows if the horse has been chosen by the user or not
	 */
	private boolean chosen;
	
	/**
	 * Bettor's ID
	 * As a bettor has a relationship between just one horse, this value is unique per client conection
	 * 
	 */
	private String bettor;
	
	private int wonRaces;
	
	/**
	 * 
	 * @param nName
	 * @param nImgPath
	 * @param nNumber
	 * @param nPuesto
	 */
	
	public Horse(String nName, String nIconPath, String nImgPath, int nNumber, int totalGanadas, double totalBets){
		historicBet = totalBets;
		bet = 0;
		position = 0;
		name = nName;
		imgPath = nImgPath;
		number = nNumber;
		distanceCovered = 0;
		won = false;
		iconImage = nIconPath;
		chosen = false;
		bettor = "0";
		wonRaces = totalGanadas;
		
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public int getWonRaces() {
		return wonRaces;
	}


	public void setWonRaces(int wonRaces) {
		this.wonRaces = wonRaces;
	}


	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}


	public double getHistoricBet() {
		return historicBet;
	}


	public void setHistoricBet(double historicBet) {
		this.historicBet = historicBet;
	}


	public double getBet() {
		return bet;
	}


	public void setBet(double bet) {
		this.bet = bet;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int puesto) {
		this.position = puesto;
	}


	public double getGameBet() {
		return GameBet;
	}


	public void setGameBet(double gameBet) {
		GameBet += gameBet;
	}


	public int getDistanceCovered() {
		return distanceCovered;
	}


	public void setDistanceCovered(int distanceCovered) {
		this.distanceCovered += distanceCovered;
	}


	public boolean isWon() {
		return won;
	}


	public void setWon(boolean won) {
		this.won = won;
	}


	public String getName() {
		return name;
	}


	public int getNumber() {
		return number;
	}


	public boolean isChosen() {
		return chosen;
	}


	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}


	public String getIconImage() {
		return iconImage;
	}


	public String getBettor() {
		return bettor;
	}


	public void setBettor(String bettor) {
		this.bettor = bettor;
	}
	
	
	
	
	
	
}
