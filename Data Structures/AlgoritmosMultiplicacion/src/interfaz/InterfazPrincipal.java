package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.math.BigInteger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mundo.AlgoritmosMundo;

public class InterfazPrincipal extends JFrame {

	private PanelBanner panelBanner;
	private PanelBotones panelBotones;
	private PanelOperacion panelOperacion;
	private PanelProceso panelProceso;

	// Relación con el mundo
	private AlgoritmosMundo conexionMundo;

	public InterfazPrincipal() {

		conexionMundo = new AlgoritmosMundo();

		setSize(650, 400);
		setTitle("Algoritmos de Multiplicación");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		panelBanner = new PanelBanner();
		panelBotones = new PanelBotones(this);
		panelOperacion = new PanelOperacion(this);
		panelProceso = new PanelProceso();

		setLayout(new BorderLayout());

		add(panelBanner, BorderLayout.NORTH);
		add(panelBotones, BorderLayout.SOUTH);

		JPanel auxCentro = new JPanel();
		auxCentro.setLayout(new GridLayout(1, 2));

		auxCentro.add(panelOperacion);
		auxCentro.add(panelProceso);

		add(auxCentro, BorderLayout.CENTER);

	}

	public void algoritmoKaratsuba(String num1, String num2) {
		String resultado = "";
		try {
			conexionMundo.reiniciarKaratsuba();
			resultado=conexionMundo.getRelacionKaratsuba().multiplicacionDefinitiva(num1, num2);
			panelOperacion.refrescarResultado(resultado);
			panelProceso.refrescarText(conexionMundo.darProcesoKaratsuba());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Por favor verifique que los campos no esten vacios \n o tenga alguna letra ");
		}
		
	}

	public void multiplicacionTradicional(String num1, String num2) {
		String resultado = "";
		try {
			
			resultado=conexionMundo.getRelacionTradicional().tradicional(num1, num2);
			StringBuilder proceso;
			proceso = conexionMundo.getRelacionTradicional().getInstrucciones();
			
			panelProceso.refrescarTradicional(proceso);
			panelOperacion.refrescarResultado(resultado);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Por favor verifique que los campos no esten vacios \n o tengan alguna letra ");
		}
		
	}

	public void multiplicacionBinaria(String num1, String num2) {
		
		try {
			String resultado = "";
			StringBuilder proceso;
			proceso = conexionMundo.getRelacionBinario().getProceso();
			resultado=conexionMundo.getRelacionBinario().binarioDefinitivo(num1, num2);
			panelOperacion.refrescarResultado(resultado);
			panelProceso.refrescarTradicional(proceso);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Por favor verifique que los campos no esten vacios \n o tengan alguna letra");
		}
		
	}

	public PanelOperacion getPanelOperacion() {
		return panelOperacion;
	}
	
	public PanelProceso getPanelProceso() {
		return panelProceso;
	}
	

	public void setPanelOperacion(PanelOperacion panelOperacion) {
		this.panelOperacion = panelOperacion;
	}

	public static void main(String[] args) {

		InterfazPrincipal vent = new InterfazPrincipal();
		vent.setVisible(true);

	}

}
