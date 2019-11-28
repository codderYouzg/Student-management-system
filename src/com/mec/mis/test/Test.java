package com.mec.mis.test;

import java.util.List;

import com.mec.mis.model.SDMModel;
import com.mec.util.ClassTableFactory;
import com.mec.util.Database;

public class Test {

	public static void main(String[] args) {
		ClassTableFactory ctf = new ClassTableFactory();
		ctf.loadMapping("/classtable.mapping.xml");
		Database.loadDatabaseConfig("/database.cfg.properties");

		List<SDMModel> sdmList = new Database().list(SDMModel.class);
		for (SDMModel sdm : sdmList) {
			System.out.println(sdm);
		}
	}

}
