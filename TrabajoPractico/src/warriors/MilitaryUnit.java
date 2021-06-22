package warriors;

import map.Alignment;

public abstract class MilitaryUnit implements Comparable<MilitaryUnit>{
	
	protected Alignment alignment;	// Whether this MilitaryUnit is my own, allied or enemy

	public Alignment getAlignment() {
		return alignment;
	}
	
	public abstract void attack(Warrior anotherWarrior);
	
	public abstract void rest();

	public abstract Warrior getFirstWarrior();
	
	public abstract double getHealthPoints();
	
	public abstract boolean isStillAlive();

	public int compareTo(MilitaryUnit o) {
		
		if(this.getAlignment().equals(Alignment.PROPIO) && (o.getAlignment().equals(Alignment.ALIADO) || o.getAlignment().equals(Alignment.ENEMIGO)))
			return 1;
		else if(this.getAlignment().equals(Alignment.ALIADO) && o.getAlignment().equals(Alignment.ENEMIGO))
			return 1;
		else if(this.getAlignment().equals(Alignment.ALIADO) && o.getAlignment().equals(Alignment.PROPIO))
			return -1;
		
		// the only alternate option is that both alignments are equals to each other.
		return 0;
	}

	public abstract String toString();
}
