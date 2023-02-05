package repoblacion.modelo;

public enum Especie {
	ALAMO("álamo"), ENCINA("encina"), CASTANO("castaño"), CIPRES("ciprés"), PINO("pino piñonero"), ROBLE("roble"), OLIVO("olivo");
	
	private String cadenaAMostrar;
	
	private Especie (String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}
	
	@Override
	public String toString() {
		return cadenaAMostrar;
	}
}

