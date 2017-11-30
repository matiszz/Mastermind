package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaInformacio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAjuda frame = new VistaAjuda();
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
	public VistaInformacio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bback = new JButton("Menu Principal");
		bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaMenuPrincipal nv = new VistaMenuPrincipal();
				nv.setVisible(true);
				VistaInformacio.this.dispose();
			}
		});
		 bback.setBounds(21, 6, 117, 29);
		contentPane.add( bback);
		
		JLabel lblNewLabel = new JLabel("Esta aplicación ha sido creada por Matías, Sergi y Raúl");
		lblNewLabel.setBounds(41, 94, 357, 85);
		contentPane.add(lblNewLabel);
	}

}