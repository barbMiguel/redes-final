package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import ux.Principal;

public class Client extends Thread {

	Principal principal;
	private static BufferedReader readerC;
	private static PrintWriter writerC;

	public static void main (String[] args){

		//Sacket that will be used by the client
		Socket client;
		
		
		
		
		String horse, answer, host;
		int port, bet;
		Scanner scanner = new Scanner(System.in);
		
		try{
			//The Socket and associated flows are created
			client = new Socket("localhost", 8030);
			readerC = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writerC = new PrintWriter(client.getOutputStream(), true);
			
			//Horses available to bet on are shown
			
			
			
			//user name and its host are gotten
			host = client.getLocalAddress().getHostName();
			port = client.getLocalPort();
			
		
			//Se recibe la respuesta del servidor y se muestra por consola
			answer = readerC.readLine();
			System.out.println(answer);
			
			//La conexi�n TCP no se puede perder 
//			readerC.close();
//			writerC.close();
//			client.close();
//			scanner.close();
			
		} catch(NumberFormatException nf){
			System.out.println("Digite correctamente los n�meros");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
