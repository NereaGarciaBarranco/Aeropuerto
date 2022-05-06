package aeropuerto;

public class SimpleLinkedList {
	// Atributos de la clase
	private NodeAvion first;
	private int size;
	
	// Metodos constructores
	// Cuando la lista esta vacia
	public SimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	// Cuando introducimos el primer dato
	public SimpleLinkedList(NodeAvion first) {
		this.first = first;
		this.size = 1;
	}
	
	// Metodos get y set
	public NodeAvion getFirst() {
		return first;
	}
	
	public void setFirst(NodeAvion first) {
		this.first = first;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
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
	 * Post: Añadir simple que funciona como el de la clase ArrayList,
	 * es decir, añade un nodo en la ultima posicion.
	 * @param node
	 * @return
	 */
	public boolean add (NodeAvion node) {
		try {		
			// Asi se añade el primer nodo
			if (size == 0) {
				first = node;
			} else {
				/*
				 *  Creamos un puntero que apunta exactamente a donde 
				 *  apunta first. Lo vamos a ir desplazando hasta que 
				 *  llegue al ultimo punto de la lista enlazada. 
				 *  First no lo podemos mover, por eso creamos un puntero .
				 */
				NodeAvion p = first;
				// Con este bucle el puntero se mueve al final y apunta al ultimo nodo
				for (int i = 1; i < size; i++) {
					p = p.getNext();
				} 
				// Cuando apunta al final se añade el nodo
				p.setNext(node);
				// Sumamos 1 al tamaño porque lo hemos añadido				
			} size++; return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo añade un nodo en una posicion concreta 
	 * pasada por parametro.
	 * @param position
	 * @param node
	 * @return
	 */
	public boolean add (int position, NodeAvion node) {
		try {
			/*
			 *  Si lo queremos poner al principio, el nuevo nodo tiene que 
			 *  apuntar al que ahora es first y convertirse en el nuevo first.
			 */
			if (position == 0) {
				node.setNext(first);
				first = node;
			/*
			 * Si se añade al final es como el metodo añadir normal.
			 */
			} else if (position == size) {
				return (add(node));
			} 	
			/*
			 * Cuando lo añadimos en el medio, con p tenemos que buscar el indice
			 * donde hay que añadirlo -1. Tenemos que tener en cuenta que un nodo
			 * si no esta apuntado, Java lo borra. El nodo que queremos añadir
			 * lo apuntamos a su siguiente, habrá dos nodos apuntando al mismo.
			 * Luego ya le cambias al nodo anterior su next por el nodo que quieres
			 * meter nuevo.
			 */
			else {
				// Creamos el puntero que apunta al primero
				NodeAvion p = first;
				for (int i = 1; i < position; i++) {
					p = p.getNext();
				}
				// Cogemos el next de p
				node.setNext(p.getNext());
				// Cambiamos el next de p a node
				p.setNext(node);
			} size++; return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	} 
	
	/**
	 * Pre: ---
	 * Post: Este metodo sirve para borrar un nodo de una posicion
	 * concreta de una Lista Simple Enlazada.
	 * @param position
	 * @return
	 */
	public boolean delete (int position) {
		try {
			// Si se quiere borrar el primer nodo
			if(position == 0) {
				// Asi el primer nodo queda desapuntado y se borra
				first = first.getNext();
			} // Si se quiere borrar el ultimo nodo 
			else if (position == size) {
				NodeAvion p = first;
				for (int i = 1; i < size -1; i++) {
					p = p.getNext();
				}
				p.setNext(null);
			} // Si el nodo que se quiere eliminar esta en el medio  
			else {
				NodeAvion p = first;
				for (int i = 0; i < position - 1; i++) {
					p = p.getNext();
				}
				p.setNext(p.getNext().getNext());
			} size--; return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo sirve para devolver el nodo que se situa en 
	 * una posicion concreta dada por parametro. Funciona igual que
	 * el metodo get de la clase ArrayList. Si esa posicion no existe
	 * en la lista se retorna null.
	 * @param position
	 * @return
	 */
	public NodeAvion get (int position) {
		try {
			// Comprobamos que la posicion sea correcta
			if (position >= 0 && position < size) {		
				NodeAvion p = first;
				for (int i = 1; i <= position; i++) {
					p = p.getNext();
				} return p;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} return null;		
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo muestra por pantalla los identificadores
	 * de los aviones que esten almacenados en una Lista Simple
	 * Enlazada.
	 */
	public void show() {
		if (isEmpty()) {
			System.out.println("La lista esta vacia.");
		} else {
			NodeAvion p = first;
			for (int i = 0; i < size; i++) {
				System.out.println("[" + i + "] -> " + p.getContent().getIdentificador());
				p = p.getNext();
			}	
		}
	}
}
