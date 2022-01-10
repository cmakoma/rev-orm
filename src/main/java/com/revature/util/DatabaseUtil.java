package com.revature.util;

import org.apache.log4j.Logger;

public class DatabaseUtil {
	
	private static Logger logger = Logger.getLogger(DatabaseUtil.class);

    public enum DatabaseType {
    	POSTGRES
    }

    public enum DatabaseProtocol {
    	JDBC_POSTGRES
    }

    public enum DatabaseEncoding {
        UTF8
    }

    public static String returnDBConnectionString() {
        String protocolString = "jdbc:postgresql://";
        String encodingString = "?characterEncoding=UTF-8";
        String connection = "";

        connection = protocolString + Configuration.DB_HOST + "/" + Configuration.DB_NAME.toLowerCase()
                    + encodingString;
        
        logger.debug("Returning DB connection string: " + connection);
        return connection;
    }

    public static String returnDBConnectionStringWithoutDatabase() {
        String protocolString = "jdbc:postgresql://";
        String encodingString = "/?characterEncoding=UTF-8";
        String connection = "";

        connection = protocolString + Configuration.DB_HOST + encodingString;
        
        logger.debug("Returning DB connection string: " + connection);
        return connection;
    }
}
