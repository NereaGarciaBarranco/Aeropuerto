package aeropuerto;

public class Stack {
	/*
	 * En las pilas (stack) lo ultimo que se añade se pone encima de lo
	 * ultimo que se ha guardado, por eso el puntero apunta al ultimo.
	 */
	private int size;
	private NodePasajero last;
	
	// Metodos constructores
	public Stack () {
		last = null;
		size = 0;
	}
	
	public Stack (NodePasajero last) {
		this.size = 1;
		this.last = last;
	}
	
	public Stack (int size, NodePasajero last) {
		this.size = size;
		this.last = last;
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo devuelve true si la pila esta vacia.
	 * @return
	 */
	public boolean isEmpty() {
		if (last == null) return true;
		else return false;
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo recibe un nodo y lo añade en la ultima
	 * posicion.
	 * @param node
	 * @return
	 */
	public boolean push(NodePasajero node) {
		try {
			if (isEmpty()) last = node;
			else {
				node.setNext(last);
				last = node;		
			} size++; return true;
		} catch (Exception e) { System.out.println(e.toString());} 
		return false;
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo borra el ultimo nodo introducido.
	 * @return
	 */
	public NodePasajero pop() {
		try {
			if (!isEmpty()) {
				NodePasajero p = last;
				last = last.getNext();
				size--;
				return p;
			}	
		} catch (Exception e) {
			System.out.println(e.toString());		
		} return null;
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo muestra por pantalla el contenido de la pila
	 * o muestra un mensaje de advertencia de que esta vacia.
	 */
	public void show() {
		if (isEmpty()) {
			System.out.println("La pila esta vacia");
		} else {
			NodePasajero p = last;
			for (int i = 0; i <= size - 1; i++) {
				System.out.println("[" + i + "] -> " + p.getContent().getNombre());
				p = p.getNext();
			}			
		}
	}
	
	// Metodos get y set
	public int getSize() {
		return size;
	}
	
	public void setSize(int content) {
		this.size = content;
	}
	
	public NodePasajero getLast() {
		return last;
	}
	
	public void setLast(NodePasajero last) {
		this.last = last;
	}
}
