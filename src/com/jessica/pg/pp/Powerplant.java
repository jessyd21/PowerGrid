package com.jessica.pg.pp;

import java.util.Locale;

/**
 * Represents one powerplant card.
 * 
 * @author Jessica
 */
public class Powerplant implements Comparable<Powerplant> {
	final int baseNumber;
	final ResourceType resourceType;
	final int resourceCount;
	final int citiesPowered;
	
	public Powerplant(int baseNumber, ResourceType resourceType, int resourceCount, int citiesPowered) {
		this.baseNumber = baseNumber;
		this.resourceType = resourceType;
		this.resourceCount = resourceCount;
		this.citiesPowered = citiesPowered;
	}

	@Override
	public int compareTo(Powerplant other) {
		return this.baseNumber - other.baseNumber;
	}
	
	@Override
	public String toString() {
		return String.format(Locale.ROOT, "Powerplant #%d: %d %s for %d cities",
				baseNumber, resourceCount, resourceType, citiesPowered);
	}
}
