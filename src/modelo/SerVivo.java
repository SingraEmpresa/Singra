package modelo;

public abstract class SerVivo {
	private int edadMaxima;
	private String nombre;
	private int numeroId;
	private int nivelDeVida;
	private int edad;
	private int dineroAhorrado;

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(int numeroId) {
		this.numeroId = numeroId;
	}

	public int getNivelDeVida() {
		return nivelDeVida;
	}

	public void setNivelDeVida(int nivelDeVida) {
		this.nivelDeVida = nivelDeVida;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDineroAhorrado() {
		return dineroAhorrado;
	}

	public void setDineroAhorrado(int dineroAhorrado) {
		this.dineroAhorrado = dineroAhorrado;
	}

}
