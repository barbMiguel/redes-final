package servidor;

import java.io.*;
import javax.net.ssl.SSLServerSocketFactory;

import streaming.AudioUDPServer;

import java.net.*;

public class SSLServerSocket {

	public static final String KEYSTORE_LOCATION = "C:/Program Files (x86)/Java/jre1.8.0_111/bin/keystore.jks";
	public static final String KEYSTORE_PASSWORD = "password";

	/**
	 * Time during the server will be running the application
	 */
	public static final long TIME = 120000;


	public static final long PREVTIME = 20000;


	public static void main(String[] args){

		System.setProperty("javax.net.ssl.keyStore", KEYSTORE_LOCATION);
		System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASSWORD);

		SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();



		try{

			ServerSocket serverSocket = ssf.createServerSocket(8000);
			long end= System.currentTimeMillis();
			long start= System.currentTimeMillis();

			Race carrera = new Race();


			MulticastSocket multisocketTiempo = new MulticastSocket();
			InetAddress inetAddress = InetAddress.getByName("229.5.6.7");
			multisocketTiempo.joinGroup(inetAddress);

			AudioUDPServer audioServidor = new AudioUDPServer();
			audioServidor.start();


			boolean bandera = true;

			while((end-start)<(TIME+PREVTIME)) {

				if((end-start)<PREVTIME) {
					Socket socket = serverSocket.accept();

					long t = (int)((PREVTIME-(end-start))/1000);
					ServerThread thread= new ServerThread(socket, carrera, end-start);
					thread.start();

					if(bandera) {
						TimerThreadS threadData = new TimerThreadS(multisocketTiempo,inetAddress,t,carrera);
						threadData.start();
						bandera = false;
					}

					end = System.currentTimeMillis();
				}
			}

			//Finalization of the Service
			
			serverSocket.close();

			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("SSLServerSocket Teminated");

			for (int i = 0; i < carrera.getCaballos().size(); i++) {
				System.out.println("Para el caballo C"+(i+1)+" se ha apostado $"+ carrera.getCaballos().get(i).getBet());
			}
			System.exit(0);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
