package com.mec.mis.dao;

import java.util.List;

import com.mec.mis.model.SDMModel;
import com.mec.util.Database;

public class SDMDao implements ISDMDao {
	private Database data;
	
	public SDMDao() {
		data = new Database();
	}

	@Override
	public List<SDMModel> getSdmList() {
		return data.list(SDMModel.class);
	}

	@Override
	public SDMModel getSdmById(String id) {
		return data.get(SDMModel.class, id);
	}

	@Override
	public int saveSdm(SDMModel sdm) {
		return data.executeUpdate("INSERT INTO sys_sch_dep_maj_info"
				+ " (id, name, status)"
				+ " VALUES ('" + sdm.getId() + "', '" + sdm.getName()
				+ "', " + (sdm.isStatus() ? "1" : "0") + ")");
	}

	@Override
	public int removeSdm(String id) {
		return data.executeUpdate("UPDATE sys_sch_dep_maj_info"
				+ " SET status = 0 WHERE id = '" + id + "'");
	}
	
}
