package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class VistaRanking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRanking frame = new VistaRanking();
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
	public VistaRanking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRanking = new JLabel("New label");
		lblRanking.setBounds(16, 35, 414, 237);
		contentPane.add(lblRanking);
		
		ControladorDePresentacio ctrl = new ControladorDePresentacio();
		String[][]ranking = ctrl.demana_ranking();
		String text = "";
		for(int i = 0; i < ranking.length;++i) {
			for(int j = 0; j < 3;++i) {
				text += ranking[i][j];
			}
			text +="\n";
		}
		lblRanking.setText(text);
		lblRanking.setVisible(true);
		
		
		JButton btnMenPrincipal = new JButton("Menú Principal");
		btnMenPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaMenuPrincipal nv = new VistaMenuPrincipal();
				nv.setVisible(true);
				VistaRanking.this.dispose();
			}
		});
		btnMenPrincipal.setBounds(6, 6, 117, 29);
		contentPane.add(btnMenPrincipal);
		
		
	}
}
