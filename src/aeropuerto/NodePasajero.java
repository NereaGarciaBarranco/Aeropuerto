package aeropuerto;

public class NodePasajero {
	private Pasajero content;
	private NodePasajero next;
	
	public NodePasajero (Pasajero content, NodePasajero next) {
		this.content = content;
		this.next = next;
	}
	
	public NodePasajero (Pasajero content) {
		this.content = content;
		next = null;
	}
	
	public Pasajero getContent() {
		return content;
	}
	
	public void setContent(Pasajero content) {
		this.content = content;
	}
	
	public NodePasajero getNext() {
		return next;
	}
	
	public void setNext(NodePasajero next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return content.getNombre();
	}

}
