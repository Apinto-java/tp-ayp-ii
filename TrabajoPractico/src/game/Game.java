package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import map.Alignment;
import map.Grafo;
import map.Vertice;
import warriors.Army;
import warriors.MilitaryUnit;
import warriors.Troop;

@SuppressWarnings("unused")
public class Game {
	
	private static Scanner scan;
	
	private static Army ownArmy;
	private static String[] tripRoute;
	private static int days;

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		days = 0;
		
		loadMapFromPath();
		startMission();		
	}
	
	private static void loadMapFromPath() {
		try {
			System.out.println("#########################################");
			System.out.println("## Welcome to Fantasy Land Reconquest! ##" );
			System.out.println("#########################################");
			System.out.println();
			System.out.print("Please specify the path to the Map (i.e: C:\\Game\\Map.txt): ");
			String fileInputPath = scan.nextLine();
			
			if (!fileInputPath.isEmpty())
				loadFile(fileInputPath);
		}  catch (Exception e) {
			System.err.println(e);
		}
	}

	private static void loadFile(String pFile) throws Exception, OwnTownException {
		BufferedReader reader = new BufferedReader(new FileReader(pFile));

		int lineCount=1;
		
		boolean foundOwned = false;
		
		try {
			String line = reader.readLine();
			int graphSize = 0;
			while (line != null) { 
				
				line = line.trim();
				if(line.isEmpty() || line.isBlank()) throw new Error("La línea está vacía."); // Agregar excepciones pendientes.
				
				if(lineCount == 1) 
					graphSize = getTownsQty(line);
			
				if(lineCount >= 2 && lineCount < graphSize + 2) {
					String idTown;
					int soldiers;
					String warrior;
					String alignment;
					
					String[] townDetails = line.split(" ");
					idTown 		= townDetails[0].trim();
					soldiers 	= Integer.parseInt(townDetails[1]);
					warrior		= townDetails[2].trim();
					alignment	= townDetails[3].trim().toUpperCase();
									
					if (alignment.equals("PROPIO") && !foundOwned) {
						Troop ownTroop = new Troop(warrior, soldiers, Alignment.valueOf(alignment.trim()));
						ownArmy = new Army(ownTroop);
						foundOwned = true;
					} else if (alignment.equals("PROPIO") && foundOwned) { 
						throw new OwnTownException();
						
					}
					
					Troop troop = new Troop(warrior, soldiers, Alignment.valueOf(alignment.trim()));
					Vertice vertex = new Vertice(idTown, troop);
					
					Grafo.getInstance().addVertex(vertex);
				}
				
				if(lineCount == graphSize + 2) {
					tripRoute = line.split("->");
					tripRoute[0] = tripRoute[0].trim();
					tripRoute[1] = tripRoute[1].trim();
				}
				
				if(lineCount >= graphSize + 3) {
					String[] edges = line.split(" ");
					String vertexA = edges[0];
					String vertexB = edges[1];
					int duration = Integer.parseInt(edges[2]);
					
					Grafo.getInstance().addPath(vertexA, vertexB, duration);
				}
				
				lineCount++;
				line = reader.readLine();
			}
			
			//System.out.println(Grafo.getInstance());
			
		// Agregar excp IO
		} catch (Exception e) {
			e.printStackTrace();
//			System.err.println(e);
		} finally {
			reader.close();
		}
	}
	
	private static int getTownsQty(String linea) {
		int townsQuantity;
		linea = linea.trim();
		townsQuantity = Integer.parseInt(linea);
		return townsQuantity;
	}
	
	/**
	 * 
	 * @return The menu option selected by the use. If it is invalid it will ask the user
	 * again for input
	 */
	
	private static void startMission() {

		String[] itinerario = getTripRoute();
		Army ownArmy = getOwnArmy();

		Grafo map = Grafo.getInstance();

		ArrayList<String> caminoMasCorto = map.obtenerCaminoMasCortoDesde(itinerario[0], itinerario[1]);

		boolean done = avanzarPor(caminoMasCorto, ownArmy);
		
		if(done) {
			System.out.println("Mission accomplished! Ended with: " + ownArmy.toString());
			System.out.println("Days: " + days);
		}
		else
			System.err.println("Mission failed.");
	}

	private static Army getOwnArmy() {
		return ownArmy;
	}

	// devuelve en [0] el inicio y en [1] el final
	private static String[] getTripRoute() {
		return tripRoute;
	}

	private static boolean avanzarPor(ArrayList<String> recorrido, Army ownArmy) {

		Grafo map = Grafo.getInstance();
		
		// validacion para no repetir pueblo propio
		boolean ourTown = false;
		
		while(ownArmy.isStillAlive() && !recorrido.isEmpty()) {
			
			Vertice thisTown = map.getTown(recorrido.get(0));
			
			if(recorrido.size() >= 2) {
				// Store the destination in a String variable so we can get how much days it would take to get there
				String destination = recorrido.get(1);
				// It retrieves the days it would take to get to the destination
				days += thisTown.getDaysToTown(destination);
			}
			
			recorrido.remove(0);
			
				if(thisTown.isAlly()) {
				ownArmy.addMilitaryUnit(thisTown.giveTroop());
				
				ownArmy.rest();
				days += 1;	//One day used either for resting
			} else if(thisTown.isEnemy()){
				Battle.between(ownArmy, thisTown.getArmy());
				days += 1;	//One day for combat
			}
		
		}
		
		return ownArmy.isStillAlive();
	}
}
