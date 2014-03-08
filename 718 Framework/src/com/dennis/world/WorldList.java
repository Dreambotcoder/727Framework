package com.dennis.world;

import java.util.HashMap;

public class WorldList {

	public static final HashMap<Integer, WorldListContext> WORLDS = new HashMap<Integer, WorldListContext>();

	//String activity, String ip, int countryId, String countryName, boolean members
	public static void init() {
		WORLDS.put(1, new WorldListContext("Yo", "127.0.0.1", 38, "Canada", true));
		WORLDS.put(2, new WorldListContext("Hoe Free", "127.0.0.1", 161, "Netherlands", false));
	}

	public static WorldListContext getWorld(int worldId) {
		return WORLDS.get(worldId);
	}

}