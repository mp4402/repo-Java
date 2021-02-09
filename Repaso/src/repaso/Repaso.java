package repaso;
import repaso.Pelota;
import java.util.Scanner;

public class Repaso 
{   
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        int contador = 0;
        int condicion = 0;
        int opcion = 0;
        Pelota[] pelotas = new Pelota[9];
        while (condicion != 1)
        {
            System.out.println("\nVenta de pelotas \nSeleccione una opción \n1.Agregar nuevo producto \n2.Lista de productos \n3.Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    if (contador <= 9)
                    {
                        pelotas[contador] = new Pelota("",0,"",0);
                        System.out.print("Ingrese la marca de la pelota: ");
                        pelotas[contador].marca = teclado.next();
                        System.out.print("Ingrese el tamaño de la pelota: ");
                        pelotas[contador].tama = teclado.nextInt();
                        System.out.print("Ingrese el deporte de la pelota: ");
                        pelotas[contador].deporte = teclado.next();
                        System.out.print("Ingrese el precio de la pelota: ");
                        pelotas[contador].precioOriginal = teclado.nextInt();
                        contador++;
                    }
                    else
                    {
                        System.out.println("Capacidad rebalsada\n");
                    }
                    break;
                case 2:
                    for (int x = 0; x < contador; x++)
                    {
                        System.out.println("Pelota: " + x+1 + "\nMarca: " + pelotas[x].marca + " \nPrecio: Q." + pelotas[x].precioOriginal + "\nPrecio con descuento: Q." + ((pelotas[x].precioOriginal)-(pelotas[x].precioOriginal)*0.25) + "\nTamaño: " + pelotas[x].tama + "\nDeporte: " + pelotas[x].deporte+ "\n");
                    }
                    break;
                case 3:
                    System.out.println("¡Gracias por utilizar este programa!");
                    condicion = 1;
                    break;
                default:
                    System.out.println("Opción no encontrada, ingrese una nueva opción");
                    break;
            }
        }
    }
    
}
