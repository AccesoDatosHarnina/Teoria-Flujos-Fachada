package modelo.acceso;

public interface Indicable<K extends Comparable<K>> {
	public K getKey();
	public void setKey(K t);
}
