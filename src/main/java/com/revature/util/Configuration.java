package com.revature.util;

import org.apache.log4j.Logger;
;

public class Configuration {
	
	public static String DB_USER = "postgres";
    public static String DB_PASSWORD = "postgres";
    public static String DB_HOST = "localhost";
    public static String DB_NAME = "christianm";

	private static final Configuration INSTANCE = new Configuration();
	
	private Configuration() {
		
	}
	
	public static Configuration getInstance() {
        return INSTANCE;
    }
	
	
}
