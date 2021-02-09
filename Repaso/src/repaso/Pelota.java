package repaso;

public class Pelota 
{
    String marca;
    int tama;
    String deporte;
    double precioOriginal;
    
    public Pelota(String nuevaMarca, int nuevoTama, String nuevoDeporte, double nuevoPrecio)
    {
        this.marca = nuevaMarca;
        this.tama = nuevoTama;
        this.deporte = nuevoDeporte;
        this.precioOriginal = nuevoPrecio;
    }
}