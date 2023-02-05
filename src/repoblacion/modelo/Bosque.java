package repoblacion.modelo;

import java.util.Arrays;
import java.util.Random;

public class Bosque {

	public int MAX_ALTURA = 500;
	public int MINIMO = 10;
	public int MAX_ANCHURA = 1000;
	public int MAX_ESPECIES = 4;
	
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	private Random generador = new Random();
	
	private int ancho;
	private int alto;
	
	private Arbol[] arboles;
	
	public Bosque(int ancho, int alto, int poblacion) {
		setAncho(ancho);
		setAlto(alto);
		checkPoblacion(poblacion);
		arboles = new Arbol[poblacion];
		
		repoblar();
	}
	
	public void realizarCalculos() {
		Posicion posicionCero = new Posicion(0, 0);
		double distanciaMaxima = Double.MIN_VALUE;
		double distanciaMinima = Double.MAX_VALUE;
		
		for(int i = 0; i < arboles.length; i++) {
			double distancia = arboles[i].getPosicion().distancia(posicionCero);
			
			if(distancia > distanciaMaxima) {
				distanciaMaxima=distancia;
				arbolMasAlejado=arboles[i];
			}else if(distancia < distanciaMinima) {
				distanciaMinima=distancia;
				arbolMasCentrado=arboles[i];
			}
		}
	}
	
	private void repoblar() {
		int especieAleatoriaNumero;
		Especie especieAleatoria;
		
        for(int i=0; i < arboles.length; i++) {
        	especieAleatoriaNumero = generador.nextInt(Especie.values().length);
    		especieAleatoria = Especie.values()[especieAleatoriaNumero];
    		
    		double x = (generador.nextDouble() * ancho + 1) - ancho / 2f;
            double y = (generador.nextDouble() * alto + 1) - alto / 2f;
            Posicion posicionAleatoria = new Posicion(x, y);
            arboles[i] = new Arbol(especieAleatoria, posicionAleatoria);
        }
	}
	
	public Arbol[] duplicaBosque() {
		Arbol[] copiaBosque = new Arbol[arboles.length];
		
		for (int i = 0; i < arboles.length; i++) {
			copiaBosque[i] = new Arbol(arboles[i]);
		}
		
		return copiaBosque;
	}
	
	public void checkPoblacion(int poblacion) {
		if (poblacion <= 0)
			throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");
		
		if (poblacion > (2*(ancho + alto)))
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int ancho) {
		if(ancho<MINIMO || ancho>MAX_ANCHURA)
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	
	public void setAlto(int alto) {
		if(alto<MINIMO || alto>MAX_ALTURA)
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		
		this.alto = alto;
	}
	
	public Arbol getArbolMasAlejado() {
		return new Arbol(arbolMasAlejado);
	}
	
	public Arbol getArbolMasCentrado() {
		return new Arbol(arbolMasCentrado);
	}

	@Override
	public String toString() {
		return "Bosque [ancho=" + ancho + ", alto=" + alto + ", arboles=" + Arrays.toString(arboles) + "]";
	}
}
