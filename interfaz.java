import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class interfaz
{
	static public void main(String[]args)
	{	
		JPanel panelDisplay = new JPanel();
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setLocation(0,0);
		JLabel lblPassoword = new JLabel("Clave");
		lblPassoword.setLocation(100,0);
		
		JTextField txtUsuario = new JTextField(20);
		txtUsuario.setLocation(15,0);
		JTextField txtPassword = new JTextField(20);
		txtPassword.setLocation(15,10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setLocation(20,20);
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setLocation(40,20);
		
		panelDisplay.add(lblUsuario);
		panelDisplay.add(txtUsuario);
		panelDisplay.add(lblPassoword);
		panelDisplay.add(txtPassword);
		panelDisplay.add(btnCancelar);
		panelDisplay.add(btnOk);
		
		JFrame ventana = new JFrame("Ingreso");
		ventana.setContentPane(panelDisplay );
		ventana.setSize(400,400);
		ventana.setLocation(200,200);
		ventana.setVisible(true);
	}
}