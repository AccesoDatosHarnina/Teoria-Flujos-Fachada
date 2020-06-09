package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.Indicable;
import modelo.acceso.grabador.GrabadorObjetos;
import modelo.acceso.recuperador.RecuperadorObjetos;

public class ClienteAleatorioDAO<ClienteDTO, Integer> extends DAOObjetos<ClienteDTO, Integer> {

	public ClienteAleatorioDAO(RecuperadorObjetos<ClienteDTO, Integer> recuperador,
			GrabadorObjetos<ClienteDTO> grabador, String path) {
		super(recuperador, grabador, path);
	}

	@Override
	public boolean graba(ClienteDTO DTO) {
		try {
			grabador.iniciarOperacion(path);
			((GrabadorObjetos<ClienteDTO>) grabador).inserta((Indicable) DTO);
			grabador.cierraElemento();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<ClienteDTO> recupera() throws IOException {
		try {
			recuperador.iniciaOperacion(path);
			ArrayList<ClienteDTO> recupera = ((RecuperadorObjetos<ClienteDTO, Integer>) recuperador).recupera();
			recuperador.cierraElemento();
			return recupera;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ClienteDTO recupera(Integer k) {
		ClienteDTO recupera;
		try {
			recuperador.iniciaOperacion(path);
			recupera = ((RecuperadorObjetos<ClienteDTO, Integer>) recuperador).recupera(k);
			recuperador.cierraElemento();
		} catch (Exception e) {
			return null;
		}
		return recupera;
	}

}
