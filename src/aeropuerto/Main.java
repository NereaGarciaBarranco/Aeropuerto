package aeropuerto;

public class Main {
	// Creacion del aeropuerto
	static Heap cola = new Heap();
	static Stack pila = new Stack();
	static SimpleLinkedList lista = new SimpleLinkedList();
	static Aeropuerto aeropuerto = new Aeropuerto (cola, pila, lista);
	
	/**
	 * Pre: ---
	 * Post: Este metodo main muestra la gestion de un objeto de tipo
	 * aeropuerto al que se añaden aviones y pasajeros.
	 * @param args
	 */
	public static void main(String[] args) {
		// Creacion de los pasajeros
		Pasajero pasajero1 = new Pasajero ("Luis", "123123123-H", 123);
		Pasajero pasajero2 = new Pasajero ("Elena", "321321321-D", 23);
		Pasajero pasajero3 = new Pasajero ("Carmen", "17799874-X", 123);
		Pasajero pasajero4 = new Pasajero ("Manuel", "22669988-D", 123);
		
		// Creacion de los aviones y añadirlos al aeropuerto
		aeropuerto.añadirAvion(new Avion(123));
		aeropuerto.añadirAvion(new Avion(23));
		System.out.println("El aeropuerto consta de los siguientes aviones:");
		aeropuerto.getLista().show();
	
		// Ponemos a los pasajeros en la cola o en la pila segun orden de llegada
		System.out.println("\nLos pasajeros van llegando:");
		aeropuerto.asignarEsperaPasajero(pasajero1);
		aeropuerto.asignarEsperaPasajero(pasajero2);
		aeropuerto.asignarEsperaPasajero(pasajero3);
		aeropuerto.asignarEsperaPasajero(pasajero4);
		
		// Entregan documentacion dos pasajeros
		System.out.println("\nEmpiezan a entregar documentación 2 personas:");
		aeropuerto.pedirDocumentacion(); 
		aeropuerto.pedirDocumentacion();
		
		// Imprimimos por pantalla los pasajeros del avion 123
		System.out.println("\nEl avion 123 tiene dentro los siguientes pasajeros:");
		aeropuerto.mostrarPasajerosSegunIdentificador(123);
		
		// Entrega documentacion otro pasajero
		System.out.println("\nEntrega documentacion otra persona:");
		aeropuerto.pedirDocumentacion();
		System.out.println("\n----------");
		System.out.println("Mostramos todos los pasajeros montados en los aviones:");
		aeropuerto.mostrarTodosPasajerosAviones();
		
		// Mostramos el contenido que queda en la pila y en la cola
		System.out.println("\nMostramos la pila:");
		aeropuerto.getPila().show();
		System.out.println("Mostramos la cola:");
		aeropuerto.getCola().show();
	}
}
