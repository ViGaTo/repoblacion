package repoblacion.modelo;

public class Posicion {

	private double x;
	private double y;
	
	public Posicion(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public Posicion(Posicion posicion) {
		if(posicion==null)
			throw new NullPointerException("ERROR: No se puede copiar una posición nula.");
		
		setX(posicion.getX());
		setY(posicion.getY());
	}
	
	public double distancia(Posicion posicion) {
		if(posicion==null)
			throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
		
		double distancia = Math.sqrt(Math.pow(posicion.getX() - x, 2) + 
						   Math.pow(posicion.getY() - y, 2));
		
		return distancia;
	}

	public double getX() {
		return x;
	}

	private void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	private void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return (String.format("x=%5.3f, y=%5.3f", x, y));
	}
}
