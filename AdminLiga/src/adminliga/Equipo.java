package adminliga;

public class Equipo {
    String nombre;
    int NoJugadores;
    String capitan;
    int puntos;
    public Equipo(String n, int cantidad, String c, int puntos)
    {
        this.nombre = n;
        this.NoJugadores = cantidad;
        this.capitan = c;
        this.puntos = puntos;
    }
    public void changeNombre(String n)
    {
        this.nombre = n;
    }
    public void changeCantidad(int c)
    {
        this.NoJugadores = c;
    }
    public void changeCapitan(String c)
    {
        this.capitan = c;
    }
    public void sumarPuntos(int indice)
    {
        this.puntos += indice;
    }
}
