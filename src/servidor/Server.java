package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import client.HorseThread;

public class Server {

	private static HorseThread[] horseThreads;
	private String[] h ;
	
	public Server(){

	}
	public static void main (String[] args){
		//Server.Server();
		horseThreads = new HorseThread[6];

	try{
		ServerSocket server = new ServerSocket(8030);
		
		while(true){
			
			Socket c = server.accept();
			//ServerThread thread = new ServerThread(c, );
			//thread.start();
			
			
			
			
			try {			
				// It waits until the six of the threads have finished
				// thread.join();
				horseThreads[0].join();
				horseThreads[1].join();
				horseThreads[2].join();
				horseThreads[3].join();
				horseThreads[4].join();
				horseThreads[5].join();
	            
	        }catch (InterruptedException exc){
	            System.out.println("Hilo principal interrumpido.");
	        }
			
		}
	}catch(IOException e){
		e.printStackTrace();
	}finally{
	
	}
}
	
}
