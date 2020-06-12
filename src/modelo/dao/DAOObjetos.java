package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.Indicable;
import modelo.acceso.grabador.GrabadorObjetos;
import modelo.acceso.recuperador.RecuperadorObjetos;

public class DAOObjetos<T extends Indicable, K> extends DAO<T> {

	public DAOObjetos(RecuperadorObjetos<T, K> recuperador, GrabadorObjetos<T> grabador, String path) {
		super(recuperador, grabador, path);
	}

	public boolean graba(T DTO) {
		try {
			grabador.iniciarOperacion(path);
			((GrabadorObjetos<T>) grabador).inserta(DTO);
			grabador.cierraElemento();
		} catch (IOException e) {
			return false;
		}
		return true;
	};

	public ArrayList<T> recupera() throws IOException {
		try {
			recuperador.iniciaOperacion(path);
			ArrayList<T> recupera = ((RecuperadorObjetos<T, K>) recuperador).recupera();
			recuperador.cierraElemento();
			return recupera;
		} catch (Exception e) {
			return null;
		}
	};

	public T recupera(K k) {
		T recupera;
		try {
			recuperador.iniciaOperacion(path);
			recupera = ((RecuperadorObjetos<T, K>) recuperador).recupera(k);
			recuperador.cierraElemento();
		} catch (Exception e) {
			return null;
		}
		return recupera;
	};
}
