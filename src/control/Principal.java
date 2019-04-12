package control;

import modelo.MenorDeEdad;

public class Principal {

	public static void main(String[] args) {
		int [] idUsados= {10,12,14};
		MenorDeEdad juan = new MenorDeEdad(idUsados);
		System.out.println(juan.getNombre());
	}

}
