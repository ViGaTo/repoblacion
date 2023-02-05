package repoblacion.modelo;

public class Arbol {

	private Posicion posicion;
	private Especie especie;
	
	public Arbol(Especie especie, Posicion posicion) {
		setEspecie(especie);
		setPosicion(posicion);
	}
	
	public Arbol(Arbol arbol) {
		if(arbol==null)
			throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");
		
		setEspecie(arbol.getEspecie());
		setPosicion(arbol.getPosicion());
	}
	
	public Posicion getPosicion() {
		return new Posicion(posicion);
	}
	private void setPosicion(Posicion posicion) {
		if(posicion==null)
			throw new NullPointerException("ERROR: La posición no puede ser nula.");
		
		this.posicion = new Posicion(posicion);
	}
	public Especie getEspecie() {
		return especie;
	}
	private void setEspecie(Especie especie) {
		if(especie==null)
			throw new NullPointerException("ERROR: La especie no puede ser nula.");
		
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "especie=" + especie + ", posicion=(" + posicion + ")";
	}
}
