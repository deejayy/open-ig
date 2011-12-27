/*
 * Copyright 2008-2012, David Karnok 
 * The file is part of the Open Imperium Galactica project.
 * 
 * The code should be distributed under the LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for details.
 */

package hu.openig.model;

import hu.openig.utils.JavaUtils;

import java.util.List;

/**
 * Class representing a planet for the AI player.
 * @author akarnokd, 2011.12.08.
 */
public class AIPlanet {
	/** The original planet. */
	public Planet planet;
	/** The knowledge level about the planet. */
	public PlanetKnowledge knowledge;
	/** The planet statistics. */
	public PlanetStatistics statistics;
	/** The radar range. */
	public int radar;
	/** The inventory items of the planet. */
	public final List<AIInventoryItem> inventory = JavaUtils.newArrayList();
	/**
	 * Assign the necessary properties from a planet.
	 * @param planet the target fleet
	 * @param world the world object
	 */
	public void assign(Planet planet, AIWorld world) {
		this.planet = planet;
		this.knowledge = world.knowledge(planet);
		this.statistics = world.getStatistics(planet);
		this.radar = planet.radar;
		for (InventoryItem ii : planet.inventory) {
			inventory.add(new AIInventoryItem(ii));
		}
	}
}