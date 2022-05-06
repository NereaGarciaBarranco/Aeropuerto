package aeropuerto;

public class NodeAvion {
	// Atributos de la clase
	private Avion content;
	private NodeAvion next;
	
	// Metodos constructores
	public NodeAvion (Avion content, NodeAvion next) {
		this.content = content;
		this.next = next;
	}
	
	public NodeAvion() {
		this.content = null;
		this.next = null;
	}

	// Metodos get y set
	public Avion getContent() {
		return content;
	}
	
	public void setContent(Avion content) {
		this.content = content;
	}
	
	public NodeAvion getNext() {
		return next;
	}
	
	public void setNext(NodeAvion next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Content = " + content + " Next = " + next + "\n";
	}

}
