package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.grabador.Grabador;
import modelo.acceso.recuperador.Recuperador;
import modelo.dto.SocioDTO;

public class SocioDAO extends DAO<SocioDTO> {

	public SocioDAO(Recuperador recuperador, Grabador grabador, String path) {
		super(recuperador, grabador, path);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean graba(SocioDTO DTO) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ArrayList<SocioDTO> recupera() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
