package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class VistaPartida extends JFrame {

	private JPanel contentPane;
	private Color c = new Color(238, 238, 238);
	private int lastFila = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPartida frame = new VistaPartida();
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
	public VistaPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Tauler = new JPanel();
		Tauler.setBounds(10, 30, 212, 450);
		contentPane.add(Tauler);
		GridBagLayout gbl_Tauler = new GridBagLayout();
		gbl_Tauler.columnWidths = new int[]{30, 30, 30, 30, 30, 30, 0, 30, 0};
		gbl_Tauler.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_Tauler.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Tauler.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Tauler.setLayout(gbl_Tauler);
		
		JButton btnCheck = new JButton("Check");
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				++lastFila;
				gbc_btnCheck.gridy = 4;
			}
		});
		gbc_btnCheck.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheck.gridx = 5;
		gbc_btnCheck.gridy = lastFila;
		Tauler.add(btnCheck, gbc_btnCheck);
		
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 15; j++) {
				JRadioButton r1 = new JRadioButton("");
				r1.setSize(140, 140);
				r1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (r1.isSelected()) r1.setBackground(c);
						else r1.setBackground(new Color(238, 238, 238));
					}
				});
				GridBagConstraints gbc_r1 = new GridBagConstraints();
				gbc_r1.insets = new Insets(0, 0, 5, 5);
				gbc_r1.gridx = i;
				gbc_r1.gridy = j;
				Tauler.add(r1, gbc_r1);
			}
		}
		
		JPanel Colors = new JPanel();
		Colors.setBounds(234, 173, 152, 56);
		contentPane.add(Colors);
		GridBagLayout gbl_Colors = new GridBagLayout();
		gbl_Colors.columnWidths = new int[]{30, 30, 30, 30};
		gbl_Colors.rowHeights = new int[]{30};
		gbl_Colors.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_Colors.rowWeights = new double[]{0.0};
		Colors.setLayout(gbl_Colors);
		
		JButton rojo = new JButton("");
		rojo.setBackground(Color.RED);
		rojo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c = Color.RED;
			}
		});
		GridBagConstraints gbc_rojo = new GridBagConstraints();
		gbc_rojo.insets = new Insets(0, 0, 0, 5);
		gbc_rojo.anchor = GridBagConstraints.NORTHWEST;
		gbc_rojo.gridx = 0;
		gbc_rojo.gridy = 0;
		Colors.add(rojo, gbc_rojo);
		
		JButton verde = new JButton("");
		verde.setBackground(Color.GREEN);
		verde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c = Color.GREEN;
			}
		});
		GridBagConstraints gbc_verde = new GridBagConstraints();
		gbc_verde.insets = new Insets(0, 0, 0, 5);
		gbc_verde.anchor = GridBagConstraints.NORTHWEST;
		gbc_verde.gridx = 1;
		gbc_verde.gridy = 0;
		Colors.add(verde, gbc_verde);
		
		JButton amarillo = new JButton("");
		amarillo.setBackground(Color.YELLOW);
		amarillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c = Color.YELLOW;
			}
		});
		GridBagConstraints gbc_amarillo = new GridBagConstraints();
		gbc_amarillo.insets = new Insets(0, 0, 0, 5);
		gbc_amarillo.anchor = GridBagConstraints.NORTHWEST;
		gbc_amarillo.gridx = 2;
		gbc_amarillo.gridy = 0;
		Colors.add(amarillo, gbc_amarillo);
		
		JButton azul = new JButton("");
		azul.setBackground(Color.BLUE);
		azul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c = Color.BLUE;
			}
		});
		GridBagConstraints gbc_azul = new GridBagConstraints();
		gbc_azul.insets = new Insets(0, 0, 0, 5);
		gbc_azul.anchor = GridBagConstraints.NORTHWEST;
		gbc_azul.gridx = 3;
		gbc_azul.gridy = 0;
		Colors.add(azul, gbc_azul);
		
	}
}
