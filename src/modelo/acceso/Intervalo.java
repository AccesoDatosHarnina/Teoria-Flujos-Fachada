package modelo.acceso;

import java.io.Serializable;

public class Intervalo implements Serializable {
	public long inicio;
	public long fin;

	public Intervalo(long inicio, long fin) {
		super();
		this.inicio = inicio;
		this.fin = fin;
	}

	public long getDiferencia() {
		return fin - inicio;
	}

}
