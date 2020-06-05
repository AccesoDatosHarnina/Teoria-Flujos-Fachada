package modelo.acceso.recuperador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RecuperadorTexto implements Recuperador {
	private BufferedReader bufferedReader;
	private String actualString;
	private String elementos[] = {};
	private int elementoActual = 0;

	private boolean recuperarElementos() throws IOException {
		boolean recupera = true;
		try {
			actualString = bufferedReader.readLine();
			elementos = actualString.split(":");
		} catch (Exception e) {
			recupera = false;
		}
		return recupera;
	}

	@Override
	public int recuperaInt() throws IOException {
		Integer valueOf = Integer.valueOf(elementos[elementoActual]);
		actualizarElementoActual();
		return valueOf;
	}

	private void actualizarElementoActual() throws IOException {
		elementoActual++;
		if (elementoActual == elementos.length) {
			elementoActual = 0;
		}
	}

	@Override
	public float recuperaFloat() throws IOException {
		Float valueOf = Float.valueOf(elementos[elementoActual]);
		actualizarElementoActual();
		return valueOf;
	}

	@Override
	public double recuperaDouble() throws IOException {
		Double valueOf = Double.valueOf(elementos[elementoActual]);
		actualizarElementoActual();
		return valueOf;
	}

	@Override
	public String recuperaString() throws IOException {
		String valueOf = elementos[elementoActual];
		actualizarElementoActual();
		return valueOf;
	}

	@Override
	public boolean recuperaBoolean() throws IOException {
		Boolean valueOf = Boolean.valueOf(elementos[elementoActual]);
		actualizarElementoActual();
		return valueOf;
	}

	@Override
	public boolean cierraElemento() throws IOException {
		boolean response = true;
		if (!recuperarElementos()) {
			response = false;
			bufferedReader.close();
		}
		return response;
	}

	@Override
	public boolean iniciaOperacion(String path) {
			try {
				bufferedReader = new BufferedReader(new FileReader(path));
				recuperarElementos();
				return true;
			} catch (IOException e) {
				return false;
			}
		}
	}
