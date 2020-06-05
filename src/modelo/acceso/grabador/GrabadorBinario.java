package modelo.acceso.grabador;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GrabadorBinario implements Grabador {
	private DataOutputStream conversorW;
	
	@Override
	public void insertaElemento(int obj) throws IOException {
		conversorW.writeInt(obj);
		
	}

	@Override
	public void insertaElemento(float obj) throws IOException {
		conversorW.writeFloat(obj);
		
	}

	@Override
	public void insertaElemento(double obj) throws IOException {
		conversorW.writeDouble(obj);
		
	}

	@Override
	public void insertaElemento(String obj) throws IOException {
		conversorW.writeUTF(obj);		
	}

	@Override
	public void insertaElemento(boolean obj) throws IOException {
		conversorW.writeBoolean(obj);		
	}

	@Override
	public void cierraElemento() throws IOException {
		conversorW.close();		
	}

	@Override
	public void iniciarOperacion(String path) throws FileNotFoundException {
		conversorW= new DataOutputStream(new FileOutputStream(path,true));
		
	}

	

}
