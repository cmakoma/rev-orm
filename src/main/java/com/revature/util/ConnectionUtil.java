package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	// Instantiate Logger for reporting info
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);

	// instantiating and initializing connection
	private static Connection conn = null;

	// private constructor for singleton class to prevent multiple instantiations
	private ConnectionUtil() {
		super();
	}

	
	//	to getInstance() of
	public static Connection getConnection() { 

		// check if there is an instance
		try {
			if (conn != null && !conn.isClosed()) {
				logger.info("returned re-used connection object");
				return conn;
			}
		} catch (SQLException e) {
			logger.error("we failed to re-use a connection");
			e.printStackTrace();
			return null;
		}

		// this class is instantiated to read from a properties file
		Properties prop = new Properties(); // imported from java.util

		String url = "";
		String username = "";
		String password = "";

		// this is the NOT secure method!!
		try {

			// I right clicked on the application.properties > went to properties than
			// copy/pasted the exact location of the file
			prop.load(new FileReader(
					"/Users/christianmakoma/Revature/backupWorkspace/TestRevORM/src/main/resources/application.properties"));

			url = prop.getProperty("url"); // this is retrieving the value of the "url" key in application.properties
											// file
			username = prop.getProperty("username");
			password = prop.getProperty("password");

			/**
			 * When the getConnection() method is called, the DriverManager (class from the
			 * JDBC API - java.sql) will attempt to locate a suitable driver amongst those
			 * loaded initialization.
			 */
			conn = DriverManager.getConnection(url, username, password);

			logger.info("Database Connection Established");

		} catch (SQLException e) {
			logger.error("SQL Exception thrown - Cannot establish DB connection");
//			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.error("Cannot locate application.properties file");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Something wrong with app.props file");
			e.printStackTrace();
		}

		return conn; // if not successful, this will be null, and we'll see the error message
	}

}
