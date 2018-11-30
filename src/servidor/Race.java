package servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ux.Principal;

/**
 *
 * @author migue
 */
public class Race {    
    
	public static int DISTANCE = 1000;
	
	private ArrayList<Horse> caballos;
	private Principal principal;
	
    public Race(){
    	
    	caballos = new ArrayList<Horse>();
    	
    	loadHorsesInfo();
    	
    }
    
    public void loadHorsesInfo(){
    	
    	ArrayList<String[]> datosIniciales = new ArrayList<String[]>();
    	
    	try {
    	File file = new File("./files/infoHorses.txt"); 
    	  
    	  BufferedReader br = new BufferedReader(new FileReader(file)); 
    	  
    	  String st = br.readLine();
    	  String[][] fila = new String[6][6];
    	  
			while ((st = br.readLine()) != null) { 
				for(int j=0; j<6; j++){
				String[] row = st.split(";");
				for (int i = 0; i < row.length; i++) {
					fila[j][i] = row[i];
				}
				datosIniciales.add(fila[j]);
				st = br.readLine();
				}
			  }
			
			initializeHorses(datosIniciales);
				
			
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
        
    }
    
    
    	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
		giveInitialHorseData();
	}

		private void giveInitialHorseData() {
		principal.initiateHorses(getNames(), getIconPaths());
	}

		private void initializeHorses(ArrayList<String[]> datosIniciales) {
    		String[] data = datosIniciales.get(0);
    		for (int i = 0; i < datosIniciales.size(); i++) {
    			data = datosIniciales.get(i);
				Horse horse = new Horse(data[0], data[2], data[3], Integer.parseInt(data[1]), Integer.parseInt(data[4]), Double.parseDouble(data[5]));
				caballos.add(horse);
			}
		
	}

		public void updatePosition() {
    		
    		int[] dis = new int[6];
    			
    		for (int i = 0; i < dis.length; i++) {
    		dis[i]=caballos.get(i).getDistanceCovered();
    		}
    		
    		for (int x = 0; x < dis.length; x++) {
    	        for (int i = 0; i < dis.length-x-1; i++) {
    	            if(dis[i] < dis[i+1]){
    	                int tmp = dis[i+1];
    	                dis[i+1] = dis[i];
    	                dis[i] = tmp;
    	            }
    	        }
    	    }
    		
    		for (int i = 0; i < dis.length; i++) {
    			
    			for (int j = 0; j < dis.length; j++) {
    				if(dis[i]==caballos.get(j).getDistanceCovered()) {
    					caballos.get(j).setPosition(i+1);
    				}
    			}
    			
    		}
    		
    		
    	}
        
        
    public void chooseHorse(int horseNumber) {
    	for (Horse horse : caballos) {
			if(horse.getNumber() == horseNumber){
				horse.setChosen(true);
			}
		}
    }
    



	public ArrayList<Horse> getCaballos() {
		return caballos;
	}

	public String[] getNames() {
		String[] names = new String[6];
		
		for (int i = 0; i < caballos.size(); i++) {
			names[i] = caballos.get(i).getName();
		}
		return names;
	}
	public String[] getImgPaths() {
		String[] names = new String[6];
		
		for (int i = 0; i < caballos.size(); i++) {
			names[i] = caballos.get(i).getImgPath();
		}
		return names;
	}
	public String[] getIconPaths() {
		String[] names = new String[6];
		
		for (int i = 0; i < caballos.size(); i++) {
			names[i] = caballos.get(i).getIconImage();
		}
		return names;
	}
	
	
    
}

