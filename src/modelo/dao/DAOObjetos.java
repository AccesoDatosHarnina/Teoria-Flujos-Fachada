package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.grabador.Grabador;
import modelo.acceso.grabador.GrabadorObjetos;
import modelo.acceso.recuperador.Recuperador;
import modelo.acceso.recuperador.RecuperadorObjetos;

public abstract class DAOObjetos<T,K> extends DAO<T> {

	public DAOObjetos(RecuperadorObjetos<T, K> recuperador, GrabadorObjetos<T> grabador, String path) {
		super(recuperador, grabador, path);
	}

	public abstract boolean graba(T DTO);
	public abstract ArrayList<T> recupera() throws IOException ;
	public abstract T recupera(K k) ;
}
