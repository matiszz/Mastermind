package com.prop.presentacio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

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
		
		JButton bback = new JButton("Menú Principal");
		bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaMenuPrincipal nv = new VistaMenuPrincipal();
				nv.setVisible(true);
				VistaAjuda.this.dispose();
			}
		});
		 bback.setBounds(21, 6, 117, 29);
		contentPane.add( bback);
		
		JTextArea text = new JTextArea();
		text.setText("Regles del joc:\nEl joc consisteix en que el codeMaker estableix una combinació de colors i el codeMaker ha d’endivinar-la amb el mínim número d’intents a partir de les respostes del codeMaker a cada codi proposat. Així el codeMaker respon amb una pica negra si la posició y el color es correcte. La pica serà de color blanc en cas que el color sigui correcte però no la posició y per últim no hi haurà cap pica si el color y la posició son erronis. Cal tenir en compte que l’ordre de les piques no ha d’estar relacionat amb la posició del codi proposat.\n\nCom jugar:\nPrimerament cal registrar-se o fer login. Llavos el jugador ja està en condicions de començar o reanudar una partida. \nUn cop dins la partida en cas de ser CodeMaker no hi ha interacció per part de l’usuari. En cas de ser codeBreaker el jugador ha de fer click en el color y posteriorment fer click a la posició on el vulgui col·locar. \nEn cap cas pot haver-hi una posició buida i s’ha de premer el botó confirmar per realitzar la jugada actual.\n\nInformació útil:\nEl ranking contindrà les 10 millor puntuacions de cada dificultat. I al fer un clic sobre la opció Ranking es mostrarà la posició seguidament l’alies del jugador que l’ha realitzat i per últim la puntuació.\nLa puntuació serà el número de intents de forma que com menor sigui el número d’intents millor posició obtindrà al ranking.\nEl ranking només serà pel mode CodeBreaker.\n\n");
		text.setEditable(false);
		text.setBounds(-1195, 61, 430, 156);
		contentPane.add(text);
		
		JScrollPane scroll = new JScrollPane(text);
		scroll.setLocation(10,35);
		scroll.setSize(434, 237);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
	}

}
