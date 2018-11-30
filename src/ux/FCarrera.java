package ux;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;

public class FCarrera extends JFrame {

	private JPanel contentPane;
	private int[] coordenadasX;
	private String[] posiciones;
	private int caballoSeleccionado;


	JLabel lblHorse1;
	JLabel lblHorse2;
	JLabel lblHorse3;
	JLabel lblHorse4;
	JLabel lblHorse5;
	JLabel lblHorse6;

	/**
	 * Create the frame.
	 */
	public FCarrera(int selectedHorse) {
		
		caballoSeleccionado=selectedHorse;
		
		setLayout(null);
		
		// Horses' pictures are firstly initialized
		ImageIcon c1 = new ImageIcon("../img/C1.jpg");
		ImageIcon c2 = new ImageIcon("../img/C2.jpg");
		ImageIcon c3 = new ImageIcon("../img/C3.jpg");
		ImageIcon c4 = new ImageIcon("../img/C4.jpg");
		ImageIcon c5 = new ImageIcon("../quiz2Redes1.0/img/C5.jpg");
		ImageIcon c6 = new ImageIcon("../quiz2Redes1.0/img/C6.jpg");
	
		
		coordenadasX = new int[6];
		posiciones = new String[6];
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 641);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		
		JPanel pInfo = new JPanel();
		
		JPanel pBanner = new JPanel();
		pBanner.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pInfo, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
						.addComponent(pBanner, GroupLayout.PREFERRED_SIZE, 863, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pBanner, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pInfo, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenidos a la Competencia de Caballos!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		pBanner.add(lblNewLabel);
		
		JLabel lblHorse1 = new JLabel(" #");
		lblHorse1.setBounds(0, 0, 100, 100);

		lblHorse1.setIcon(new ImageIcon("../images/HORSES/black.gif"));
		
		JLabel lblHorse2 = new JLabel("#");
		lblHorse2.setIcon(new ImageIcon("../images/HORSES/black.gif"));
		
		JLabel lblHorse3 = new JLabel("#");
		lblHorse3.setIcon(new ImageIcon("../images/HORSES/black.gif"));
		
		JLabel lblHorse4 = new JLabel("#");
		lblHorse4.setIcon(new ImageIcon("../images/HORSES/black.gif"));
		
		JLabel lblHorse5 = new JLabel("#");
		lblHorse5.setIcon(new ImageIcon("../images/HORSES/black.gif"));
		
		JLabel lblHorse6 = new JLabel("#");
		lblHorse6.setIcon(new ImageIcon("../images/HORSES/black.gif"));
		
		JLabel lblGoal = new JLabel("Meta");
		lblGoal.setIcon(new ImageIcon("../images/0icons/goal.png"));
		
		lblGoal.setBackground(new Color(107, 142, 35));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHorse1)
						.addComponent(lblHorse2)
						.addComponent(lblHorse3)
						.addComponent(lblHorse4)
						.addComponent(lblHorse5)
						.addComponent(lblHorse6))
					.addPreferredGap(ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
					.addComponent(lblGoal, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblHorse1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblHorse2, 0, 0, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblHorse3, 0, 0, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHorse4, 0, 0, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHorse5, 0, 0, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHorse6, 0, 0, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblGoal, GroupLayout.PREFERRED_SIZE, 548, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	}
	

}
