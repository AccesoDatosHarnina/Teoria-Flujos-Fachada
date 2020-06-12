package modelo.acceso;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.TreeMap;

public class MapaAsociado<K, V> {
	private String path;
	private TreeMap<K, V> mapaTreeMap;

	public MapaAsociado(String path) {
		super();
		this.path = path;
		try {
			ObjectInputStream sInputStream = new ObjectInputStream(new FileInputStream(path));
			mapaTreeMap = (TreeMap<K, V>) sInputStream.readObject();
			sInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			mapaTreeMap = new TreeMap<K, V>();
		}
	}
	public V get(K key) {
		return mapaTreeMap.get(key);
	}
	public boolean insertar(K clave, V v) {
		assert clave != null && v!=null;
		if (mapaTreeMap.containsKey(clave)) {
			return false;
		}
		mapaTreeMap.put(clave, v);
		ObjectOutputStream ooStream = null;
		try {
			ooStream = new ObjectOutputStream(new FileOutputStream(path));
			ooStream.writeObject(mapaTreeMap);
		} catch (IOException e) {
			return false;
		} finally {
			try {
				ooStream.close();
			} catch (IOException e) {
				return false;
			}
		}
		return true;
	}
	public Collection<V> getTodos() {
		return mapaTreeMap.values();
	}

	public void borrar(K obj) {
		mapaTreeMap.remove(obj);
	}
}
