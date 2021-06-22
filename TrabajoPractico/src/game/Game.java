package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		
		System.out.println("Select Option: \n" + "1. Is this mission factible? \n" + "2. Load map \n");
		
		int option = askForMenuOption();
		
		switch (option) {
		case 1:

			System.out.println("Yes.");
			break;

		case 2:
			loadMapFromPath();
			System.out.println("Loaded. ");
			break;

		default:

			System.err.println("Error.");
			break;
		}
	}
	
	/**
	 * 
	 * @return The menu option selected by the use. If it is invalid it will ask the user
	 * again for input
	 */
	private static int askForMenuOption() {
		
		String input = scan.next();
		int option = 0;
		
		try {
			option = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			System.out.println("Por favor ingrese un numero");
			option = askForMenuOption();
		}
		
		return option;
	}

	private static void loadMapFromPath() {

		try {
			System.out.println("## Loading MAP \nPlease specify the path to the Map (i.e: C:\\Game\\Map.txt): ");
			String fileInputPath = scan.nextLine();
			if (!fileInputPath.isEmpty()) {
				/**
				* loadFile(fileInputPath);
				*/
			}

		}  catch (Exception e) {
			System.err.println(e);
		}
	}

	private void loadFile(String pFile) throws Exception {
		BufferedReader lector = new BufferedReader(new FileReader(pFile));

		try {
			String line = lector.readLine();
			while (line != null) { 
				/*
				*IMP
				*/
			}
		// Agregar excp IO
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			lector.close();
		}
	}
	
	private void startMission() {

		String[] itinerario = obtenerInicioFin();
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
	private boolean avanzarPor(ArrayList<String> recorrido, Army ownArmy) {
		
		boolean out = false;
		Grafo map = Grafo.getInstance();
		
		Vertice thisTown = map.getTown(recorrido.get(0));
		
		if(thisTown.isAlly()) {
			ownArmy.addMilitaryUnit(thisTown.giveTroop());
			
			ownArmy.rest();
		} else{
			Battle.between(ownArmy, thisTown.getArmy());
		}
		
		if(ownArmy.isStillAlive() && !recorrido.isEmpty()) {
			recorrido.remove(0);
			avanzarPor(recorrido, ownArmy);
		} else if (!ownArmy.isStillAlive()){
			System.err.println("Failed mission.");
			out = false;
		} else {
			System.out.println("Mision complete. Won with : "); // debe agregar cuantos dias duro y cuantos quedaron.
			out = true;
		}
		
		return out;
	}
}
