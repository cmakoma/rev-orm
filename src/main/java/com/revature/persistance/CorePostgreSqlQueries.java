package com.revature.persistance;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.revature.annotation.Column;
import com.revature.annotation.PrimaryKey;
import com.revature.annotation.Table;
import com.revature.util.ConnectionUtil;

public class CorePostgreSqlQueries implements CoreImp {
	private static Logger logger = Logger.getLogger(CorePostgreSqlQueries.class);
	

	private static final CorePostgreSqlQueries INSTANCE = new CorePostgreSqlQueries();

	public static CoreImp getInstance() {
		return INSTANCE;
	}

	@Override
	public HashMap<Class<?>, HashSet<Object>> getCache() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addClass(Class<?> clazz) {

		Connection conn = ConnectionUtil.getConnection();

		// spot to hold returned id for new record
		int newId = -1;

		// determine the number of fields
		int numberOfFields = 0;
		for (Field field : clazz.getFields()) {

			// check to see if the class has an @Table
			if (!field.isAnnotationPresent(Table.class)) {
				numberOfFields++;
			}
		}

		

		try {
			
			String sql = null;
			// check to see if the class has an @fdfIgonre
			if (!clazz.isAnnotationPresent(Table.class)) {

				// Start the sql statement
				sql = "insert into " + "\"" + clazz.getSimpleName().toLowerCase() + "\"" + " (";

				int fieldCounter = 0;
				for (Field field : clazz.getFields()) {

					// check to see if the class has an @fdfIgonre
					if (!field.isAnnotationPresent(Table.class)) {

						fieldCounter++;
						if (!field.getName().equals("id")) {
							sql += " " + field.getName();
							if (numberOfFields > fieldCounter)
								sql += ",";
						}
					}
				}

				sql += " ) values (";

				// insert the correct number of question marks for the prepared statement
				int fieldCounter2 = 0;
				for (Field field : clazz.getFields()) {

					// check to see if the class has an @Table
					if (!field.isAnnotationPresent(Table.class)) {

						fieldCounter2++;
						if (!field.getName().equals("id")) {
							sql += " ?";
							if (numberOfFields > fieldCounter2)
								sql += ",";
						}
					}
				}
				sql += ");";
			}
			
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			ResultSet rs = null;
			preparedStmt.execute();
			rs = preparedStmt.getGeneratedKeys();
			rs.next();
			newId = rs.getInt("id");

			
		} catch (SQLException e) {
			logger.warn("Unable to insert Class");
			e.printStackTrace();
		}
		
		return newId == -1 ? false : true;

	}

	@Override
	public boolean UpdateObjectInDB(Object obj, String update_columns) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeObjectFromDB(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addObjectToDB(Object obj) {
		Connection conn = ConnectionUtil.getConnection();

		// spot to hold returned id for new record
		int newId = -1;

		// determine the number of fields
		int numberOfFields = 0;
		for (Field field : obj.getClass().getFields()) {

			// check to see if the class has an @Table
			if (!field.isAnnotationPresent(PrimaryKey.class)) {
				numberOfFields++;
			}
		}

		

		try {
			
			String sql = null;
			// check to see if the class has an @fdfIgonre
			if (obj.getClass().isAnnotationPresent(Table.class)) {

				// Start the sql statement
				sql = "insert into " + "\"" + obj.getClass().getSimpleName().toLowerCase() + "\"" + " (";

				int fieldCounter = 0;
				for (Field field : Table.class.getFields()) {

					// check to see if the class has an @fdfIgonre
					if (!field.isAnnotationPresent(PrimaryKey.class)) {

						fieldCounter++;
						if (!field.getName().equals("id")) {
							sql += " " + field.getName();
							if (numberOfFields > fieldCounter)
								sql += ",";
						}
					}
				}

				sql += " ) values (";

				// insert the correct number of question marks for the prepared statement
				int fieldCounter2 = 0;
				for (Field field : Table.class.getFields()) {

					// check to see if the class has an @Table
					if (!field.isAnnotationPresent(Table.class)) {

						fieldCounter2++;
						if (!field.getName().equals("id")) {
							sql += " ?";
							if (numberOfFields > fieldCounter2)
								sql += ",";
						}
					}
				}
				sql += ");";
			}
			
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			ResultSet rs = null;
			preparedStmt.execute();
			rs = preparedStmt.getGeneratedKeys();
			rs.next();
			newId = rs.getInt("id");

			
		} catch (SQLException e) {
			logger.warn("Unable to insert obj");
			e.printStackTrace();
		}
		
		return newId == -1 ? false : true;
	}

	@Override
	public Optional<List<Object>> getListObjectFromDB(Class<?> clazz, String columns, String conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Object>> getListObjectFromDB(Class<?> clazz, String columns, String conditions,
			String operators) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Object>> getListObjectFromDB(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
