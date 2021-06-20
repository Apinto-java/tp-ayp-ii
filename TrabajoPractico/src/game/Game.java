package game;

import java.util.ArrayList;
import java.util.Scanner;

import map.Grafo;
import map.Vertice;
import warriors.Army;
import warriors.MilitaryUnit;

@SuppressWarnings("unused")
public class Game {

	private static Scanner scan;

	public static void main(String[] args) {

		scan = new Scanner(System.in);

		System.out.println("Select Option: \n" + "1. Is factible this mission? \n" + "2. Load map \n");

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

		String[] itinerario = obtenerInicioFin();
		boolean allDead = false;
		Army ownArmy = getOwnArmy();

		Grafo map = Grafo.getInstance();

		ArrayList<String> caminoMasCorto = map.obtenerCaminoMasCortoDesde(itinerario[0], itinerario[1]);

		avanzarPor(caminoMasCorto, ownArmy);
	}

	private Army getOwnArmy() {
		// TODO Auto-generated method stub
		return null;
	}

	// devuelve en [0] el inicio y en [1] el final
	private String[] obtenerInicioFin() {
		return null;
	}

	// INCOMPLETO
	private void avanzarPor(ArrayList<String> recorrido, Army ownArmy) {
		
		Grafo map = Grafo.getInstance();
		
		Vertice thisTown = map.getTown(recorrido.get(0));
		
		if(thisTown.isAlly()) {
			ownArmy.addMilitaryUnit(thisTown.giveTroop());
			
			ownArmy.rest();
		} else{
			ownArmy.attack(thisTown.getArmy().getFirstSoldier());
		}
		
		if(ownArmy.isStillAlive() && !recorrido.isEmpty()) {
			recorrido.remove(0);
			avanzarPor(recorrido, ownArmy);
		}
	}
}
