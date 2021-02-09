import java.util.Random;
import java.util.Scanner;
import java.io.*;


public class Main {
    static File archivo = null;
    static FileReader fr = null;
    static BufferedReader br = null;

    static Scanner teclado = new Scanner(System.in);
    static Random r = new Random();
    
    static int[] numeros = new int[3];
    
    public static void main(String[] args) {
        
    int opcion, condicion = 0, acumulador=0,contadorEspacios=0;
    double total50, total25, total10, total1, totalQ;
    String Nombre, Nombre1="", Nombre2="", Apellido1="", Apellido2="", caracter;
    
    while (condicion == 0)
    {
        System.out.print("Menú de opciones\n1.Lanzamiento de dados\n2.Contador de monedoas\n3.Contador de letras de nombres de estudiantes\n4.Calculador de promedios\n5.Salir\nIngese una opcion: ");
        opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion)
        {
            case 1:
                acumulador = 0;
                for  (int x = 0; x < 3; x++)
                {
                    numeros[x] = r.nextInt(6)+1;
                    acumulador += numeros[x];
                }
                System.out.println("Primer lanzamiento: " + numeros[0]);
                System.out.println("Segundo lanzamiento: " + numeros[1]);
                System.out.println("Tercer lanzamiento: " + numeros[2]);
                System.out.println("Total: " + acumulador);
                break;
            case 2:
                System.out.print("Ingrese el total de monedas de 0.50 Centavos: ");
                total50 = teclado.nextFloat();
                System.out.print("Ingrese el total de monedas de 0.25 Centavos: ");
                total25 = teclado.nextFloat();
                System.out.print("Ingrese el total de monedas de 0.10 Centavos: ");
                total10 = teclado.nextFloat();
                System.out.print("Ingrese el total de monedas de 0.01 Centavo: ");
                total1 = teclado.nextFloat();
                totalQ = (total50 * 0.5) + (total25 * 0.25) + (total10 * 0.10) + (total1 * 0.01);
                System.out.println("El total en Quetzales es de: Q." + totalQ );
                break;
            case 3:
                System.out.print("Ingrese el nombre del estudiante: ");
                Nombre = teclado.nextLine();
                for(int x = 0; x < Nombre.length();x++)
                {
                    caracter = Nombre.substring(x,(x+1));
                    if (!" ".equals(caracter))
                    {
                        switch (contadorEspacios) {
                            case 0:
                                Nombre1 += caracter;
                                break;
                            case 1:
                                Nombre2 += caracter;
                                break;
                            case 2:
                                Apellido1 += caracter;
                                break;
                            case 3:
                                Apellido2 += caracter;
                                break;
                        }
                    }
                    else
                    {
                        contadorEspacios += 1;
                    }
                }
                switch(contadorEspacios)
                {
                    case 0:
                        System.out.println(Nombre1 + " contiene: " + Nombre1.length() + " letras" );
                        break;
                    case 1:
                        System.out.println(Nombre1 + " contiene: " + Nombre1.length() + " letras" );
                        System.out.println(Nombre2 + " contiene: " + Nombre2.length() + " letras" );
                        break;
                    case 2:
                        System.out.println(Nombre1 + " contiene: " + Nombre1.length() + " letras" );
                        System.out.println(Nombre2 + " contiene: " + Nombre2.length() + " letras" );
                        System.out.println(Apellido1 + " contiene: " + Apellido1.length() + " letras" );
                        break;
                    case 3:
                        System.out.println(Nombre1 + " contiene: " + Nombre1.length() + " letras" );
                        System.out.println(Nombre2 + " contiene: " + Nombre2.length() + " letras" );
                        System.out.println(Apellido1 + " contiene: " + Apellido1.length() + " letras" );
                        System.out.println(Apellido2 + " contiene: " + Apellido2.length() + " letras" );
                        break;
                }
                break;
            case 4:
                int contadorLineas=0, promedio = 0;
                String nombre="", nota1="",nota2="", nota3="", nombreArchivo="";
                System.out.print("Ingrese el nombre del archivo del cual desea extraer los datos (El archivo debe encontrarse en la misma carpeta del programa): ");
                nombreArchivo = teclado.next();
                try
                {
                    archivo = new File (nombreArchivo + ".txt");
                    fr = new FileReader (archivo);
                    br = new BufferedReader(fr);
                    String linea;
                    while((linea=br.readLine())!=null)
                    {
                        contadorLineas += 1;
                        switch (contadorLineas)
                        {
                            case 1:
                                nombre = linea;
                                break;
                            case 2:
                                nota1 = linea;
                                break;
                            case 3:
                                nota2 = linea;
                                break;
                            case 4:
                                nota3 = linea;
                                break;
                        }
                    }
                    promedio = (Integer.parseInt(nota1)+Integer.parseInt(nota2)+Integer.parseInt(nota3))/3;
                    System.out.println("El estudiante: " + nombre + " tiene " + promedio + " de promedio");
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }finally{
                 try{                    
                    if( null != fr ){   
                       fr.close();     
                    }                  
                 }catch (Exception e2){ 
                    e2.printStackTrace();
                 }
                }
                break;
            case 5:
                System.out.println("Gracias por utilizar este programa");
                condicion = 1;
                break;
            default:
                System.out.println("Por favor ingerese una opción valida");
                break;
        }
    }
    
    }
    
}
