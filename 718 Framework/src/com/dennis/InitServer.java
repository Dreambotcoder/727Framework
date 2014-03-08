package com.dennis;

import com.dennis.utilities.Logger;
import com.dennis.world.World;

public class InitServer {
	
	private static Logger logger = Logger.getLogger("RuneScape");

	public static void main(String[] args) {
		World.init();
		logger.log("Inited World...");
	}

}
