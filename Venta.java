public class Venta
{
	int idVenta;
	String nombre;
	String direccion;
	String nit;
	double total;
	
	public Venta(int id, String n, String d, String Nit)
	{
		this.idVenta = id;
		this.nombre = n;
		this.direccion = d;
		this.nit = Nit;
	}
}