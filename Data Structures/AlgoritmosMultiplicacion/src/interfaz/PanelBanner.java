package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBanner extends JPanel {

	private JLabel espacio;
	
	public PanelBanner() {
		
		TitledBorder banner = BorderFactory.createTitledBorder("");
		banner.setTitleColor(Color.BLACK);
		setBorder(banner);
		
		
		espacio = new JLabel("ALGORITMOS DE MULTIPLICACIÓN");
		espacio.setFont(new java.awt.Font("Tahoma",0,40));
		
		setLayout(new BorderLayout());
		add(espacio, BorderLayout.CENTER);
		
	}
	
	
	
}
