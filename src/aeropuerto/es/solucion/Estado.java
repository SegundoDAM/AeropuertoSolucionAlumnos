package aeropuerto.es.solucion;

public enum Estado {
	libre,ocupada;

	public static boolean isOcupada(Estado pistaEstado) {
		return pistaEstado==ocupada;
	}
}
