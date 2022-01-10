package com.revature.persistance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface CoreImp {
	
	HashMap<Class<?>, HashSet<Object>> getCache();
	
	boolean addClass(final Class<?> clazz);
	
	boolean UpdateObjectInDB(final Object obj,final String update_columns);
	
	boolean removeObjectFromDB(final Object obj);
	
	boolean addObjectToDB(final Object obj);
	
	Optional<List<Object>> getListObjectFromDB(final Class <?> clazz, final String columns, final String conditions);
	
	Optional<List<Object>> getListObjectFromDB(final Class <?> clazz, final String columns, final String conditions,final String operators);
	
	Optional<List<Object>> getListObjectFromDB(final Class<?> clazz);
	
}
