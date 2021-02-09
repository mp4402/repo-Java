import java.util.Scanner;

class Ejercicio38{
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[]args){
		int numero = 0;
		System.out.println("Ingrese un numero para calcular su factorial");
		numero = teclado.nextInt();
		teclado.nextLine();
		System.out.println("El factorial de " + numero + "es: " + Factorial(numero));
	}
	
	public static int Factorial(int numero){
		if ( numero <= 1 ) {
			return 1;
		} 
		else {
			return numero*Factorial(numero-1);
		}
	}
}