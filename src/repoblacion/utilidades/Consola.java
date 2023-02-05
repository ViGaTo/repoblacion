package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private Consola() {
		
	}
	
	public static int leerAnchura() {
		int ancho;
		
		do {
			System.out.print("Introduce la anchura del bosque: ");
			ancho = Entrada.entero();
		}while(ancho<10 || ancho>1000);
	
		return ancho;
	}
	
	public static int leerAltura() {
		int altura;
		
		do {
			System.out.print("Introduce la altura del bosque: ");
			altura = Entrada.entero();
		}while(altura<10 || altura>500);
	
		return altura;
	}
	
	public static int leePoblacion() {
		int poblacion;
		
		do {
			System.out.print("Introduce la población de especies: ");
			poblacion = Entrada.entero();
		}while(poblacion<=0);
	
		return poblacion;
	}
}