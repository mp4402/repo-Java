import java.util.Scanner;

class holaMundo{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[]args){
        String hola="";
        System.out.print("Ingrese una cadena: ");
        hola = teclado.nextLine();
		System.out.print("Respuesta de cadena: " + hola);
	}
}