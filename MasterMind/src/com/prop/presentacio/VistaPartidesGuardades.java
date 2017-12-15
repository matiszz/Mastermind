package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.List;

public class VistaPartidesGuardades extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPartidesGuardades frame = new VistaPartidesGuardades();
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
	public VistaPartidesGuardades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTornar = new JButton("Tornar");
		btnTornar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaNovaPartidaoReanudar nv = new VistaNovaPartidaoReanudar();
				nv.setVisible(true);
				VistaPartidesGuardades.this.dispose();
			}
		});
		btnTornar.setBounds(16, 6, 117, 29);
		contentPane.add(btnTornar);
		ControladorDePresentacio ctrl = new ControladorDePresentacio();
		String[] elementos = ctrl.getIdPartidesGuardades();
		List list = new List();
		for(int i = 0; i < elementos.length;++i)
			list.add(elementos[i]);
		list.setBounds(38, 41, 366, 227);
		
		contentPane.add(list);
		
		
		
	}
}
