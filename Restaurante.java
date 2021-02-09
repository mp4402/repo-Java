import java.util.*;

public class Restaurante
{
	static LinkedList<Producto> Productos = new LinkedList<Producto>();
	static LinkedList<detalleVenta> detalleVentas = new LinkedList<detalleVenta>();
	static LinkedList<Venta> Ventas = new LinkedList<Venta>();
	static Scanner teclado = new Scanner(System.in);
	static int contadorProductos = 0, contadorVentas = 0;;
	
	public static void main(String[]args){
		int condicion = 1, opcion = 0, opcionProducto = 0;
		while (condicion == 1)
		{
			System.out.print("Bienvenido\n1.Gestionar Productos (Ingreso, Modificacion y Eliminacion)\n2.Realizar Venta\n3.Reporte de Facturas\n4.Salir\nIngrese una opcion: ");
			opcion = teclado.nextInt();
			teclado.nextLine();
			switch (opcion){
				case 1:
					limpiarPantalla();
					System.out.print("1.Ingresar un Producto Nuevo\n2.Modificar un Producto Existente\n3.Eliminar un Producto Existente\n4.Cancelar\nIngrese una opcion: ");
					opcionProducto = teclado.nextInt();
					teclado.nextLine();
					switch(opcionProducto){
						case 1:
							limpiarPantalla();
							ingresoProducto();
							limpiarPantalla();
							break;
						case 2:
							limpiarPantalla();
							modificarProducto();
							limpiarPantalla();
							break;
						case 3:
							limpiarPantalla();
							eliminarProducto();
							limpiarPantalla();
							break;
						case 4:
							limpiarPantalla();
							break;
						default:
							System.out.println(opcionProducto + " no es una opcion valida");
							break;
					}
					break;
				case 2:
					limpiarPantalla();
					realizarVenta();
					limpiarPantalla();
					break;
				case 3:
					limpiarPantalla();
					reporteVentas();
					limpiarPantalla();
					break;
				case 4:
					limpiarPantalla();
					System.out.println("Gracias por utilizar este programa");
					condicion = 0;
					break;
				default:
					System.out.println("Por favor ingrese una opcion valida");
					break;
			}
		}
	}
	
	public static void limpiarPantalla()
	{
		try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
	}
	
	public static void ingresoProducto()
	{
		contadorProductos++;
		String des;
		int ex, condicion=0;
		double preU;
		des = setDescripcion();
		ex = setExistencia();
		preU = setPrecio();
		if (contadorProductos > 1)
		{
			for (int x = 0; x < Productos.size(); x++)
			{
				if(des.equals(Productos.get(x).descripcion))
				{
					condicion = 1;
				}
			}
		}
		if (condicion == 0)
		{
			Producto producto1 = new Producto(contadorProductos, des, ex, preU);
			Productos.add(producto1);
		}
	}
	
	public static void modificarProducto()
	{
		int opcionModificar = 0, opcionModificacion = 0;
		mostrarProductos();
		System.out.println("Ingrese el Id del Producto a modificar");
		opcionModificar = teclado.nextInt();
		teclado.nextLine();
		System.out.print("1.Modificar descripcion\n2.Actualizar existencia\n3.Modificar Precio\n4.Modificar todo\n5.Cancelar\nIngrese la opcion de la accion que desea realizar: ");
		opcionModificacion = teclado.nextInt();
		teclado.nextLine();
		switch (opcionModificacion){
			case 1:
				Productos.get((opcionModificar-1)).descripcion = setDescripcion();
				break;
			case 2:
				Productos.get((opcionModificar-1)).existencia = setExistencia();
				break;
			case 3:
				Productos.get((opcionModificar-1)).precioUnidad = setPrecio();
				break;
			case 4:
				Productos.get((opcionModificar-1)).descripcion = setDescripcion();
				Productos.get((opcionModificar-1)).existencia = setExistencia();
				Productos.get((opcionModificar-1)).precioUnidad = setPrecio();
				break;
			case 5:
				break;
			default:
				System.out.println(opcionModificacion + " no es una opcion valida");
				break;
		}
	}
	
	public static void mostrarProductos()
	{
		System.out.println("Listado de Productos");
		for(int x = 0; x < Productos.size(); x++)
		{
			if (Productos.get(x).visibilidad == 1){
				System.out.println(" Id del prodcuto: " + Productos.get(x).id + " \tDescripcion: " + Productos.get(x).descripcion + "\tExistencias: " + Productos.get(x).existencia);
			}
		}
	}
	
	public static String setDescripcion()
	{
		String des;
		System.out.print("Ingrese la descripcion del producto: ");
		des = teclado.nextLine();
		return des;
	}
	
	public static int setExistencia()
	{
		int ex = 0;
		System.out.print("Ingrese la existencia del producto: ");
		ex = teclado.nextInt();
		teclado.nextLine();
		return ex;
	}
	
	public static double setPrecio()
	{
		double preU;
		System.out.print("Ingrese el precio por unidad del producto (En caso de ser decimal, debe llevar coma, ejemplo: 2,5): ");
		preU = teclado.nextDouble();
		teclado.nextLine();
		return preU;
	}
	
	public static void eliminarProducto()
	{
		int opcionEliminar = 0;
		mostrarProductos();
		System.out.print("Ingrse el Id del producto a eliminar: ");
		opcionEliminar = teclado.nextInt();
		teclado.nextLine();
		Productos.get((opcionEliminar-1)).visibilidad = 0;
	}
	
	public static void realizarVenta()
	{
		contadorVentas++;
		String nombre, direccion, nit;
		int condicionVenta = 0, idP = 0, cant = 0, totalVenta = 0;
		double totalV = 0;
		System.out.print("Ingrese el nombre del cliente: ");
		nombre = teclado.nextLine();
		System.out.print("Ingrese la direccion del cliente: ");
		direccion = teclado.nextLine();
		System.out.print("Ingrese el NIT del cliente: ");
		nit = teclado.next();
		teclado.nextLine();
		Venta nuevaVenta = new Venta(contadorVentas, nombre, direccion, nit);
		Ventas.add(nuevaVenta);
		while(condicionVenta == 0)
		{
			limpiarPantalla();
			mostrarProductos();
			System.out.print("Ingresa el Id del producto vendido\nIngresa 0 para dejar de ingresar productos: ");
			idP = teclado.nextInt();
			teclado.nextLine();
			if (idP == 0)
			{
				condicionVenta = 1;
			}
			else
			{
				System.out.print("Ingresa la cantidad de productos vendidos: ");
				cant = teclado.nextInt();
				teclado.nextLine();
				if (cant <= Productos.get((idP-1)).existencia)
				{
					detalleVenta nuevoDV = new detalleVenta(contadorVentas, idP, cant);
					detalleVentas.add(nuevoDV);
					Productos.get((idP-1)).existencia = Productos.get((idP-1)).existencia - cant;
					totalV += (Productos.get((idP-1)).precioUnidad * cant);
				}
				else
				{
					System.out.println("La cantidad a vender debe ser menor a las existencias del producto");
				}
			}
		}
		Ventas.get((contadorVentas-1)).total = totalV;
	}
	
	public static void reporteVentas()
	{
		int continuar = 0;
		System.out.println("Listado de Ventas");
		for (int x = 0; x < Ventas.size(); x++)
		{
			System.out.print("Venta No."+ (x+1) +"\nCliente: " + Ventas.get(x).nombre + "\nDireccion: " + Ventas.get(x).direccion + "\nNIT: " + Ventas.get(x).nit + "\nProductos Vendidos\n");
			for (int y = 0; y < detalleVentas.size(); y++)
			{
				if (Ventas.get(x).idVenta == detalleVentas.get(y).idVenta)
				{
					System.out.print("Id del producto: " + detalleVentas.get(y).idProducto + "\t Cantidad vendida: " + detalleVentas.get(y).cantidad + "\n");
				}
			}
			System.out.println("Total de la venta: " + Ventas.get(x).total + "\n");
		}
		System.out.print("Ingrese 0 para continuar: ");
		continuar = teclado.nextInt();
		teclado.nextLine();
	}
	
}