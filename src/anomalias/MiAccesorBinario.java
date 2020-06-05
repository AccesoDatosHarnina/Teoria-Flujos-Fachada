package anomalias;

import java.io.IOException;

/*
 * Implementar juntas las dos interfaces crea una clase
 * con poca cohesion porque no hay ningun motivo para que estén juntas
 * las implementacion de que vienen de las dos interfaces 
 */
public class MiAccesorBinario implements Accesor {

	@Override
	public boolean reiniciaOperacion(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int recuperaInt() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float recuperaFloat() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double recuperaDouble() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String recuperaString() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean recuperaBoolean() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cierraElementoR() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void iniciarOperacion(String path) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertaElemento(int obj) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertaElemento(float obj) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertaElemento(double obj) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertaElemento(String obj) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertaElemento(boolean obj) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void cierraElemento() throws IOException {
		// TODO Auto-generated method stub

	}

}
