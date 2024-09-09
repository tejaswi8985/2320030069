package week2inlab;

public class Logger1 {
	private static Logger1 instance;
	private Logger1() {
	// private constructor to prevent direct instantiation
	}
	public static Logger1 getInstance() {
	if (instance == null) {
	instance = new Logger1();
	}
	return instance;
	}
	public void log(String message) {
	// Logging implementation goes here
	System.out.println("Logging message: " + message);
	}
}
