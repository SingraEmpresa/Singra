package modelo;

import java.util.*;


public class Factoria {
	LinkedList <SerVivo> empleados = new LinkedList<SerVivo>();
	
	private int tamanio=1000;
	
	public void contratarEmpleado(SerVivo becario)
	{
		empleados.addFirst(becario);
	}
	public void despedirEmpleado()
	{
		empleados.removeFirst();
	}
	public void despedirEmpleado(SerVivo jubilado)
	{
		empleados.remove(jubilado);
	}
	public int tamamio() {
		return empleados.size();
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	
}
