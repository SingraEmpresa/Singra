package modelo;

public class SerVivo {

	private String nombre;
	private String numeroId;
	private int edad;

	private double dineroAhorrado;

	private double nivelDeVida;
	private int edadMaxima;

	private boolean trabajador;

	public SerVivo(String nombre, String numeroId) {
		this.setNombre(nombre);
		this.setNumeroId(numeroId);
		this.setEdad(0);
		this.setDineroAhorrado(0);
		this.setNivelDeVida(365);
		this.setEdadMaxima(90);

	}
	
	public SerVivo(String nombre, String numeroId, int edad, double nvd) {
		this(nombre, numeroId);
		this.setEdad(edad);
		this.setNivelDeVida(nvd);
	}

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

	public String getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(String string) {
		this.numeroId = string;
	}

	public double getNivelDeVida() {
		return nivelDeVida;
	}

	public void setNivelDeVida(double nvd) {
		this.nivelDeVida = nvd;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getDineroAhorrado() {
		return dineroAhorrado;
	}

	public void setDineroAhorrado(double d) {
		this.dineroAhorrado = d;
	}

	public boolean isTrabajador() {
		return trabajador;
	}

	public void setTrabajador(boolean trabajador) {
		this.trabajador = trabajador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroId == null) ? 0 : numeroId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SerVivo other = (SerVivo) obj;
		if (numeroId == null) {
			if (other.numeroId != null)
				return false;
		} else if (!numeroId.equals(other.numeroId))
			return false;
		return true;
	}
}
