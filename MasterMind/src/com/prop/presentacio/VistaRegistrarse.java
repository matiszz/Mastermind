package com.prop.presentacio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class VistaRegistrarse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistrarse frame = new VistaRegistrarse();
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
	public VistaRegistrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMenPrincipal = new JButton("Menú Principal");
		btnMenPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaMenuPrincipal nv = new VistaMenuPrincipal();
				nv.setVisible(true);
				VistaRegistrarse.this.dispose();
			}
		});
		btnMenPrincipal.setBounds(6, 6, 117, 29);
		contentPane.add(btnMenPrincipal);
		
		textField = new JTextField();
		textField.setBounds(143, 79, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIntrodueixElTeu = new JLabel("Introdueix el teu alies");
		lblIntrodueixElTeu.setBounds(143, 51, 146, 16);
		contentPane.add(lblIntrodueixElTeu);
		
		JLabel labelSeleccionat = new JLabel("L'alies seleccionat ja existeix");
		labelSeleccionat.setForeground(Color.RED);
		labelSeleccionat.setBounds(118, 114, 202, 16);
		labelSeleccionat.setVisible(false);
		contentPane.add(labelSeleccionat);
		
		JLabel labelerror = new JLabel("L'alies seleccionat no existeix");
		labelerror.setForeground(Color.RED);
		labelerror.setBounds(118, 114, 202, 16);
		labelerror.setVisible(false);
		contentPane.add(labelerror);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControladorDePresentacio c = new ControladorDePresentacio();
				boolean b = c.clickRegistrarse(lblIntrodueixElTeu.getText());
				if(b) { //Sijugador creat
					VistaNovaPartidaoReanudar nova = new VistaNovaPartidaoReanudar();
					nova.setVisible(true);
					VistaRegistrarse.this.dispose();
				}
				else { //Si no s'ha creat vol dir que ja existia
					labelSeleccionat.setVisible(true);
				}
				
			}
		});
		btnRegistrar.setBounds(260, 142, 117, 29);
		contentPane.add(btnRegistrar);
		
		JButton btnIniciarSessi = new JButton("Iniciar sessió");
		btnIniciarSessi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControladorDePresentacio c = new ControladorDePresentacio();
				boolean b = c.clickIniciarSessio(lblIntrodueixElTeu.getText());
				if(!b) labelerror.setVisible(true);
				VistaNovaPartidaoReanudar nova = new VistaNovaPartidaoReanudar();
				nova.setVisible(true);
				VistaRegistrarse.this.dispose();
			}
		});
		btnIniciarSessi.setBounds(41, 142, 117, 29);
		contentPane.add(btnIniciarSessi);
		
		
	}
}
