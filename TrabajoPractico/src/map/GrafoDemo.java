package map;

public class GrafoDemo {

	public static void main(String[] args) {

		Grafo map = Grafo.getInstance();
		
		map.addPath("A", "B", 10);
		map.addPath("C", "D", 15);
		map.addPath("A", "C", 12);
		map.addPath("A", "D", 3);
		map.addPath("A", "E", 3);
		map.addPath("E", "D", 1);
		map.addPath("B", "C", 19);
		map.addPath("B", "D", 9);
		map.addPath("A", "D", 3);
		map.addPath("B", "E", 2);
		
		System.out.println(map.toString());

		System.out.println("------------");

		System.out.println(map.dijkstra("A"));

		System.out.println("------------");

		System.out.println(map.obtenerCaminoMasCortoDesde("A", "E"));
	}
}
