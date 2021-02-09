import java.util.Scanner;

class Ejercicio37{
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[]args){
		int numero = 0;
		System.out.println("Ingrese un numero como límite de la suma");
		numero = teclado.nextInt();
		teclado.nextLine();
		System.out.println("El resultado de la suma es: " + Suma(numero));
	}
	
	public static int Suma(int numero){
		if (numero == 0){
			return 0;
		}
		else if(numero == 1){
			return 1;
		}
		else{
			return numero + Suma(numero-1);
		}
	}
}