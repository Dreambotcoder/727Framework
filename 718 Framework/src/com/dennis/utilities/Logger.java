package com.dennis.utilities;

public final class Logger {
	
	private static String prefix;
	
	public static Logger getLogger(String prefix) {
		Logger logger = new Logger();
		logger.prefix = prefix;
		return logger;
	}

	public static void handle(Throwable throwable) {
		System.out.println("ERROR! THREAD NAME: "
				+ Thread.currentThread().getName());
		throwable.printStackTrace();
	}

	public static void debug(long processTime) {
		log(Logger.class, "---DEBUG--- start");
		log(Logger.class, "WorldProcessTime: " + processTime);
		log(Logger.class, "---DEBUG--- end");
	}
	
	public static void log(Object message) {
		log(prefix, message);
	}

	public static void log(Object classInstance, Object message) {
		log(classInstance.getClass().getSimpleName(), message);
	}

	public static void log(String className, Object message) {
		String text = "[" + className + "]" + " " + message.toString();
		System.out.println(text);
	}

	private Logger() {

	}

}
