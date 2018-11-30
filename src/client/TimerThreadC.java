package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import streaming.CancionUDPCliente;
import ux.PanelClientInfo;

public class TimerThreadC extends Thread{

	private SSLClientSocket clock;
	private PanelClientInfo panelInfo;
//	private PanelClientHorsesRace panelRace;
//	private FCarrera frame;
	
	
	public TimerThreadC(PanelClientInfo info, SSLClientSocket ssl) {
	panelInfo = info;
//	panelRace = pRace;
	clock = ssl;	
	}
	
	public void run() {
	
		while(true){
			MulticastSocket multicastSocket;
			
			try {
				multicastSocket = new MulticastSocket(9001);
				InetAddress inetAddress = InetAddress.getByName("229.5.6.7");
				multicastSocket.joinGroup(inetAddress);
				
				byte[] buffer = new byte[10000];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				multicastSocket.receive(packet);
				
				String message= new String(packet.getData(), 0, packet.getLength());
				
				String[] m = message.split(",");
				
				boolean stop = true;
				if(!m[1].equals("Preparación") && stop) {
					
					stop = false;
					CancionUDPCliente c = new CancionUDPCliente();
					c.start();
					
					clock.disableBet();
					
					
				}
				
				int ms = Integer.parseInt(m[0]);  
				int segs = ms%60; ms -= segs; ms /= 60;
				int mins = ms%60; ms -= mins; ms /= 60;
				
				
				panelInfo.setMin("0"+mins);
				
				if(segs<10) {				
					panelInfo.setSeg("0"+segs);}
				if(segs>=10) {
					panelInfo.setSeg(""+segs);
				}
				
				panelInfo.setEstado(m[1]);
				
//				panelRace.setCoordenadasX(m[2].split("-"));
//				
//				panelRace.setPosiciones(m[3].split("-"));
//				
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
