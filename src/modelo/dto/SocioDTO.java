package modelo.dto;

import modelo.acceso.Secundaria;

public class SocioDTO implements Secundaria<String, String> {
	public float nose;
	public String DNI;
	public String telefono;

	@Override
	public String getKey() {
		return DNI;
	}

	@Override
	public void setKey(String t) {
		this.DNI = t;

	}

	@Override
	public String getSecundaria() {
		return telefono;
	}
}
