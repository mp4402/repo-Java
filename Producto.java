public class Producto
{
	int id;
	String descripcion;
	int existencia;
	double precioUnidad;
	int visibilidad;
	
	public Producto(int i, String d, int e, double pU)
	{
		this.id = i;
		this.descripcion = d;
		this.existencia = e;
		this.precioUnidad = pU;
		this.visibilidad = 1;
	}
}