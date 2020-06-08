package modelo.dao;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.grabador.Grabador;
import modelo.acceso.recuperador.Recuperador;
import modelo.dto.ArticuloDTO;

public class ArticuloDAO extends DAO<ArticuloDTO>{

	public ArticuloDAO(Recuperador recuperador, Grabador grabador, String path) {
		super(recuperador, grabador, path);
	}

	@Override
	public boolean graba(ArticuloDTO DTO) {
		boolean retorno = true;
		try {
			grabador.iniciarOperacion(path);
			grabador.insertaElemento(DTO.getNumeroID());
			grabador.insertaElemento(DTO.getNombre());
			grabador.cierraElemento();
		} catch (IOException e) {
			retorno=false;
		}
		return retorno;
	}

	@Override
	public ArrayList<ArticuloDTO> recupera() throws IOException {
		ArrayList<ArticuloDTO> lista=new ArrayList<ArticuloDTO>();
		recuperador.iniciaOperacion(path);
		do{
			lista.add(new ArticuloDTO(
				recuperador.recuperaInt(),
				recuperador.recuperaString()));
		}while(recuperador.cierraElemento());
		return lista;
	}

}
