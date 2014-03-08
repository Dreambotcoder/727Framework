package com.dennis.world;

import java.util.concurrent.ThreadFactory;

public class WorldProcessor implements ThreadFactory {
	
	private int count = 0;
	
	private final String prefix;
	
	private final int priority;
	
	public WorldProcessor(String prefix, int priority) {
		this.prefix = prefix;
		this.priority = priority;
	}

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable, (prefix + "-" + count++));
		if (thread.isDaemon())
			thread.setDaemon(false);
		if (thread.getPriority() != priority)
			thread.setPriority(priority);
		return thread;
	}

}
