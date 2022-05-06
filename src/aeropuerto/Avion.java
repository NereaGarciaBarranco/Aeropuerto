package aeropuerto;

import java.util.ArrayList;

public class Avion {
	// Atributos de la clase
	private int identificador;
	private ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
	
	// Metodo constructor
	public Avion (int identificador) {
		this.identificador = identificador;
	}
	
	// Metodos get y set
	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}
	
	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
}
