import java.util.Scanner;
import java.util.LinkedList;

public class Overloading {
    static LinkedList<Puerta> Puertas = new LinkedList<Puerta>();
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion=0,condicion=0,NoPuerta=0,espacio,NumeroPuertaInt=0;
        String orden = "",NumeroPuertaString="";
        boolean estado=false;
        
        Puerta puertita = new Puerta(0,estado);
        Puertas.add(puertita);
        
        while (condicion == 0)
        {
            System.out.println("Bienvido al Sistema de alta seguridad de la Universidad Francisco Marroquín.\n1.Ingresar Puerta.\n2.Mostrar Listado de Puertas.\n3.Abrir Puertas.\n4.Cerrar Puertas\n5.Salir"); 
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                 case 1:
                     NoPuerta++;
                     Puerta door = new Puerta(NoPuerta,estado);
                     Puertas.add(door);
                     System.out.println("Puerta ingresada\n");
                    break;
                 case 2:
                     for (int x = 0; x < Puertas.size();x++)
                     {
                         if ( Puertas.get(x).Estado == true)    
                         {
                             if (x == 0)
                             {
                                 System.out.println("Puerta Principal esta abierta");
                             }
                             else
                             {
                                 System.out.println("Puerta No." + (x) + " esta abierta");
                             }    
                         }
                         else
                         {
                             if (x == 0)
                             {
                                 System.out.println("Puerta Principal esta cerrada");
                             }
                             else
                             {
                                 System.out.println("Puerta No." + (x) + " esta cerrada");
                             }    
                         }
                     }
                     System.out.println();
                    break;
                 case 3:
                     
                    System.out.println("Si desea abrir la puerta principal, ingrese 'Abrir'.\nSi desea abrir una puerta en especifico, ingrese 'Abrir' y el numero de la puerta que desea abrir.");
                    orden = teclado.nextLine();
                    if ("Abrir".equals(orden))
                    {
                        abrir();
                    }
                    else
                    {
                        espacio = orden.indexOf(" ");
                        if ("Abrir".equals(orden.substring(0, espacio)))
                        {
                            NumeroPuertaString = orden.substring(espacio+1, orden.trim().length());
                            NumeroPuertaInt = Integer.parseInt(NumeroPuertaString);
                            abrir(NumeroPuertaInt);
                        }
                        else
                        {
                            System.out.println("Debe introducir la orden correctamente\n");
                        }
                    }
                     
                     break;
                 case 4:
                    
                    System.out.println("Si desea cerrar la puerta principal, ingrese 'Cerrar'.\nSi desea cerrar una puerte en especifico, ingrese 'Cerrar' y el numero de la puerta que desea cerrar");
                    orden = teclado.nextLine();
                    if ("Cerrar".equals(orden))
                    {
                        cerrar();
                    }
                    else
                    {
                        espacio = orden.indexOf(" ");
                        if ("Cerrar".equals(orden.substring(0, espacio)))
                        {
                            NumeroPuertaString = orden.substring(espacio+1, orden.trim().length());
                            NumeroPuertaInt = Integer.parseInt(NumeroPuertaString);
                            cerrar(NumeroPuertaInt);
                        }
                        else
                        {
                            System.out.println("Debe introducir la orden correctamente\n");
                        }
                    }  
                     
                     break;
                 case 5:
                     System.out.println("Gracias por utilizar este método de seguridad");
                     condicion = 1;
                     break;
                 default:
                     System.out.println("Introduzca una opcion valida \n");
                     break;
            }
       }
    }
    static void abrir()
    {
        if (Puertas.get(0).Estado == true)
        {
            System.out.println("La puerta principal ya estaba abierta\n");
        }
        else
        {
            Puertas.get(0).Estado = true;
            System.out.println("Puerta principal abierta\n");
        }
    }
    static void abrir(int NumeroPuerta)
    {
        if (Puertas.get(NumeroPuerta).Estado == true)
        {
            System.out.println("La puerta " + (NumeroPuerta) + " ya estaba abierta\n");
        }
        else
        {
            Puertas.get(NumeroPuerta).Estado = true;
            System.out.println("Puerta número " + (NumeroPuerta) + " abierta\n");
        }
    }
    static void cerrar()
    {
        if (Puertas.get(0).Estado == false)
        {
            System.out.println("La puerta principal ya estaba cerrada\n");
        }
        else
        {
            Puertas.get(0).Estado = false;
            System.out.println("Puerta principal cerrada\n");
        }
    }
    static void cerrar(int NumeroPuerta)
    {
        if (Puertas.get(NumeroPuerta).Estado == false)
        {
            System.out.println("La puerta " + (NumeroPuerta) + " ya estaba cerrada\n");
        }
        else
        {
            Puertas.get(NumeroPuerta).Estado = false;
            System.out.println("Puerta número " + (NumeroPuerta) + " cerrada\n");
        }
    }
}
