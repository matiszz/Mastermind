package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaDificultatiMode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaDificultatiMode frame = new VistaDificultatiMode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaDificultatiMode() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionaUnMode = new JLabel("Selecciona un mode de joc");
		lblSeleccionaUnMode.setBounds(131, 39, 180, 16);
		contentPane.add(lblSeleccionaUnMode);
		
		JRadioButton rdbtnCodebreaker = new JRadioButton("Code Breaker");
		rdbtnCodebreaker.setBounds(170, 66, 141, 23);
		rdbtnCodebreaker.setActionCommand("Codebreaker");
		contentPane.add(rdbtnCodebreaker);
		
		JRadioButton rdbtnCodeMaker = new JRadioButton("Code Maker");
		rdbtnCodeMaker.setBounds(170, 101, 141, 23);
		rdbtnCodeMaker.setActionCommand("CodeMaker");
		contentPane.add(rdbtnCodeMaker);
		
		ButtonGroup grupMode = new ButtonGroup();
		grupMode.add(rdbtnCodeMaker);
		grupMode.add(rdbtnCodebreaker);

		JLabel lblSeleccionaUnaDificultat = new JLabel("Selecciona una dificultat");
		lblSeleccionaUnaDificultat.setBounds(131, 136, 180, 16);
		contentPane.add(lblSeleccionaUnaDificultat);
		
		JRadioButton rdbtnFcil = new JRadioButton("Fàcil");
		rdbtnFcil.setBounds(170, 164, 141, 23);
		rdbtnFcil.setActionCommand("Facil");
		contentPane.add(rdbtnFcil);
		
		JRadioButton rdbtnMitjana = new JRadioButton("Mitjana");
		rdbtnMitjana.setBounds(170, 199, 141, 23);
		rdbtnMitjana.setActionCommand("Mitjana");
		contentPane.add(rdbtnMitjana);
		
		JRadioButton rdbtnDifcil = new JRadioButton("Difícil");
		rdbtnDifcil.setBounds(170, 234, 141, 23);
		rdbtnDifcil.setActionCommand("Dificil");
		contentPane.add(rdbtnDifcil);
		
		ButtonGroup grupDificultat = new ButtonGroup();
		grupDificultat.add(rdbtnFcil);
		grupDificultat.add(rdbtnMitjana);
		grupDificultat.add(rdbtnDifcil);
		
		JButton enrere = new JButton("Tornar");
		enrere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaNovaPartidaoReanudar nv = new VistaNovaPartidaoReanudar();
				nv.setVisible(true);
				VistaDificultatiMode.this.dispose();
			}
		});
		enrere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enrere.setBounds(2, 6, 117, 29);
		contentPane.add(enrere);
		
		JButton btnComenar = new JButton("Començar");
		btnComenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mode = grupMode.getSelection().getActionCommand();
				String dificultat = grupDificultat.getSelection().getActionCommand();
				System.out.println(mode + " " + dificultat);
				//ControladorDePresentacio c = new ControladorDePresentacio();
				//c.crearPartida(mode,dificultat);
			}
		});
		btnComenar.setBounds(323, 243, 117, 29);
		contentPane.add(btnComenar);
	}
}
