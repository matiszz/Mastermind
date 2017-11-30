package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaMenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMenuPrincipal frame = new VistaMenuPrincipal();
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
	public VistaMenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bjugarpartida = new JButton("Jugar Partida");
		bjugarpartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaNovaPartidaoReanudar nv = new VistaNovaPartidaoReanudar();
				nv.setVisible(true);
				VistaMenuPrincipal.this.dispose();
			}
		});
		bjugarpartida.setBounds(160, 53, 117, 29);
		contentPane.add(bjugarpartida);
		
		JButton bregistrarse = new JButton("Registrar-se");
		bregistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaRegistrarse nv = new VistaRegistrarse();
				nv.setVisible(true);
				VistaMenuPrincipal.this.dispose();
			}
		});
		bregistrarse.setBounds(160, 95, 117, 29);
		contentPane.add(bregistrarse);
		
		JButton bRanking = new JButton("Ranking");
		bRanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaRanking nv = new VistaRanking();
				nv.setVisible(true);
				VistaMenuPrincipal.this.dispose();
			}
		});
		bRanking.setBounds(160, 136, 117, 29);
		contentPane.add(bRanking);
		
		JLabel lblBenvingutAMastermind = new JLabel("Benvingut a MasterMind");
		lblBenvingutAMastermind.setBounds(142, 25, 185, 16);
		contentPane.add(lblBenvingutAMastermind);
		
		JLabel linformacio = new JLabel("Informació");
		linformacio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaInformacio nv = new VistaInformacio();
				nv.setVisible(true);
				VistaMenuPrincipal.this.dispose();
			}
		});
		linformacio.setBounds(33, 256, 75, 16);
		contentPane.add(linformacio);
		
		JLabel lajuda = new JLabel("Ajuda");
		lajuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaAjuda nv = new VistaAjuda();
				nv.setVisible(true);
				VistaMenuPrincipal.this.dispose();
			}
		});
		lajuda.setBounds(120, 256, 61, 16);
		contentPane.add(lajuda);
	}
}
