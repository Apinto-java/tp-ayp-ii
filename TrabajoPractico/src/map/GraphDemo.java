package map;

import java.util.PriorityQueue;

import exceptions.NonExistentPathException;
import warriors.Nortaichian;
import warriors.Radaiteran;
import warriors.Reralopes;
import warriors.Troop;
import warriors.Warrior;
import warriors.Wrives;
import warriorsTest.TestBuddy;

public class GraphDemo {

	public static void main(String[] args) {

		Graph map = Graph.getInstance();
		
		PriorityQueue<Warrior> pq1 = new PriorityQueue<Warrior>();
		PriorityQueue<Warrior> pq2 = new PriorityQueue<Warrior>();
		PriorityQueue<Warrior> pq3 = new PriorityQueue<Warrior>();
		PriorityQueue<Warrior> pq4 = new PriorityQueue<Warrior>();
		PriorityQueue<Warrior> pq5 = new PriorityQueue<Warrior>();
		
		for (int i = 0; i < 50; i++) {
			pq1.add(new Wrives());
		}
		
		for (int i = 0; i < 25; i++) {
			pq2.add(new Reralopes());
		}
		
		for (int i = 0; i < 30; i++) {
			pq3.add(new Nortaichian());
		}
		
		for (int i = 0; i < 100; i++) {
			pq4.add(new Radaiteran());
		}
		
		for (int i = 0; i < 75; i++) {
			pq5.add(new TestBuddy());
		}
		
		map.addVertex(new Vertex("A", new Troop(pq1, Alignment.PROPIO)));
		map.addVertex(new Vertex("B", new Troop(pq2, Alignment.ALIADO)));
		map.addVertex(new Vertex("C", new Troop(pq3, Alignment.ALIADO)));
		map.addVertex(new Vertex("D", new Troop(pq4, Alignment.ENEMIGO)));
		map.addVertex(new Vertex("E", new Troop(pq5, Alignment.ENEMIGO)));
		
		map.addPath("A", "B", 10);
		map.addPath("C", "D", 15);
		map.addPath("A", "C", 12);
		map.addPath("A", "D", 3);
		map.addPath("A", "E", 30);
		map.addPath("E", "D", 1);
		map.addPath("B", "C", 19);
		map.addPath("B", "D", 9);
		map.addPath("A", "D", 3);
		map.addPath("B", "E", 2);
		
		System.out.println(map.toString());

		System.out.println("------------");

		System.out.println(map.dijkstra("A"));

		System.out.println("------------");
		
		try {
			System.out.println(map.getShortestPathFrom("A", "E"));
		} catch (NonExistentPathException e) {
			System.err.println(e);
		}
	}
}
