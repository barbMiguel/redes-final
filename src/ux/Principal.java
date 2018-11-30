package ux;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import servidor.Horse;
import servidor.Race;

import javax.swing.SwingConstants;

import client.SSLClientSocket;

/**
 *
 * @author migue
 */
public class Principal extends javax.swing.JFrame {
	PanelSelection pSelection = null;
	private Race logic = null;
	private int selectedHorse;
	private FCarrera panelCarrera = null;
	private Runnable sslClient = null;
	private PanelHorseInfo pHorseInfo = null;
	private ArrayList<Horse> horses = null;
	
	/**
	 * Creates new form Principal
	 */
	public Principal(Runnable runnable) {

		this.sslClient = runnable;
		logic = new Race();

		//logic.loadHorsesInfo();
		horses = logic.getCaballos();
		
		initComponents();
		//Panel Horse1
		try {



			pSelection = new PanelSelection(this);
			pSelection.setSize(310,485);
			pSelection.setLocation(5,5);

			jpSelection.removeAll();
			jpSelection.add(pSelection, BorderLayout.CENTER);



			JPanel jPanelInfoH = new JPanel();

			JPanel jPanelInfoGeneral = new JPanel();
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(6)
								.addComponent(jpSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(jPanelInfoGeneral, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
									.addComponent(jPanelInfoH, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE))
							.addComponent(jBanner, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(jBanner, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(jPanelInfoH, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jPanelInfoGeneral, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(jpSelection, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE))
						.addGap(31))
			);

			JLabel lblFlag = new JLabel("");
			lblFlag.setVerticalAlignment(SwingConstants.TOP);
			lblFlag.setIcon(new ImageIcon("/Users/estudiante/Documents/proyecto final/ParcialHipodromo1/images/0icons/output-onlinepngtools (1).png"));
			GroupLayout gl_jBanner = new GroupLayout(jBanner);
			gl_jBanner.setHorizontalGroup(
				gl_jBanner.createParallelGroup(Alignment.LEADING)
					.addComponent(lblFlag, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
			);
			gl_jBanner.setVerticalGroup(
				gl_jBanner.createParallelGroup(Alignment.LEADING)
					.addComponent(lblFlag, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
			);


			pHorseInfo = new PanelHorseInfo(this);
			pHorseInfo.setSize(416,300);
			pHorseInfo.setLocation(5,5);

			jPanelInfoH.removeAll();
			jPanelInfoH.add(pHorseInfo, BorderLayout.CENTER);


			jBanner.setLayout(gl_jBanner);
			getContentPane().setLayout(groupLayout);
			pSelection.setVisible(true);
			jpSelection.revalidate();
			jpSelection.repaint();

		} catch (IOException e) {
			e.printStackTrace();
		}

		pack();
		setPrincipal();
		//initiateBasicInfo();
	}
	public void setPrincipal() {
	logic.setPrincipal(this);
	}
	/**
	 * Determines what happens right after a horse has been chosen
	 * @param bettorID
	 * @param horseNumber
	 * @param bet
	 */
	public void bet(String bettorID,  double bet, int horseNumber){
		selectedHorse = horseNumber;
		Date date=java.util.Calendar.getInstance().getTime(); 
		String fecha = date.toString();
		
		initializeFrameRace();

	}
	
	public void saveBet(String idApostador, int idCaballo, double apuesta, boolean gano, String fecha){
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("../files/apuestas.txt");
            pw = new PrintWriter(fichero);

            pw.println(idApostador+";"+idCaballo+";"+apuesta+";"+gano+";"+fecha);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}

	public void initiateHorses(String[] name, String[] path ){
		try {
			for (int i = 0; i < 6; i++) {
				pSelection.initiateHorses(i+1, name[i], path[i]);
				System.out.println(i +" "+ name[i]+" "+path[i]);
			} 
		}  
		catch (IOException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void initializeFrameRace() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FCarrera frame = new FCarrera(selectedHorse);
					panelCarrera = frame;
					panelCarrera.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jpSelection = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jpSelection.setPreferredSize(new java.awt.Dimension(308, 484));
		jpSelection.setVerifyInputWhenFocusTarget(false);

		javax.swing.GroupLayout jpSelectionLayout = new javax.swing.GroupLayout(jpSelection);
		jpSelectionLayout.setHorizontalGroup(
				jpSelectionLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 308, Short.MAX_VALUE)
				);
		jpSelectionLayout.setVerticalGroup(
				jpSelectionLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 492, Short.MAX_VALUE)
				);
		jpSelection.setLayout(jpSelectionLayout);

		jBanner = new JPanel();

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pack();

	}// </editor-fold>                        


	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {


		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>



	}


	// Variables declaration - do not modify                     
	private javax.swing.JPanel jpSelection;
	private JPanel jBanner;

	public void disableBetOptions() {
		// TODO Auto-generated method stub

	}

	public PanelSelection getpSelection() {
		return pSelection;
	}

	public void setpSelection(PanelSelection pSelection) {
		this.pSelection = pSelection;
	}

	public Race getLogic() {
		return logic;
	}

	public void setLogic(Race logic) {
		this.logic = logic;
	}

	public int getSelectedHorse() {
		return selectedHorse;
	}

	public void setSelectedHorse(int selectedHorse) {
		this.selectedHorse = selectedHorse;
	}

	public FCarrera getPanelCarrera() {
		return panelCarrera;
	}

	public void setPanelCarrera(FCarrera panelCarrera) {
		this.panelCarrera = panelCarrera;
	}

	public void loadHorseInfo(String text) {
		horses = logic.getCaballos();
		
		int number = -1;
		int raceswon = -1;
		String path = "";
		
		if(text.equals(horses.get(0).getName())){
			number = horses.get(0).getNumber(); raceswon = horses.get(0).getWonRaces(); path = horses.get(0).getIconImage();
		}else if(text.equals(horses.get(1).getName())){
			number = horses.get(1).getNumber(); raceswon = horses.get(1).getWonRaces();path = horses.get(1).getIconImage();
		}else if(text.equals(horses.get(2).getName())){
			number = horses.get(2).getNumber(); raceswon = horses.get(2).getWonRaces();path = horses.get(2).getIconImage();
		}else if(text.equals(horses.get(3).getName())){
			number = horses.get(3).getNumber(); raceswon = horses.get(3).getWonRaces();path = horses.get(3).getIconImage();
		}else if(text.equals(horses.get(4).getName())){
			number = horses.get(4).getNumber(); raceswon = horses.get(4).getWonRaces();path = horses.get(4).getIconImage();
		}else if(text.equals(horses.get(5).getName())){
			number = horses.get(5).getNumber(); raceswon = horses.get(5).getWonRaces();path = horses.get(5).getIconImage();
		}
		
		
		pHorseInfo.loadHorseInfo(text, number, raceswon, path);
		
	}


}
