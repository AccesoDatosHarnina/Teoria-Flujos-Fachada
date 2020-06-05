package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.grabador.Grabador;
import modelo.acceso.recuperador.Recuperador;

public abstract class DAO<T> {
	protected Recuperador recuperador;
	protected Grabador grabador;
	protected String path;
	
	public DAO(Recuperador recuperador, Grabador grabador, String path) {
		super();
		this.recuperador = recuperador;
		this.grabador = grabador;
		this.path = path;
	}

	public abstract boolean graba(T DTO);

	public abstract ArrayList<T> recupera() throws IOException;
}
