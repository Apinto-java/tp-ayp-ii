package factory;

import java.util.HashMap;

import warriors.Warrior;

public class Factory {
	
	private static Factory instance;
	private HashMap<String, WarriorFactory> factories;
	
	public static Factory getInstance() {
		if(instance == null)
			instance = new Factory();
		
		return instance;
	}
	
	private Factory() {
		factories = new HashMap<String, WarriorFactory>();
		factories.put("Wrives", new WrivesFactory());
		factories.put("Reralopes", new ReralopesFactory());
		factories.put("Radaiteran", new RadaiteranFactory());
		factories.put("Nortaichian", new NortaichianFactory());
	}
	
	//"Wrives"
	public Warrior getNewWarrior(String type) {
		return factories.get(type).getNewWarrior();
	}
	
}
