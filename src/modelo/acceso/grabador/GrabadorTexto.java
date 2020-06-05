package modelo.acceso.grabador;

import java.io.FileWriter;
import java.io.IOException;

public class GrabadorTexto implements Grabador {
	private FileWriter flujoMio;
	private StringBuilder elementoBuilder = new StringBuilder();

	private void escribir(String obj) throws IOException {
		elementoBuilder.append(obj + ":");
	}

	@Override
	public void insertaElemento(int obj) throws IOException {
		escribir(String.valueOf(obj));

	}

	@Override
	public void insertaElemento(float obj) throws IOException {
		escribir(String.valueOf(obj));

	}

	@Override
	public void insertaElemento(double obj) throws IOException {
		escribir(String.valueOf(obj));

	}

	@Override
	public void insertaElemento(String obj) throws IOException {
		escribir(obj);

	}

	@Override
	public void insertaElemento(boolean obj) throws IOException {
		escribir(String.valueOf(obj));

	}

	@Override
	public void cierraElemento() throws IOException {
		// quita el ultimo ":" y lo sustituye por el "\n"
		elementoBuilder.replace(elementoBuilder.length() - 1, elementoBuilder.length(), "\n");
		flujoMio.write(elementoBuilder.toString());
		flujoMio.close();

	}

	@Override
	public void iniciarOperacion(String path) throws IOException {
		flujoMio = new FileWriter(path, true);
	}

}
