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

public class VistaPartida extends JFrame {

	private JPanel contentPane;
	private Color c = new Color(255, 255, 255);

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
		Tauler.setBounds(10, 30, 100, 560);
		contentPane.add(Tauler);
		GridBagLayout gbl_Tauler = new GridBagLayout();
		gbl_Tauler.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_Tauler.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_Tauler.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Tauler.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Tauler.setLayout(gbl_Tauler);
		
		JCheckBox c1 = new JCheckBox("");
		c1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				c1.setBackground(c);
			}
		});
		GridBagConstraints gbc_c1 = new GridBagConstraints();
		gbc_c1.insets = new Insets(0, 0, 5, 5);
		gbc_c1.gridx = 0;
		gbc_c1.gridy = 19;
		Tauler.add(c1, gbc_c1);
		
		JCheckBox c2 = new JCheckBox("");
		c2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c2.setBackground(c);
			}
		});
		GridBagConstraints gbc_c2 = new GridBagConstraints();
		gbc_c2.insets = new Insets(0, 0, 5, 5);
		gbc_c2.gridx = 1;
		gbc_c2.gridy = 19;
		Tauler.add(c2, gbc_c2);
		
		JCheckBox c3 = new JCheckBox("");
		c3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c3.setBackground(c);
			}
		});
		GridBagConstraints gbc_c3 = new GridBagConstraints();
		gbc_c3.insets = new Insets(0, 0, 5, 5);
		gbc_c3.gridx = 2;
		gbc_c3.gridy = 19;
		Tauler.add(c3, gbc_c3);
		
		JCheckBox c4 = new JCheckBox("");
		c4.setForeground(Color.ORANGE);
		c4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c4.setBackground(c);
			}
		});
		GridBagConstraints gbc_c4 = new GridBagConstraints();
		gbc_c4.insets = new Insets(0, 0, 5, 0);
		gbc_c4.gridx = 3;
		gbc_c4.gridy = 19;
		Tauler.add(c4, gbc_c4);
		
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

				verde.setBackground(Color.BLUE);
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
