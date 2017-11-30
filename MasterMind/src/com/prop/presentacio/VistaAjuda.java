package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VistaAjuda extends JFrame {

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
	public VistaAjuda() {
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
				VistaAjuda.this.dispose();
			}
		});
		 bback.setBounds(21, 6, 117, 29);
		contentPane.add( bback);
		
		JLabel lblNewLabel = new JLabel("Vista de ayuda");
		lblNewLabel.setBounds(63, 47, 254, 74);
		contentPane.add(lblNewLabel);
	}

}
