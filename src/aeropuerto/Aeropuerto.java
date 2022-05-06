package aeropuerto;

public class Aeropuerto {
	// Atributos de la clase
	private Heap cola;
	private Stack pila;
	private SimpleLinkedList aviones;
	
	// Metodo constructor
	public Aeropuerto (Heap cola, Stack pila, SimpleLinkedList lista) {
		this.cola = cola;
		this.pila = pila;
		this.aviones = lista;
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo recibe un objeto de tipo Avion y lo convierte
	 * en un NodeAvion para poder ser insertado en una SimpleLinkedList.
	 */
	public void añadirAvion(Avion avion) {
		NodeAvion node = new NodeAvion(avion, null);
		aviones.add(node);
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo va metiendo a los pasajeros en la cola o en la pila
	 * segun su orden de llegada. En la cola caben dos pasajeros y en la 
	 * pila tres. Si ambas estan llenas, el pasajero no puede entrar en el
	 * aeropuerto.
	 * @param pasajero
	 */
	public void asignarEsperaPasajero(Pasajero entrante) {
		/*
		 * Convertimos el Pasajero en un objeto de tipo NodePasajero para
		 * poder guardarlo en la cola o en la pila del aeropuerto. 
		 */
		NodePasajero pasajero = new NodePasajero(entrante);
		if(cola.getSize() < 2) {
			cola.push(pasajero);
			System.out.println("El pasajero " + pasajero.getContent().getNombre() 
					+ " va a la cola.");
		} else if (pila.getSize() < 3) {
			pila.push(pasajero);
			System.out.println("El pasajero " + pasajero.getContent().getNombre() 
					+ " va a la pila.");
		} else {
			System.out.println("Este pasajero no cabe en el aeropuerto.");
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Primero se les pide la documentacion a los pasajeros de 
	 * la cola y posteriormente a los de la pila. El pasajero se manda
	 * al metodo montarPasajero() para que sea montado en su avion
	 * correspondiente. 
	 */
	public void pedirDocumentacion() {
		// La gente de la cola tiene prioridad sobre la gente de la pila
		if (!cola.isEmpty()) {
			NodePasajero auxiliar = cola.pop();
			System.out.println("El pasajero " + auxiliar.toString() 
				+ " ha salido de la cola.");
			montarPasajero(auxiliar);
		} else {
			NodePasajero auxiliar = pila.pop();
			System.out.println("El pasajero " + auxiliar.toString() 
				+ " ha salido de la pila.");
			montarPasajero(auxiliar);
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo añade un pasajero al ArrayList de pasajeros
	 * de un avion si el identificador de su vuelo y el del avion
	 * coinciden.
	 * @param nodePasajero
	 */
	public void montarPasajero(NodePasajero nodePasajero) {
		/*
		 *  Cogemos el contenido del Nodo y lo convertimos en un Pasajero
		 *  para poder añadirlo a su vuelo correspondiente.
		 */
		String nombre = nodePasajero.getContent().getNombre() ;
		String dni = nodePasajero.getContent().getDni();
		int numeroVuelo = nodePasajero.getContent().getNumeroVuelo();
		Pasajero pasajero = new Pasajero (nombre, dni, numeroVuelo);
		for (int i = 0; i < aviones.getSize(); i++) {
			// Buscamos el vuelo al que va a subir el pasajero 
			if (aviones.get(i).getContent().getIdentificador() == numeroVuelo) {
				// Lo montamos
				aviones.get(i).getContent().getPasajeros().add(pasajero);
			}
		}			
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo recibe el identificador de un avion e imprime el nombre
	 * de todos los pasajeros que esten montados en dicho avion. 
	 * @param identificador
	 */
	public void mostrarPasajerosSegunIdentificador (int identificador) {
		for (int i = 0; i < aviones.getSize(); i++) {
			// Buscamos el avion 123
			if (aviones.get(i).getContent().getIdentificador() == 123) {
				for (int j = 0; j < aviones.get(i).getContent().getPasajeros().size(); j++) {
					System.out.println
						(aviones.get(i).getContent().getPasajeros().get(i).toString());
				}
			}
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo muestra por pantalla todos los aviones y todos
	 * los pasajeros que esten montados en cada uno de ellos.
	 */
	public void mostrarTodosPasajerosAviones() {
		NodeAvion p = new NodeAvion();
		p = aviones.getFirst();
		for (int i = 0; i < aviones.getSize(); i++) {
			System.out.println("Avion " + aviones.get(i).getContent().getIdentificador());
			for (int j = 0; j < aviones.get(i).getContent().getPasajeros().size(); j++) {
				System.out.println
					(aviones.get(i).getContent().getPasajeros().get(j).toString());
			}
			p = p.getNext();
		}
	}
	
	// Metodos get y set
	public Heap getCola() {
		return cola;
	}
	
	public void setCola(Heap cola) {
		this.cola = cola;
	}
	
	public Stack getPila() {
		return pila;
	}
	
	public void setPila(Stack pila) {
		this.pila = pila;
	}
	
	public SimpleLinkedList getLista() {
		return aviones;
	}
	
	public void setLista(SimpleLinkedList lista) {
		this.aviones = lista;
	}	
}
