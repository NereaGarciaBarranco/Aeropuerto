package aeropuerto;

public class Heap {
	// En la cola lo primero que entra es lo primero en salir
	private int size;
	private NodePasajero first;
	private NodePasajero last;
	
	// Metodos constructores
	public Heap () {
		first = null;
		size = 0;
	}
	
	public Heap (NodePasajero node) {
		this.first = node;
		this.last = node;
		this.size = 1;
	}
	
	public Heap (int size, NodePasajero first, NodePasajero last) {
		this.size = size;
		this.first = first;
		this.last = last;
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo devuelve true solo si la cola esta vacia.
	 * @return
	 */
	public boolean isEmpty() {
		if (size == 0) return true;
		else return false;
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo sirve para añadir un nodo en la cola.
	 * @param node
	 * @return
	 */
	public boolean push(NodePasajero node) {
		try {
			if (isEmpty()) { 
				first = node; 
				last = node;
			} else {
				last.setNext(node);
				last = node;	
			} size++; return true;
		} catch (Exception e) { System.out.println(e.toString());} 
		return false;	
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo saca el primer nodo introducido en la cola.
	 * @return
	 */
	public NodePasajero pop() {
		try {
			if (!isEmpty()) {
				NodePasajero p = first;
				first = first.getNext();
				size--;
				return p;
			}	
		} catch (Exception e) {
			System.out.println(e.toString());		
		} return null;
	}
 	
	/**
	 * Pre: ---
	 * Post: Este metodo muestra el contenido de la cola o lanza un
	 * mensaje de que esta vacia. 
	 */
	public void show() {
		if (isEmpty()) {
			System.out.println("La cola esta vacia");
		} else {
			NodePasajero p = first;
			for (int i = 0; i < size; i++) {
				System.out.println("[" + i + "] -> " + p.getContent().getNombre());
				p = p.getNext();
			}			
		}
	}
	
	// Metodos get y set
	public NodePasajero getFirst() {
		return first;
	}
	
	public void setFirst(NodePasajero first) {
		this.first = first;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public NodePasajero getLast() {
		return last;
	}

	public void setLast(NodePasajero last) {
		this.last = last;
	}
}
