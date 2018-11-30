package client;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.net.*;
import javax.net.ssl.SSLSocketFactory;

import streaming.AudioUDPClient;
import ux.FCarrera;
import ux.PanelClientInfo;
import ux.Principal;

public class SSLClientSocket {
	
	public static final String TRUSTTORE_LOCATION = "C:/Program Files (x86)/Java/jre1.8.0_111/bin/keystore.jks";
	
	private static Principal principal;
	private FCarrera frame;
	
	//private PanelClientHorsesRace panelCarrera;
	private  PanelClientInfo panelTiempoCliente;
	
	PrintWriter out;
	BufferedReader br;

	public SSLClientSocket() {
		System.setProperty("javax.net.ssl.trustStore", TRUSTTORE_LOCATION);
		SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
		
		Socket socket;
		
		try {
			socket = sf.createSocket("localhost", 8000);
			//Sending data
			out = new PrintWriter(socket.getOutputStream(), true);
			//response data
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//createMainFrame();
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//panelCarrera = new PanelClientHorsesRace();
		panelTiempoCliente = new PanelClientInfo();
		panelTiempoCliente.setPreferredSize(new Dimension(900, 50));;
		
//		add(panelTiempoCliente, BorderLayout.NORTH);
//		add(panelCarrera,BorderLayout.CENTER);
//		add(auxPanel, BorderLayout.SOUTH);		
		
		
//		TimerThreadC tiempo = new TimerThreadC(panelTiempoCliente, null ,this);
//		tiempo.start();
	
		
		
		
	}
	
	private static void createMainFrame() {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Principal pr = new Principal(this);
				principal = pr;
				principal.setVisible(true);
				
			}
		});
	}
	
	

	public void disableBet() {
		principal.disableBetOptions();
		
	}
	
	
public static void main (String[] args) throws Exception {
	
	System.out.println("SSLClientSocket Started");
	SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
	createMainFrame();
	
	
	AudioUDPClient audioCliente = new AudioUDPClient();
	audioCliente.start();
	
			
}
}
