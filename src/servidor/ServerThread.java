package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{

	Socket client;
	BufferedReader readerST;
	PrintWriter writerST;
	Race race;
	long time;
	
	public ServerThread(Socket solicitude, Race r, long startTime){
		super();
		client = solicitude;
		race = r;
		time = startTime;
		
	}
	
	/**
	 * Logic of business is ran
	 */
	public void run(){
		
		    
			try{
				//Se crean los flujos asociados
				readerST = new BufferedReader(new InputStreamReader(client.getInputStream()));
				writerST = new PrintWriter(client.getOutputStream(), true);
				
				
				String mensaje = readerST.readLine();
			
				long start = System.currentTimeMillis();
				long end = System.currentTimeMillis();
				
				while(((end-start)+time)<SSLServerSocket.TIME){
					String[] lista= mensaje.split(",");
					
					for (int i = 0; i < race.getCaballos().size(); i++) {
						if(race.getCaballos().get(i).getBettor().equals(lista[0])) {
							race.getCaballos().get(i).setBet(Integer.parseInt(lista[1]));
						}
					}
					System.out.println("Apuesta recibida al " +lista[0]+ " por un valor de $"+lista[1]);
					writerST.println(lista[0]+ ","+lista[1]);
					writerST.flush();
					mensaje = readerST.readLine();
					end= System.currentTimeMillis();
				
					}
					
					// we are going to close the streams and the socket associated to the request
					readerST.close();
					writerST.close();
					client.close();
				
			}catch(IOException e){
				e.printStackTrace();
			}
		
	}

	
	
}
