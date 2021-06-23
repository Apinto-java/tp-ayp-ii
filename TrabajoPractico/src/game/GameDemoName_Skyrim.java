package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameDemoName_Skyrim {

	public static void main(String[] args) {
		File file = new File("Skyrim.txt");
		
		try {
			FileWriter fw = new FileWriter(file);
			
			fw.write(
					"9" + "\n" +
					"WhiteRun 150 Nortaichian propio" + "\n" +
					"Falkreath 10 Reralopes aliado" + "\n" +
					"Markarth 50 Wrives enemigo" + "\n" +
					"Riften 30 Radaiteran aliado" + "\n" +
					"Solitude 150 Nortaichian aliado" + "\n" +
					"Morthal 10 Radaiteran aliado" + "\n" +
					"Dawnstar 80 Radaiteran aliado" + "\n" +
					"Winterhold 100 Wrives enemigo" + "\n" +
					"Windhelm 150 Radaiteran enemigo" + "\n" +
					"WhiteRun -> Windhelm" + "\n" +
					"WhiteRun Morthal 5" + "\n" +
					"WhiteRun Solitude 20" + "\n" +
					"Morthal Solitude 10" + "\n" +
					"Solitude Markarth 10" + "\n" +
					"Solitude Falkreath 40" + "\n" +
					"Markrath Falkreath 20" + "\n" +
					"Falkreath Riften 15" + "\n" +
					"Riften Winterhold 20" + "\n" +
					"Riften Windhelm 40" + "\n" +
					"Winterhold Dawnstar 5" + "\n" +
					"Dawnstar Windhelm 12"
					);
		
			fw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		System.out.println(file.getAbsolutePath()+"\n");
		
		Game.main(null);
	}
}
