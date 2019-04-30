package modelo;


public class Estado {

	double capitalEstado = 100000;
	double produccionAnual;
	Poblacion poblacion = new Poblacion();
	Inem inem = new Inem();
	
	public void inicio() {
		int numeroTrabajadores = 100;
		int numeroMenores = 50;
		int numeroJubilados = 30;
		

		poblacion.agregarSerVivo(0, numeroTrabajadores);
		poblacion.agregarSerVivo(1, numeroMenores);
		poblacion.agregarSerVivo(2, numeroJubilados);

		for (SerVivo serVivo : poblacion.adultos) {
			inem.desempleados.add(serVivo);
		}
		inem.factorias.add(new Factoria());

		capitalEstado=inem.gestionarFactoria(poblacion, capitalEstado);
	}

	

	

	

	

	// El parametro i indica si debe devolver la edad para i=0 adulto, i=1 menor ,
	// i=2 jubilado
	

	public void test() {
		this.inicio();
		double capitalAntes=0;
		double capitalDespues=0;
		for (int i = 0; i < 1000; i++) {
			capitalAntes=capitalEstado;
			capitalEstado=poblacion.anioPoblacion(inem,capitalEstado);
			capitalEstado=inem.anioInem(capitalEstado);
			capitalDespues=capitalEstado;
			produccionAnual=capitalDespues-capitalAntes;
			double dineroAhorrado=0;
			System.out.println("Trabajadores= " + inem.trabajadores.size());
			System.out.println("Desempleados= " + inem.desempleados.size());
			System.out.println("Adultos		= " + poblacion.adultos.size());
			System.out.println("Menores		= " + poblacion.menoresDeEdad.size());
			System.out.println("Jubilados	= " + poblacion.jubilados.size());
			System.out.println("Factorias	= " + inem.factorias.size());
			System.out.println("Produccion  = " + produccionAnual);
			int j=0;
			for (Factoria factoria : inem.factorias) {
				j++;
				System.out.println("NumeroEmpleadosFactoria " + j + " :" + factoria.empleados.size());
			}
			for (SerVivo serVivo : poblacion.poblacionMundial) {
				dineroAhorrado=serVivo.getDineroAhorrado()+dineroAhorrado;
			}
			System.out.println("El dinero Ahorrado por todos es: "+ dineroAhorrado);
			System.out.println(":::::::::::::::::::::::::::::::::::::");

			System.out.println("Capital del \n" + "estado		= " + capitalEstado);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println("UIVA");
			}

		}

	}

}
