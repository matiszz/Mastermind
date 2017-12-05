package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaNovaPartidaoReanudar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNovaPartidaoReanudar frame = new VistaNovaPartidaoReanudar();
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
	public VistaNovaPartidaoReanudar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelleccionaSiVols = new JLabel("Fes click sobre la opció desitjada");
		lblSelleccionaSiVols.setBounds(133, 47, 252, 16);
		contentPane.add(lblSelleccionaSiVols);
		
		JButton nova_partida = new JButton("Nova Partida");
		nova_partida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaDificultatiMode nv = new VistaDificultatiMode();
				nv.setVisible(true);
				VistaNovaPartidaoReanudar.this.dispose();
			}
		});
		nova_partida.setBounds(163, 86, 154, 29);
		contentPane.add(nova_partida);
		
		JButton reanudar = new JButton("Continuar partida");
		reanudar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaPartidesGuardades nv = new VistaPartidesGuardades();
				nv.setVisible(true);
				VistaNovaPartidaoReanudar.this.dispose();
			}
		});
		reanudar.setBounds(163, 136, 154, 29);
		contentPane.add(reanudar);
		
		JButton btnMenPrincipal = new JButton("Menú Principal");
		btnMenPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaMenuPrincipal nv = new VistaMenuPrincipal();
				nv.setVisible(true);
				VistaNovaPartidaoReanudar.this.dispose();
			}
		});
		btnMenPrincipal.setBounds(19, 6, 117, 29);
		contentPane.add(btnMenPrincipal);
	}
}
