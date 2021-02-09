package adminliga;
import java.util.Scanner;
import java.util.LinkedList;

public class AdminLiga {
    static LinkedList<Equipo> ListaEquipos = new LinkedList<Equipo>();
    static LinkedList<String> ListaPartidos = new LinkedList<String>();
    static LinkedList<String> ListaResultados = new LinkedList<String>();
    
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion, control = 0;
        while (control == 0)
        {
            System.out.print("Menú de la liga \n1.Ingresar Equipo\n2.Buscar Equipo\n3.Editar Equipo\n4.Generar Calendario\n5.Ingresar Resultados\n6.Mostrar Tabla de Resultados\n7.Salir\nIngrese una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion)
            {
                case 1:
                    IngresarEquipo();
                    break;
                case 2:
                    BuscarEquipo();
                    break;
                
                case 3:
                    EditarEquipo();
                    break;
                case 4:
                    GenerarCalendario();
                    break;
                case 5:
                    IngresarGoles();
                    break;
                case 6:
                    mostrarTabla();
                    break;
                case 7:
                    System.out.println("Gracias por utilizar el programa");
                    control = 1;
                    break;
            }
        }
    }
    public static void IngresarEquipo()
    {
        String nombre,capitan;
        int jugadores=0;
        System.out.print("Ingrese el nombre del equipo: ");
        nombre = teclado.nextLine();
        while (jugadores < 15)
        {
            System.out.print("Ingrese el numero de jugadores: ");
            jugadores = teclado.nextInt();
        }
        teclado.nextLine();
        System.out.print("Ingrese el nombre del capitan del equipo: ");
        capitan = teclado.nextLine();
        Equipo team = new Equipo(nombre,jugadores,capitan,0);
        ListaEquipos.add(team);
    }
    public static void EditarEquipo()
    {
        int opcion=0,equipo=0;
        System.out.print("Menú\n1.Editar nombre de equipo\n2.Editar cantidad de jugadores\n3.Editar nombre del capitan\n4.Editar todo\nSeleccione una opción: ");
        opcion = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Listado de los equipos");
        for (int x = 0; x<ListaEquipos.size();x++)
        {
            System.out.println("No: " + (x+1) + " " + ListaEquipos.get(x).nombre);
        }
        System.out.println("Ingrese el equipo que desea editar");
        equipo = teclado.nextInt();
        teclado.nextLine();
        switch(opcion)
        {
            case 1:
                getName(equipo);
                break;
            case 2:
                getCantidad(equipo);
                break;
            case 3:
                getCapitan(equipo);
                break;
            case 4:
                getName(equipo);
                getCantidad(equipo);
                getCapitan(equipo);
                break;
        }
    }
    public static void getName(int x)
    {
        String nombre="";
        System.out.println("Ingrese el nuevo nombre del equipo");
        nombre = teclado.nextLine();
        ListaEquipos.get(x).changeNombre(nombre);
    }
    public static void getCantidad(int x)
    {
        int cantidad = 0;
        System.out.println("Ingrese la nueva cantidad de jugadores");
        cantidad = teclado.nextInt();
        teclado.nextLine();
        ListaEquipos.get(x).changeCantidad(cantidad);
    }
    public static void getCapitan(int x)
    {
        String capitan = "";
        System.out.println("Ingrese el nuevo nombre del capitan");
        capitan = teclado.nextLine();
        ListaEquipos.get(x).changeCapitan(capitan);
    }
    public static void BuscarEquipo()
    {
        int equipo = 0;
        for (int x = 0; x<ListaEquipos.size();x++)
        {
            System.out.println("No: " + (x+1) + " " + ListaEquipos.get(x).nombre);
        }
        System.out.println("Ingrese el equipo que desea editar");
        equipo = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Nombre: " + ListaEquipos.get(equipo).nombre);
        System.out.println("Numero de jugadores: " + ListaEquipos.get(equipo).NoJugadores);
        System.out.println("Capitan: " + ListaEquipos.get(equipo).capitan);
    }
    public static void GenerarCalendario()
    {
        ListaPartidos.clear();
        for (int x = 0; x < ListaEquipos.size(); x++)
        {
            for (int y = (x+1); y < ListaEquipos.size();y++)
            {
                ListaPartidos.add(ListaEquipos.get(x).nombre + " - " + ListaEquipos.get(y).nombre);

            }
        }
        for (int x = (ListaEquipos.size()-1); x >= 0; x--)
        {
            for (int y = (x-1); y >=0; y--)
            {
                ListaPartidos.add(ListaEquipos.get(x).nombre + " - " + ListaEquipos.get(y).nombre);

            }
        }
    }
    public static void IngresarGoles()
    {
        int opcion,espacio,resultado1,resultado2;
        String Equipo1="",Equipo2="",Partido="";
        for (int x = 0; x < ListaPartidos.size(); x++)
        {
            System.out.println("No." + (x+1) + " " + ListaPartidos.get(x));
        }
        System.out.print("Seleccione un partido: ");
        opcion = teclado.nextInt();
        teclado.nextLine();
        Partido = ListaPartidos.get(opcion-1);
        espacio = Partido.indexOf(" - ");
        Equipo1 = Partido.substring(0,(espacio));
        Equipo2 = Partido.substring(espacio+3,Partido.length());
        System.out.println("Ingrese los goles anotados por: "+Equipo1);
        resultado1 = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese los goles anotados por: "+Equipo2);
        resultado2 = teclado.nextInt();
        teclado.nextLine();
        if (resultado1 == resultado2)
        {
            buscarEquipo(Equipo1,1);
            buscarEquipo(Equipo2,1);
        }
        else if (resultado1 > resultado2)
        {
            buscarEquipo(Equipo1,3);
        }
        else
        {
            buscarEquipo(Equipo2,3);
        }
    }
    public static void buscarEquipo(String equipo,int puntos)
    {
        for(int x = 0; x < ListaEquipos.size();x++)
        {
            if(equipo.equals(ListaEquipos.get(x).nombre))
            {
                ListaEquipos.get(x).sumarPuntos(puntos);
                System.out.println(ListaEquipos.get(x).puntos + " " + ListaEquipos.get(x).nombre);
            }
        }
    }
    public static void mostrarTabla ()
    {
        int mayor = 0,temporal=0;
        System.out.println("No. Puntos\tEquipo");
        for(int j = 1; j < ListaEquipos.size();j++)
        {
            int puntos = ListaEquipos.get(j).puntos;
            int cantidad = ListaEquipos.get(j).NoJugadores;
            String nombre = ListaEquipos.get(j).nombre;
            String capitan = ListaEquipos.get(j).capitan;
            
            int i = (j-1);
            while ( (i > puntos) && ( ListaEquipos.get(i).puntos > -1 ) ) {  
                ListaEquipos.get(i).puntos = ListaEquipos.get(i+1).puntos;  
                ListaEquipos.get(i).NoJugadores = ListaEquipos.get(i+1).NoJugadores;  
                ListaEquipos.get(i).nombre = ListaEquipos.get(i+1).nombre;  
                ListaEquipos.get(i).capitan = ListaEquipos.get(i+1).capitan;  
                i++;  
            }  
            ListaEquipos.get(i+1).puntos = puntos;
            ListaEquipos.get(i+1).NoJugadores = cantidad;
            ListaEquipos.get(i+1).nombre = nombre;
            ListaEquipos.get(i+1).capitan = capitan;
        }
        for (int x = 0;x<ListaEquipos.size();x++)
        {
            System.out.println((x+1) + ".  " +ListaEquipos.get(x).puntos + "\t" + ListaEquipos.get(x).nombre);
        }
    }
}

