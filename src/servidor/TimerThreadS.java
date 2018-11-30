package servidor;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import streaming.CancionUDPServer;

public class TimerThreadS extends Thread{

	private MulticastSocket sender;
	private long time;
	private InetAddress host;
	private Race race;
	
public TimerThreadS(MulticastSocket dataSocket, InetAddress host, long time, Race carrera) {
		
		sender= dataSocket;
		this.time = time;
		this.host = host;
		race = carrera;
		
	}

public void run(){
	
	/**
	 * What occurs when the race hasn't started
	 */
	waiting();
	
	/**
	 * What occurs when the race has begun
	 */
	raceStart();
	
	/**
	 * What occurs when the race has finished
	 */
	finished();	
}

public void waiting() {
	
	
	while(time>=0) {
		String tiempo = (time+",Preparación,0-0-0-0-0-0,0-0-0-0-0-0");

		byte[] buffer = tiempo.getBytes();

		try {
			DatagramPacket datagrama= new DatagramPacket(buffer, buffer.length,host,9001);
			sender.send(datagrama);
			sleep(1000);
			time=time-1;
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

public void raceStart() {
	
	time = (int)(SSLServerSocket.TIME/1000);
	
	CancionUDPServer cancion = new CancionUDPServer();
	cancion.start();
	
	while(time>=0){
		
		String e = ",";
		String p = "";
		for (int i = 0; i < race.getCaballos().size(); i++) {
			int numero = (int) (Math.random() * 5) + 1;
			race.getCaballos().get(i).setDistanceCovered(numero);
			if(i==race.getCaballos().size()-1) {
			e+=(race.getCaballos().get(i).getDistanceCovered()+"");
			
			race.updatePosition();
			p+=(race.getCaballos().get(i).getPosition()+"");
			}else {
				e+=(race.getCaballos().get(i).getDistanceCovered()+"-");
				
				race.updatePosition();
				p+=(race.getCaballos().get(i).getPosition()+"-");
				
			}	
		}
		
		String tiempo = (time+", ¡Arrancó!")+e+","+p;
		byte[] buffer = tiempo.getBytes();
		try {
			DatagramPacket datagrama= new DatagramPacket(buffer, buffer.length,host,9001);
			sender.send(datagrama);
			sleep(1000);
			time=time-1;
		}catch(Exception i) {
			i.printStackTrace();
		}
	}
	
}


private void finished() {
	// TODO Auto-generated method stub
	String e = ",";
	String p = "";
	for (int i = 0; i < race.getCaballos().size(); i++) {
		int numero = (int) (Math.random() * 5) + 1;
		race.getCaballos().get(i).setDistanceCovered(numero);
		if(i==race.getCaballos().size()-1) {
		e+=(race.getCaballos().get(i).getDistanceCovered()+"");
		
		race.updatePosition();
		p+=(race.getCaballos().get(i).getPosition()+"");
		}else {
			e+=(race.getCaballos().get(i).getDistanceCovered()+"-");
			
			race.updatePosition();
			p+=(race.getCaballos().get(i).getPosition()+"-");
			
		}	
	}
	
	String tiempo = (time+", Finalizo")+e+","+p;

	byte[] buffer = tiempo.getBytes();

	try {
		DatagramPacket datagrama= new DatagramPacket(buffer, buffer.length,host,9001);
		sender.send(datagrama);
		sleep(1000);
		time=time-1;
	}catch(Exception i) {
		i.printStackTrace();
	}

}


}
