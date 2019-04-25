package modelo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Inem {

	
	Set<Factoria> factorias = new HashSet<Factoria>();
	

	LinkedList<SerVivo> desempleados = new LinkedList<SerVivo>();

	Set<SerVivo> trabajadores = new HashSet<SerVivo>();
	
	public void insertarEnEmpresa(SerVivo serVivo) {
		boolean aniadido=false;
		aniadido = aniadirAEmpresa(serVivo);
		if (!aniadido) {
			factorias.add(new Factoria());
			aniadirAEmpresa(serVivo);
		}
	}
	public void borrarDeEmpresa(SerVivo serVivo) {
		for (Factoria factoria : factorias) {
				factoria.despedirEmpleado(serVivo);
		}
	}
	private boolean aniadirAEmpresa(SerVivo serVivo) {
		boolean aniadido = false;
		for (Factoria factoria : factorias) {
			if (factoria.tamamio() < 1000) {
				factoria.contratarEmpleado(serVivo);
				trabajadores.add(serVivo);
				aniadido = true;
				desempleados.removeFirst();
			}
		}
		return aniadido;
	}
	public double gestionarFactoria(Poblacion pob, double capitalEstado) {
		SerVivo ayudante;
		for (Factoria factoria : factorias) {
			for (int i = 0; i < factoria.getTamanio() && 0 < desempleados.size(); i++) {
				ayudante = desempleados.element();
				factoria.contratarEmpleado(ayudante);
				trabajadores.add(desempleados.element());
				desempleados.remove();
			}
		}
		for (SerVivo serVivo : pob.poblacionMundial)
		for (SerVivo serVivoAdultoDesempleado : desempleados) {
			if (serVivo.equals(serVivoAdultoDesempleado))
				if (serVivo.getDineroAhorrado() > 365)
					serVivo.setDineroAhorrado(serVivo.getDineroAhorrado() - 365);
				else {
					capitalEstado += serVivo.getDineroAhorrado();
					capitalEstado -= 365;
				}
		}
		return capitalEstado;
	}
	public double anioInem(double capitalEstado)
	{
		for (Factoria factoria : factorias) {
			for (SerVivo serVivo : factoria.empleados) {
				serVivo.setDineroAhorrado(serVivo.getDineroAhorrado() + 182.5);
				capitalEstado += 182.5 + serVivo.getNivelDeVida() + 270;
			}
		}
		return capitalEstado;
	}
}
