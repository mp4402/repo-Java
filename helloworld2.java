import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class helloworld2
{
	static class HelloDisplay extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString("Hello World", 20, 30);
		}
	}
	
	private static class btnHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[]args)
	{
		//Crea la instancia del panel
		HelloDisplay displayPanel = new HelloDisplay();
		
		//Creación de un textfield
		JTextField txtUsuario = new JTextField(25);
		
		btnHandler BtnHandler = new btnHandler();
		//Creación de un botón
		JButton btnUsuario = new JButton("Ok");
		
		btnUsuario.addActionListener(BtnHandler);
		
		//El textfield y el boton son añadidos al panel
		displayPanel.add(txtUsuario);
		displayPanel.add(btnUsuario);
		
		//Se crea una instancia de una ventana
		JFrame ventana = new JFrame("Progra 2");
		//Se establece que Panel estará dentro de "ventana"
		ventana.setContentPane(displayPanel);
		//Se instancia el tamaño de "ventana"
		ventana.setSize(400,400);
		//Se instancia la localización en ventana de "ventana"
		ventana.setLocation(200,200);
		//Se instancia como verdadera la visualización de "ventana"
		ventana.setVisible(true);
	}
}