package com.revature.persistance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.revature.util.Configuration;

public abstract class DbConnectionManager implements CoreImp {

	 public static CoreImp persistence = null;

	    public DbConnectionManager() {
	    	persistence = CorePostgreSqlQueries.getInstance();
	    }

}
