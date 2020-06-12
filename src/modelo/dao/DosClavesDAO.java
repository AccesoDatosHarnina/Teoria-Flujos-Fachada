package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.Indicable;
import modelo.acceso.MapaAsociado;
import modelo.acceso.Secundaria;
import modelo.acceso.grabador.GrabadorAleatorio;
import modelo.acceso.grabador.GrabadorObjetos;
import modelo.acceso.recuperador.RecuperadorAleatorio;
import modelo.acceso.recuperador.RecuperadorObjetos;
import modelo.dto.SocioDTO;

// En estos casos se ve claro el principio efectivo de Josh Blooch que dice que 
// debemos preferir (siempre que sea conveniente) la composicion antes que la herencia.
// en este caso vemos la necesidad de un parametro de tipo L que no podria ser 
// satisfecho si quisieramos usar esta clase como su Padre como prentende el principio
// de sustitucion de Liskov

//public class DosClavesDAO<T extends Secundaria<L>, K, L> extends DAOObjetos<T, K> {

public class DosClavesDAO<T extends Secundaria<L,K>, K extends Comparable, L> {
	// esto es un componente
	private DAOObjetos<T, K> daoObjetos;
	private MapaAsociado<L, K> mapaSecundaria;

	public DosClavesDAO(RecuperadorObjetos<T, K> recuperador, GrabadorObjetos<T> grabador, String path) {
		daoObjetos = new DAOObjetos<T, K>(recuperador, grabador, path);
		mapaSecundaria = new MapaAsociado<L, K>("mapaAsociado.map");
	}

	public boolean graba(T DTO) {
		boolean response = mapaSecundaria.insertar(DTO.getSecundaria(), (K) DTO.getKey());
		if (response) {
			if (!daoObjetos.graba(DTO)) {
				mapaSecundaria.borrar(DTO.getSecundaria());
				response = false;
			}
		}
		return response;
	}

	public ArrayList<T> recupera() throws IOException {
		return daoObjetos.recupera();
	}

	public T recupera(K k) {
		return daoObjetos.recupera(k);
	}
	
	public T recuperaSecundaria(L l) {
		return daoObjetos.recupera(mapaSecundaria.get(l));
	}
	
}
