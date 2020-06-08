package modelo.acceso;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MapaIntervalo {
	private String mapaString = "mapa.data";
	private HashMap<Integer, Intervalo> mapaHashMap;
	private int max;
	private long siguiente;

	public MapaIntervalo() {
		super();
		try {
			ObjectInputStream sInputStream = new ObjectInputStream(new FileInputStream(mapaString));
			mapaHashMap = (HashMap<Integer, Intervalo>) sInputStream.readObject();
			sInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			mapaHashMap = new HashMap<Integer, Intervalo>();
		}
		Set<Integer> keySet = mapaHashMap.keySet();
		Integer[] noseIntegers = new Integer[keySet.size()];
		keySet.toArray(noseIntegers);
		for (Integer integer : noseIntegers) {
			if (max < integer) {
				max = integer;
			}
		}
		try {
			siguiente = (int) mapaHashMap.get(max).fin;
		} catch (Exception e) {
			siguiente = 0;
		}
	}

	
	public Intervalo get(Object key) {
		return mapaHashMap.get(key);
	}


	public boolean insertarElemento(Indicable clave, long fin) {
		clave.setKey(++max);
		mapaHashMap.put(clave.getKey(), new Intervalo(siguiente, fin));
		ObjectOutputStream ooStream = null;
		try {
			ooStream = new ObjectOutputStream(new FileOutputStream(mapaString));
			ooStream.writeObject(mapaHashMap);
		} catch (IOException e) {
			return false;
		} finally {
			try {
				ooStream.close();
			} catch (IOException e) {
				return false;
			}
		}
		siguiente = fin;
		return true;
	}

	public Collection<Intervalo> getTodos() {
		return mapaHashMap.values();
	}
}
