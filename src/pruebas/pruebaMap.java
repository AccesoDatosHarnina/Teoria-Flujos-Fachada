package pruebas;

import java.util.Map.Entry;
import java.util.Comparator;
import java.util.TreeMap;

public class pruebaMap {

	public static void main(String[] args) {
		TreeMap<Integer, Integer> unoiMap=new TreeMap<Integer, Integer>();
		unoiMap.put(1, 1);
		unoiMap.put(2, 2);
		unoiMap.put(16, 3);
		unoiMap.put(8, 4);
		unoiMap.put(4, 5);
		unoiMap.put(12, 6);
		unoiMap.put(10, 7);
		do {
			Entry<Integer, Integer> pollFirstEntry = unoiMap.pollFirstEntry();
			System.out.println(pollFirstEntry.getKey());
		}while(true);
		
	}

}
