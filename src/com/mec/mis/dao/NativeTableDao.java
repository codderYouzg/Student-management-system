package com.mec.mis.dao;

import java.util.List;

import com.mec.mis.model.NationModel;
import com.mec.mis.model.NativeModel;
import com.mec.util.Database;

public class NativeTableDao implements INativeDao {
	private Database database;
	
	static {
		Database.loadDatabaseConfig("/database.cfg.properties");
	}
	
	public NativeTableDao() {
		database = new Database();
	}
	
	@Override
	public List<NativeModel> getNatives() {
		return database.list(NativeModel.class);
	}

	@Override
	public List<NationModel> getNations() {
		return database.list(NationModel.class);
	}
	
}
