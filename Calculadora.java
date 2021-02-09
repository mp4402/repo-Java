import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

class DigiButton extends Button implements ActionListener{
	static int contadorAccion = 0;
	Calculadora calc;
	DigiButton(String buttonLabel, int posX, int posY, int width, int height, Calculadora calc){
		super(buttonLabel);
		setBounds(posX, posY,width,height);
		this.calc = calc;
		this.calc.add(this);
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev){
		if(contadorAccion == 0){
			calc.numberDisplay.setText("");
		}
		String temporal=((DigiButton)ev.getSource()).getLabel();
		if (temporal == "="){
			operar();
		}
		else{
			calc.numberDisplay.setText(calc.numberDisplay.getText()+ temporal);
		}
		contadorAccion++;
	}
	public void operar(){
		String operacion = numberDisplay.getText();
		
	}
}

public class Calculadora extends Frame{
	int control =1;
	Label numberDisplay = new Label("0", Label.RIGHT);
	
	Calculadora (String name){
		super(name);
		numberDisplay.setBounds(20, 20, 300, 35);
		numberDisplay.setBackground(Color.WHITE);
		numberDisplay.setForeground(Color.BLACK);
		add(numberDisplay);
		
		int posX = 70;
		int posY = 240;
		for (int i=0; i < 3; i++){
			for (int x = 0; x < 3; x++)
			{
				new DigiButton(String.valueOf(control), posX*(x+1), posY, 50,50,this);
				control++;		
			}
			posY -= 70;
		}
		posX = 280;
		posY = 100;
		for (int i = 0; i < 4; i++){
			switch(i){
				case 0:
					new DigiButton(String.valueOf("+"), posX, posY, 50,50,this);
				break;
				case 1:
					new DigiButton(String.valueOf("-"), posX, posY, 50,50,this);
				break;
				case 2:
					new DigiButton(String.valueOf("*"), posX, posY, 50,50,this);
				break;
				case 3:
					new DigiButton(String.valueOf("0"), (posX-210), posY, 50,50,this);
					new DigiButton(String.valueOf("."), (posX-140), posY, 50,50,this);
					new DigiButton(String.valueOf("="), (posX-70), posY, 50,50,this);
					new DigiButton(String.valueOf("/"), posX, posY, 50,50,this);
				break;
			}
			posY += 70;
		}
		
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent ev){
				System.exit(0);
				}
			}
		);
		
		setLayout(null);
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new Calculadora("Mi Calculadora");
	}
}