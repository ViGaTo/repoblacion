package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {

	private static Bosque bosque;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int poblacion = 0;
		
		int ancho = Consola.leerAnchura();
		int alto = Consola.leerAltura();
		
		do {
			poblacion = Consola.leePoblacion();
			if(poblacion > (2*(ancho + alto))){
				System.out.println("ERROR: La población no puede superar el perímetro del bosque.");
			}
		}while(poblacion > (2*(ancho + alto)));
		
		try {
		bosque = new Bosque(ancho, alto, poblacion);
		
		bosque.realizarCalculos();
		System.out.println("Árbol más cercano: " + bosque.getArbolMasCentrado().toString());
		System.out.println("Árbol más alejado: " + bosque.getArbolMasAlejado().toString());
		}catch(IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
