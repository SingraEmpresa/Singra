package modelo;

public class MenorDeEdad extends SerVivo {

	public MenorDeEdad(int[] numerosIdentificadores) {
		this.setEdadMaxima(90);
		this.setNombre(generadorDeNombres());
		this.setEdad(0);
		this.setNumeroId(generadorDeNumerosId(numerosIdentificadores));
		this.setDineroAhorrado(0);
	}
	public String generadorDeNombres()
	{
		String [] fonemas = {"la", "le", "li", "lu", "car", "i", "ma", "cha", "pe", "pi" , "po", "bri", "dra", "da", "jo", "se"};
		String nombre=" ";
		int numeroDeFonemas= (int) (Math.random()*4+2);
		for (int i=0; i<numeroDeFonemas;i++)
		{
			nombre=nombre.concat(fonemas[(int)(Math.random()*fonemas.length)]);
		}
		return nombre;
	}
	public int generadorDeNumerosId(int [] numerosIdentificadoresEnUso)
	{
		return 1;
	}
	
}
