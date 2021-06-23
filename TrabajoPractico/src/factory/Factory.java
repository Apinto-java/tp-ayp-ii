package factory;

import java.util.HashMap;

import exceptions.NoSuchWarriorException;
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
		factories.put("TestBuddy", new TestBuddyFactory());
	}
	
	//"Wrives"
	public Warrior getNewWarrior(String type) throws NoSuchWarriorException {
		if(!factories.containsKey(type))
			throw new NoSuchWarriorException("Warrior " + type + " does not exist");
		
		return factories.get(type).getNewWarrior();
	}
	
}
