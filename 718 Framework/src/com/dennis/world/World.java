package com.dennis.world;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.dennis.utilities.Logger;

public class World {
	
	public static void init() {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		Executor highWorldExecutor = Executors.newFixedThreadPool(availableProcessors * 2,
				new WorldProcessor("High", 10));
		Executor medWorldExecutor = Executors.newFixedThreadPool(availableProcessors * 2,
				new WorldProcessor("Medium", 5));
		Executor lowWorldExecutor = Executors.newFixedThreadPool(availableProcessors,
				new WorldProcessor("Low", 5));
		Runnable highWorldProcess = new Runnable() {
		    public void run() {
		    	handleHighWorldProcesses();
		    }
		};
		Runnable medWorldProcess = new Runnable() {
		    public void run() {
		    	handleMedWorldProcesses();
		    }
		};
		Runnable lowWorldProcess = new Runnable() {
		    public void run() {
		    	handleLowWorldProcesses();
		    }
		};
		long sleep = 0L;
		long lastTune = System.currentTimeMillis();
		try {
		    for (;;) {
			   Thread.sleep(600L);
			long start = System.currentTimeMillis();
			highWorldExecutor.execute(highWorldProcess);
			medWorldExecutor.execute(medWorldProcess);
			lowWorldExecutor.execute(lowWorldProcess);
			long finish = System.currentTimeMillis();
			long finishTime = finish - start;
			sleep = 600L - finishTime;
			if (System.currentTimeMillis() - lastTune >= 15000L) {
			    lastTune = System.currentTimeMillis();
			    System.runFinalization();
			    System.gc();
			}
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    System.err
			.println("A fatal error has occurred in the servers core!");
		}
	}

	protected static void handleLowWorldProcesses() {
		System.out.println("lowWorldProcess");
		
	}

	public static void handleMedWorldProcesses() {
		System.out.println("MedWorldProcess");
		
	}

	public static void handleHighWorldProcesses() {
		System.out.println("HighWorldProcess");
		
	}
	
	

}
