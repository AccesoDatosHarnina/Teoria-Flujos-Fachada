package modelo.acceso.grabador;

import java.io.IOException;

import modelo.acceso.Indicable;

public interface GrabadorObjetos<T> extends Grabador {
	public void inserta(Indicable obj) throws IOException;
}
