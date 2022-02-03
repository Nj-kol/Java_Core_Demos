package com.njkol.java9;

/**
 *  In Java 9 and later versions, an interface can have six kinds of things:
 *	1. Constant variables
 *	2. Abstract methods
 *	3. Default methods
 *	4. Static methods
 *	5. Private methods
 *	6. Private Static methods
 *
 * @author Nilanjan Sarkar
 *
 */
public interface DBLogging {
	
	String MONGO_DB_NAME = "ABC_Mongo_Datastore";
	String NEO4J_DB_NAME = "ABC_Neo4J_Datastore";
	String CASSANDRA_DB_NAME = "ABC_Cassandra_Datastore";

	default void logInfo(String message) {
		log(message, "INFO");
	}

	default void logWarn(String message) {
		log(message, "WARN");
	}

	default void logError(String message) {
		log(message, "ERROR");
	}

	default void logFatal(String message) {
		log(message, "FATAL");
	}

	private void log(String message, String msgPrefix) {
		// Step 1: Connect to DataStore
		// Step 2: Log Message with Prefix and styles etc.
		// Step 3: Close the DataStore connection
	}
	// Any other abstract, static, default methods
}

