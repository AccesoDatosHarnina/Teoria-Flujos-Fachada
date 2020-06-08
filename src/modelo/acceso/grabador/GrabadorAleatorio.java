package modelo.acceso.grabador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import modelo.acceso.Indicable;
import modelo.acceso.MapaIntervalo;

public class GrabadorAleatorio<T> implements GrabadorObjetos<T> {
	private RandomAccessFile flujoAleatorio;
	private MapaIntervalo mapaIntervalo;

	@Override
	public void iniciarOperacion(String path) throws IOException {
		flujoAleatorio=new RandomAccessFile(path, "rw");
		mapaIntervalo=new MapaIntervalo();
	}

	@Override
	public void insertaElemento(int obj) throws IOException {
		flujoAleatorio.writeInt(obj);

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
		flujoAleatorio.close();

	}

	@Override
	public void insertaElemento(Indicable obj) throws IOException {
		//creamos el flujo que convierte en tren de bytes
		ByteArrayOutputStream adaptadorByte=new ByteArrayOutputStream();
		//creamos el flujo que serializa
		ObjectOutputStream serializador=new ObjectOutputStream(adaptadorByte);
		serializador.writeObject(obj);
		//al escribir el objeto serializado sonre un adaptador bytes se convierte
		//el objeto en un tren de bytes (byteArray)
		serializador.close();
		//voy al final
		flujoAleatorio.seek(flujoAleatorio.length());
		//escribo el tren de bytes en el flujo
		flujoAleatorio.write(adaptadorByte.toByteArray());
		mapaIntervalo.insertarElemento(obj, flujoAleatorio.length());
		flujoAleatorio.close();
	}

}
