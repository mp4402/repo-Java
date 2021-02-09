import java.util.Scanner;
//Aquí van los imports

class mainRecursion{
	//Aquí se definen las variables static
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[]args){
		//Aquí va el codigo de la clase
		int opcion=0,condicion=0,numero=0,resultado=0;
		while (condicion==0){
			System.out.println("Menu\nElija una opcion\n1.Suma\n2.Factorial\n3.Salir");
			opcion = teclado.nextInt();
			teclado.nextLine();
			switch(opcion){
				case 1:
					System.out.println("Ingrese un numero para el limite de la suma");
					numero = teclado.nextInt();
					teclado.nextLine();
					System.out.println("El resultado de la suma es: " + Suma(numero));
					break;
				case 2:
					System.out.println("Ingrese un numero para calcular su factorial");
					numero = teclado.nextInt();
					teclado.nextLine();
					System.out.println("El factorial de " + numero + " es: " + Factorial(numero));
					break;
				case 3:
					condicion = 1;
					break;
				default:
					System.out.println("Ingrese una opcion valida por favor");
					break;
			}
		}
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
	public static int Factorial(int numero){
		if ( numero <= 1 ) {
			return 1;
		} 
		else {
			return numero*Factorial(numero-1);
		}
	}
}