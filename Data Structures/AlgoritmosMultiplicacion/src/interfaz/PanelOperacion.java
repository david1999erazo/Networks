package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelOperacion extends JPanel implements ActionListener{

	public static final String LIMPIAR = "Limpiar";
	
	private JButton butLimpiar;
	
	private JTextField txtNumUno;
	private JTextField txtNumDos;
	private JTextArea txtAreaResultado;
	
	
	private JLabel labMultiplicacion;
	private JLabel labResultado;
	
	private InterfazPrincipal principal;
	
	
	public PanelOperacion(InterfazPrincipal principal) {
		this.principal = principal;
		
		
		TitledBorder operaciones = BorderFactory.createTitledBorder("Operaciones");
		operaciones.setTitleColor(Color.BLACK);
		setBorder(operaciones);
	
		butLimpiar = new JButton("Limpiar");
		butLimpiar.addActionListener(this);
		butLimpiar.setActionCommand(LIMPIAR);
		

		
		txtNumUno = new JTextField("");
		txtNumDos = new JTextField("");
		txtAreaResultado = new JTextArea();
		

	     
	     JScrollPane scroll = new JScrollPane(txtAreaResultado);
		
		txtNumUno.setFont(new java.awt.Font("Tahoma", 0, 20));
		txtNumDos.setFont(new java.awt.Font("Tahoma", 0, 20));
		txtAreaResultado.setFont(new java.awt.Font("Tahoma", 0, 20));
		
		
		txtAreaResultado.setEditable(false);
		
		
		labMultiplicacion = new JLabel("x");
		labResultado = new JLabel("=");
		labMultiplicacion.setFont(new java.awt.Font("Tahoma", 0, 20));
		labResultado.setFont(new java.awt.Font("Tahoma", 0, 20));
		
		
		setLayout(new GridLayout(6, 1));
		
		add(txtNumUno);
		add(labMultiplicacion);
		add(txtNumDos);
		add(labResultado);
		this.add(scroll, BorderLayout.CENTER);
		add(butLimpiar);
		
		
		
	}
	
	public String darNumero1() {
		String numero="";
		numero = txtNumUno.getText();
		return numero;
	}
	
	public String darNumero2() {
		String numero="";
		numero = txtNumDos.getText();
		return numero;
	}
	
	
	
	public void refrescarResultado(String resutlado) {
		
		//txtResultado.setText(resutlado);
		txtAreaResultado.setText(resutlado);
		
	}
	
	
	public void limparCampos() {
		
		txtNumUno.setText("");
		txtNumDos.setText("");
		//txtResultado.setText("");
		txtAreaResultado.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comant = e.getActionCommand();
		if(comant.equals(LIMPIAR)) {
			limparCampos();
			principal.getPanelProceso().limpiarText();
			
		}
		
	}
	
	
	
	
	
	
	
}
