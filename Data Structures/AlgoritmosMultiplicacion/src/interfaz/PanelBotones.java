package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel implements ActionListener {

	
	public static final String KARATSUBA = "Karatsuba";
	public static final String BINARIA = "Binaria";
	public static final String TRADICIONAL = "Tradicional";
	
	
	
	private JButton btKaratsuba;
	private JButton btBinaria;
	private JButton btTradicional;
	
	private InterfazPrincipal principal;
	
	
	
	
	
	public PanelBotones(InterfazPrincipal principal) {
	
		this.principal = principal;
		
		TitledBorder opciones = BorderFactory.createTitledBorder("Opciones");
		opciones.setTitleColor(Color.BLACK);
		setBorder(opciones);
		
		btKaratsuba = new JButton("Algoritmo de Karatsuba");
		btBinaria = new JButton("Multiplicación Binaria");
		btTradicional = new JButton("Multiplicación Tradicional");
		
		
		btBinaria.setActionCommand(BINARIA);
		btTradicional.setActionCommand(TRADICIONAL);
		btKaratsuba.setActionCommand(KARATSUBA);
		
		btBinaria.addActionListener(this);
		btTradicional.addActionListener(this);
		btKaratsuba.addActionListener(this);
		
		
		
		setLayout(new GridLayout(1, 3));
		
		add(btKaratsuba);
		add(btBinaria);
		add(btTradicional);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comant = e.getActionCommand();
		
		if(comant.equals(KARATSUBA)) {
			principal.algoritmoKaratsuba(principal.getPanelOperacion().darNumero1(), principal.getPanelOperacion().darNumero2());
		}
		if(comant.equals(BINARIA)) {
			principal.multiplicacionBinaria(principal.getPanelOperacion().darNumero1(), principal.getPanelOperacion().darNumero2());
		}
		if(comant.equals(TRADICIONAL)) {
			principal.multiplicacionTradicional(principal.getPanelOperacion().darNumero1(), principal.getPanelOperacion().darNumero2());
		}
		
	}

	
	
	
	
}
