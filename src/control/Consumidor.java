package control;

import java.io.IOException;
import java.util.ArrayList;

import modelo.acceso.Fachada;
import modelo.dto.ClienteDTO;
import modelo.dto.SocioDTO;

public class Consumidor {
	public static void main(String[] args) {
		ClienteDTO cliente=new ClienteDTO(1, "javierito", true, 12.5f);
		//texto
//		ArticuloDTO art=new ArticuloDTO(3,"brocha");
		SocioDTO socio=new SocioDTO();
		Fachada fachada=new Fachada();
		fachada.graba(cliente);
		cliente=new ClienteDTO(2, "ismael", true, 12.5f);
		fachada.graba(cliente);
		cliente=new ClienteDTO(3, "francesco", true, 12.5f);
		fachada.graba(cliente);
		cliente=new ClienteDTO(4, "demogorgon", true, 12.5f);
		fachada.graba(cliente);
		cliente=new ClienteDTO(3, "francesco", true, 12.5f);
		fachada.graba(cliente);
		fachada.graba(socio);
//		fachada.graba(art);
//		fachada.graba(socio);
//		ArrayList<ArticuloDTO> lecturArticulo = null;
//		try {
//			lecturArticulo = fachada.leerArticulos();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for (ArticuloDTO articulo : lecturArticulo) {
//			System.out.println(articulo.getNombre());
//		}
		try {
			ArrayList<ClienteDTO> lecturClientes=fachada.leerClientes();
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fachada.leerCliente(3).getNombre());
	}
}
