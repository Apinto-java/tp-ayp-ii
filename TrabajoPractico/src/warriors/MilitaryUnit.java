package warriors;

import map.Alignment;

public abstract class MilitaryUnit implements Comparable<MilitaryUnit>{
	
	protected Alignment alignment;	// Whether this MilitaryUnit is my own, allied or enemy

	public Alignment getAlignment() {
		return alignment;
	}
	
	public abstract void attack(Warrior anotherWarrior);
	
	public abstract void rest();

	public abstract Warrior getFirstSoldier();
	
	public abstract double getHealthPoints();
	
	public abstract boolean isStillAlive();

	public int compareTo(MilitaryUnit o) {
		
		if(this.getAlignment().equals(Alignment.Propio) && (o.getAlignment().equals(Alignment.Aliado) || o.getAlignment().equals(Alignment.Enemigo)))
			return 1;
		else if(this.getAlignment().equals(Alignment.Aliado) && o.getAlignment().equals(Alignment.Enemigo))
			return 1;
		else if(this.getAlignment().equals(Alignment.Aliado) && o.getAlignment().equals(Alignment.Propio))
			return -1;
		
		// the only alternate option is that both alignments are equals to each other.
		return 0;
	}
}
