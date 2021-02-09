import java.util.*;

public class Blackjack
{
	static Scanner teclado = new Scanner(System.in);
	static Carta[] Deck = new Carta[208];
	static Carta[] jugador = new Carta[3];
	static Carta [] dealer = new Carta [3];
	static int[] numeroJugador = new int[3];
	static int[] numeroDealer = new int[3];
	static int contadorCartasJugador = 0, contadorCartasDealer = 0, valorJugador = 0, valorDealer = 0, condicionBJ = 0;
	
	public static void main(String[]args)
	{
		int opcion = 0;
		llenadooDeck();
		System.out.println("Bienvenido al Casino Four Dragons, el mejor casino de Las Venturas\n");
		//mostrarCartas();
		esperar(1);
		System.out.println("Repartiremos cartas\n");
		esperar(1);
		repartirJugador();
		repartirDealer();
		mostrarJugador();
		mostrarDealerInicio();
		Bj(valorJugador, valorDealer);
		if (condicionBJ == 0)
		{
			System.out.print("\nComo desea jugar?\n1.Hit (Tomar una carta extra del pozo)\n2.Stand (Permanecer con las cartas que posee)\nSeleccione una opcion: ");
			opcion = teclado.nextInt();
			teclado.nextLine();
			System.out.println("");
			switch (opcion){
			case 1:
				hit();
				esperar(1);
				mostrarJugador();
				mostrarDealer();
				esperar(1);
				ganar(valorJugador, valorDealer);
				break;
			case 2:
				mostrarJugador();
				mostrarDealer();
				ganar(valorJugador, valorDealer);
				break;
			default:
				System.out.println("Por favor seleccione una opcion valida");
				break;
			}
		}
	}
	/*
	public static void mostrarCartas()
	{
		for (int x = 0; x < 52; x++)
		{
			System.out.println("Valor: " + Deck[x].valor + ", Indice: " + Deck[x].identificador);
		}
	}
	*/
	
	public static void mostrarJugador()
	{
		valorJugador = 0;
		System.out.println("Cartas del Jugador:");
		for (int x = 0; x < contadorCartasJugador; x++)
		{
			System.out.println("Carta "+ (x+1) + ": " + jugador[x].identificador);
			valorJugador += jugador[x].valor; 
			esperar(1);
		}
		for (int y = 0; y < contadorCartasJugador; y++)
		{
			if ("A".equals(jugador[y].identificador))
			{
				if (valorJugador <= 11)
				{
					valorJugador += 10;
				}
			}
		}
		System.out.println("El total es: " + valorJugador + "\n");
	}
	
	public static void mostrarDealer()
	{
		valorDealer = 0;
		System.out.println("Cartas del Dealer:");
		for (int x = 0; x < contadorCartasDealer; x++)
		{
			System.out.println("Carta "+ (x+1) + ": " + dealer[x].identificador);
			valorDealer += dealer[x].valor;
			esperar(1);
		}
		for (int y = 0; y < 2; y++)
		{
			if ("A".equals(dealer[y].identificador))
			{
				if (valorDealer <= 11)
				{
					valorDealer += 10;
				}
			}
		}
		System.out.println("El total es: " + valorDealer + "\n");
	}
	
	public static void mostrarDealerInicio()
	{
		valorDealer = 0;
		System.out.println("Cartas del Dealer:\nCarta 1: " + dealer[0].identificador);
		esperar(1);
		System.out.println("Carta 2: xx");
		esperar(1);
		valorDealer = dealer[0].valor + dealer [1].valor;
		for (int y = 0; y < 2; y++)
		{
			if ("A".equals(dealer[y].identificador))
			{
				if (valorDealer <= 11)
				{
					valorDealer += 10;
				}
			}
		}
	}
	
	public static void llenadooDeck()
	{
		int contador = 0;
		for (int z = 1; z < 5; z++)
		{
			for (int x = 1; x < 5; x++)
			{
				for (int y = 1; y < 14; y++)
				{
					if (y == 1)
					{	
						Carta llenado = new Carta(1,"A");
						Deck[contador] = llenado;
					}
					else if (y == 11)
					{
						Carta llenado = new Carta(10,"J");
						Deck[contador] = llenado;
					}
					else if (y == 12)
					{
						Carta llenado = new Carta(10,"Q");
						Deck[contador] = llenado;
					}
					else if (y == 13)
					{
						Carta llenado = new Carta(10,"K");
						Deck[contador] = llenado;
					}
					else
					{
						String numValor = String.valueOf(y);
						Carta llenado = new Carta(y,numValor);
						Deck[contador] = llenado;
					}
					contador++;
				}
			}
		}
	}
	
	public static void repartirJugador()
	{
		for (int x = 0; x < 2;  x++)
		{
			int condicion = 0;
			while (condicion == 0)
			{
				int numero = (int) (Math.random()*203+1);
				for (int y = 0; y < 3; y++)
				{
					if (numero == numeroJugador[y] || numero == numeroDealer[y])
					{
						condicion = 0;
					}
					else
					{
						condicion = 1;
					}
				}
				if (condicion == 1)
				{
					jugador[x] = Deck[numero];
					numeroJugador[contadorCartasJugador] = numero;
					contadorCartasJugador++;
				}
			}
		}
	}

	public static void repartirDealer()
	{
		for (int x = 0; x < 2;  x++)
		{
			int condicion = 0;
			while (condicion == 0)
			{
				int numero = (int) (Math.random()*203+1);
				for (int y = 0; y < 3; y++)
				{
					if (numero == numeroJugador[y] || numero == numeroDealer[y])
					{
						condicion = 0;
					}
					else
					{
						condicion = 1;
					}
				}
				if (condicion == 1)
				{
					dealer[x] = Deck[numero];
					numeroDealer[contadorCartasDealer] = numero;
					contadorCartasDealer++;
				}
			}
		}
	}
	public static void ganar(int vJ, int vD)
	{
		if(vJ < vD || vJ > 21)
		{
			System.out.println("La Casa gana!");
		}
		else if(vJ > vD || vD > 21)
		{
			System.out.println("Felicidades, ha ganado!");
		}
		else
		{
			System.out.println("Nadie Gana, Empate!");
		}
		System.out.println("Gracias por jugar!");
	}
	
	public static void Bj(int vJ, int vD)
	{
		if (vJ == 21)
		{
			System.out.println("Felicidades, ha ganado con un Blackjack!");
			condicionBJ = 1;
			System.out.println("Gracias por jugar!");
		}
		else if (vD == 21)
		{
			System.out.println("La Casa gana por Blackjack!");
			condicionBJ = 1;
			System.out.println("Gracias por jugar!");
		}
		else
		{
			
		}
	}
	
	public static void esperar(int segundos)
	{
        try 
		{
            Thread.sleep(segundos * 1000);
        } 
		catch (Exception e) 
		{
			System.out.println(e);
		}
    }  
	
	public static void hit()
	{
		int condicion = 0;
			while (condicion == 0)
			{
				int numero = (int) (Math.random()*203+1);
				for (int y = 0; y < 3; y++)
				{
					if (numero == numeroJugador[y] || numero == numeroDealer[y])
					{
						condicion = 0;
					}
					else
					{
						condicion = 1;
					}
				}
				if (condicion == 1)
				{
					jugador[2] = Deck[numero];
					numeroJugador[contadorCartasJugador] = numero;
					contadorCartasJugador++;
				}
			}
	}
}