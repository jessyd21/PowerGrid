package com.jessica.pg.pp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerplantMarket {
	List<Powerplant> available = new ArrayList<>();
	List<Powerplant> future = new ArrayList<>();
	int maxAvailable = 4;
	
	public void add(Powerplant newPlant) {
		List<Powerplant> all = new ArrayList<>();
		all.addAll(available);
		all.addAll(future);
		all.add(newPlant);
		
		Collections.sort(all);
		
		available.clear();
		future.clear();
		
		for (int i = 0; i < Math.min(maxAvailable, all.size()); i++) {
			available.add(all.get(i));
		}
		for (int i = maxAvailable; i < all.size(); i++) {
			future.add(all.get(i));
		}
	}
	
	public void remove(Powerplant p) {
		available.remove(p);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		sb.append("Available: \n");
		for (Powerplant p : available) {
			sb.append(++count).append(". ").append(p).append("\n");
		}
		
		sb.append("\nFuture: \n");
		for (Powerplant p : future) {
			sb.append(++count).append(". ").append(p).append("\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		PowerplantMarket market = new PowerplantMarket();
		
		market.add(new Powerplant(3, ResourceType.COAL, 3, 1));
		market.add(new Powerplant(4, ResourceType.OIL, 3, 1));
		market.add(new Powerplant(5, ResourceType.HYBRID, 3, 1));
		market.add(new Powerplant(6, ResourceType.COAL, 3, 2));
		market.add(new Powerplant(7, ResourceType.OIL, 3, 2));
		market.add(new Powerplant(8, ResourceType.HYBRID, 3, 2));
		market.add(new Powerplant(9, ResourceType.COAL, 2, 1));
		market.add(new Powerplant(10, ResourceType.OIL, 2, 1));
		
		System.out.println(market);
		
		
		market.remove(market.available.get(2));
		market.add(new Powerplant(13, ResourceType.CLEAN, 0, 1));
		
		
		System.out.println(market);
		
	}
}
