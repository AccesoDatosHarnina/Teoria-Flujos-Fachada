package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.grabador.Grabador;
import modelo.acceso.recuperador.Recuperador;
import modelo.dto.ClienteDTO;

public class ClienteDAO extends DAO<ClienteDTO> {

	public ClienteDAO(Recuperador recuperador, Grabador grabador, String path) {
		super(recuperador, grabador, path);
	}

	@Override
	public boolean graba(ClienteDTO DTO) {
		boolean retorno = true;
		try {
			grabador.iniciarOperacion(path);
			grabador.insertaElemento(DTO.getNumero());
			grabador.insertaElemento(DTO.getNombre());
			grabador.insertaElemento(DTO.isPreferente());
			grabador.insertaElemento(DTO.getSaldo());
			grabador.cierraElemento();
		} catch (IOException e) {
			retorno=false;
		}
		return retorno;
	}

	@Override
	public ArrayList<ClienteDTO> recupera() throws IOException {
		ArrayList<ClienteDTO> lista=new ArrayList<ClienteDTO>();
		recuperador.iniciaOperacion(path);
		do{
			lista.add(new ClienteDTO(
				recuperador.recuperaInt(),
				recuperador.recuperaString(),
				recuperador.recuperaBoolean(),
				recuperador.recuperaFloat()));
		}while(recuperador.cierraElemento());
		return lista;
	}

}
