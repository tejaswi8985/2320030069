package com.tejaswi;

public class LoggerTest {
	public static void main(String[] args) {
	Logger1 logger = Logger1.getInstance();
	      logger.log("This is a test log message.");
	       Logger1 anotherLogger = Logger1.getInstance();
	     anotherLogger.log("This is another test log message.");
            if (logger == anotherLogger) {
	            System.out.println("Logger1 is a singleton. Both instances are the same.");
	        } else {
	            System.out.println("Logger1 is not a singleton. Instances are different.");
	         
	        }
		}

	}
