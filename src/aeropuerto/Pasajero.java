package aeropuerto;

public class Pasajero {
	// Atributos de la clase
	private String nombre;
	private String dni;
	private int numeroVuelo;
	
	// Metodo constructor
	public Pasajero (String nombre, String dni, int numeroVuelo) {
		this.nombre = nombre;
		this.dni = dni;
		this.numeroVuelo = numeroVuelo;
	}
	
	// Metodos get y set
 	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getNumeroVuelo() {
		return numeroVuelo;
	}
	
	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " DNI: " + dni + " Numero vuelo: " + numeroVuelo; 
	}
}
