package celebracionconocimiento;
import java.util.Scanner;
import celebracionconocimiento.Cuestionario;

public class CelebracionConocimiento 
{
    public static void main(String[] args) 
    {
        Scanner teclado =  new Scanner(System.in);
        int condicion = 0;
        int opcion = 0;
        int noPreguntas = 0;
        int respuesta = 0;
        Cuestionario[] preguntas = new Cuestionario[noPreguntas];
        while (condicion == 0)
        {
            System.out.println("Menú de encuesta \n1.Crear nueva encuesta \n2.Realización de la encuesta \n3.Salir \n Ingrese la opción que desee: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de preguntas que desea realizar: ");
                    noPreguntas = teclado.nextInt();
                    preguntas = new Cuestionario[noPreguntas];
                    for (int x = 0; x < noPreguntas; x++)
                    {
                        preguntas[x] = new Cuestionario("","","","","",0);
                        System.out.println("Ingrese la pregunta");
                        preguntas[x].pregunta = teclado.next();
                        System.out.println("Ingrese la primera respuesta");
                        preguntas[x].respuesta1 = teclado.next();
                        System.out.println("Ingrese la segunda respuesta");
                        preguntas[x].respuesta2 = teclado.next();
                        System.out.println("Ingrese la tercera respuesta");
                        preguntas[x].respuesta3 = teclado.next();
                        System.out.println("Ingrese la cuarta respuesta");
                        preguntas[x].respuesta4 = teclado.next();
                        System.out.println("Ingrese el número de respuesta que es la correcta");
                        preguntas[x].correcta = teclado.nextInt();
                    }
                    break;
                case 2:
                    for (int x = 0; x < noPreguntas; x++)
                    {
                        System.out.println(preguntas[x].pregunta + "\nPosible Repuesta 1: "+ preguntas[x].respuesta1 + "\nPosible Repuesta 2: "+ preguntas[x].respuesta2 + "\nPosible Repuesta 3: "+ preguntas[x].respuesta3 + "\nPosible Repuesta41: "+ preguntas[x].respuesta4 + "\n Ingrese la respuesta que considera correcta");
                        respuesta = teclado.nextInt();
                        if (respuesta == preguntas[x].correcta)
                        {
                            System.out.println("Respuesta correcta");
                        }
                        else
                        {
                            System.out.println("Respuesta incorrecta");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Gracias por utilizar este programa");
                    condicion = 1;
                    break;
                default:
                    System.out.println("Opción incorrecta, prueba a ingresar otra vez");
                    break;
            }
        }
    }
    
}
