package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelProceso extends JPanel {

	
	private JTextArea txtArea;
	
	
	public PanelProceso () {
		
		TitledBorder proceso = BorderFactory.createTitledBorder("Procedimiento");
		proceso.setTitleColor(Color.BLACK);
		setBorder(proceso);
		
		
		txtArea = new JTextArea();
		txtArea.setFont(new java.awt.Font("Tahoma", 0, 20));
		
		JScrollPane scroll = new JScrollPane(txtArea);
		
		setLayout(new BorderLayout());
	
		add(scroll, BorderLayout.CENTER);
		
		
	}
	
	public void refrescarText(String m){
		txtArea.setText(m);
	}
	public void refrescarTradicional(StringBuilder m) {
		txtArea.setText(m.toString());
	}
	
	public void limpiarText() {
		txtArea.setText(" ");
	}
	
	
}
