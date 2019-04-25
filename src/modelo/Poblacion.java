package modelo;

import java.util.HashSet;
import java.util.Set;

public class Poblacion {
	int contadorJubilados = 0;

	Set<SerVivo> poblacionMundial = new HashSet<SerVivo>();
	Set<SerVivo> menoresDeEdad = new HashSet<SerVivo>();
	Set<SerVivo> adultos = new HashSet<SerVivo>();
	Set<SerVivo> jubilados = new HashSet<SerVivo>();


	
	public double crecer(SerVivo serVivo, Inem inem, double capitalEstado) {
		if (serVivo.getEdad() == 18) {
			adultos.add(serVivo);
			inem.desempleados.addFirst(serVivo);
			inem.insertarEnEmpresa(serVivo);
			menoresDeEdad.remove(serVivo);
		}
		if (serVivo.getEdad() == 65) {
			jubilados.add(serVivo);
			adultos.remove(serVivo);
			setContadorJubilados(contadorJubilados+1);
			inem.borrarDeEmpresa(serVivo);
			inem.trabajadores.remove(serVivo);
		}
		if (serVivo.getEdad() >= serVivo.getEdadMaxima()) {
			capitalEstado += serVivo.getDineroAhorrado();
			serVivo.setDineroAhorrado(0);
			
			jubilados.remove(serVivo);

		}
		return capitalEstado;
	}
	
	public double anioPoblacion(Inem inem, double capitalEstado) {
		setContadorJubilados(0);
		for (SerVivo serVivo : poblacionMundial) {
			serVivo.setEdad(serVivo.getEdad() + 1);
			capitalEstado=crecer(serVivo, inem,capitalEstado);
			for (SerVivo menor : menoresDeEdad) {
				if (serVivo.equals(menor))
					capitalEstado -= 365;
			}
			for (SerVivo serVivoJubilado : jubilados) {
				if (serVivo.equals(serVivoJubilado))
					if (serVivo.getDineroAhorrado() > 182.5)
						serVivo.setDineroAhorrado(serVivo.getDineroAhorrado() - 182.5);
					else {
						capitalEstado += serVivo.getDineroAhorrado();
						capitalEstado -= 182.5;
					}
			}
			capitalEstado -= serVivo.getNivelDeVida();
		}
		for(int i=0;i<contadorJubilados;i++)
		{
			SerVivo serVivo= new SerVivo(generadorDeNombres(),generadorDeNumerosId());
			poblacionMundial.add(serVivo);
			menoresDeEdad.add(serVivo);
		}
		return capitalEstado;
	}
	public String generadorDeNombres() {
		String[] fonemas = { "la", "le", "li", "lu", "car", "i", "ma", "cha", "pe", "pi", "po", "bri", "dra", "da",
				"jo", "se", "pe", "dri", "a", "ri", "ra", "ul", "je", "sus", "fran", "cis", "co" };
		String nombre = "";
		int numeroDeFonemas = (int) (Math.random() * 4 + 2);
		for (int i = 0; i < numeroDeFonemas; i++)
			nombre = nombre.concat(fonemas[(int) (Math.random() * fonemas.length)]);
		return nombre;
	}
	public void crearBebes(int numeroDeBebes)
	{
		for (int i = 0; i < numeroDeBebes; i++) {
			SerVivo nuevoSer= new SerVivo(generadorDeNombres(),generadorDeNumerosId());
			poblacionMundial.add(nuevoSer);
			menoresDeEdad.add(nuevoSer);
		}
	}
	public String generadorDeNumerosId() {
		String retorno;
		int numeroAleatorio = (int) (Math.random() * 99999999);
		int auxiliar = numeroAleatorio % 23;
		char letra;
		char letrasEsperadas[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };
		letra = letrasEsperadas[auxiliar];
		retorno = String.valueOf(numeroAleatorio);
		retorno = retorno.concat(String.valueOf(letra));
		return retorno;
	}
	
	public void agregarSerVivo(int j, int numeroMaximo) {
		String name = "";
		String id = "";
		int edad;
		for (int i = 0; i < numeroMaximo; i++) {
			name = this.generadorDeNombres();
			id = this.generadorDeNumerosId();
			edad = numeroAleatorio(j);
			if (edad <= 17) {

				menoresDeEdad.add(new SerVivo(name, id, edad, 365));
				poblacionMundial.add(new SerVivo(name, id, edad, 365));
			}
			if (edad >= 65) {

				jubilados.add(new SerVivo(name, id, edad, 182.5));
				poblacionMundial.add(new SerVivo(name, id, edad, 182.5));
			}
			if (edad >= 18 && edad < 65) {

				adultos.add(new SerVivo(name, id, edad, 365));
				poblacionMundial.add(new SerVivo(name, id, edad, 365));
			}
		}
	}

	public int getPoblacionAdultos() {
		return this.contadorJubilados;
	}

	public void setContadorJubilados(int adultos) {
		this.contadorJubilados = adultos;
	}
	private int numeroAleatorio(int i) {
		int numeroAleatorioAdulto = (int) (Math.random() * (65 - 18)) + 18;
		int numeroAleatorioMenor = (int) (Math.random() * 18);
		int numeroAleatorioJubilado = (int) (Math.random() * (90 - 65)) + 65;
		int[] ArrayAleatorio = { numeroAleatorioAdulto, numeroAleatorioMenor, numeroAleatorioJubilado };
		return ArrayAleatorio[i];
	}

	
}
