package game;

import java.util.Scanner;

import map.Grafo;

public class Game {
	
	private static Scanner scan;
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		System.out.println("Select Option: \n"
				+ "1. Is factible this mission? \n"
				+ "2. Load map \n");
		
		int option = scan.nextInt();
		
		switch (option) {
		case 1:
			
			System.out.println("Yes.");
			break;
			
		case 2:

			System.out.println("Loaded.");
			break;
			
		default:
			
			System.err.println("Error.");
			break;
		}
	}
	
	private void startMission() {
		
		Grafo grafo = Grafo.
	}
}
