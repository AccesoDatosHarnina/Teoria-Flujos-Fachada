package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.Indicable;
import modelo.acceso.grabador.Grabador;
import modelo.acceso.grabador.GrabadorObjetos;
import modelo.acceso.recuperador.Recuperador;
import modelo.acceso.recuperador.RecuperadorObjetos;
import modelo.dto.ClienteDTO;

public class ClienteAleatorioDAO<ClienteDTO, Integer> extends DAOObjetos<ClienteDTO, Integer> {

	public ClienteAleatorioDAO(RecuperadorObjetos<ClienteDTO, Integer> recuperador,
			GrabadorObjetos<ClienteDTO> grabador, String path) {
		super(recuperador, grabador, path);
	}

	@Override
	public boolean graba(ClienteDTO DTO) {
		try {
			grabador.iniciarOperacion(path);
			((GrabadorObjetos<ClienteDTO>)grabador).insertaElemento((Indicable)DTO);
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
			ArrayList<ClienteDTO> recupera = ((RecuperadorObjetos<ClienteDTO, Integer>)recuperador).recupera();
			recuperador.cierraElemento();
			return recupera;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ClienteDTO recupera(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

}
