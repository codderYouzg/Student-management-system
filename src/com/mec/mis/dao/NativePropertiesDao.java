package com.mec.mis.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mec.mis.model.NationModel;
import com.mec.mis.model.NativeModel;
import com.mec.util.Database;
import com.mec.util.PropertiesParser;

public class NativePropertiesDao implements INativeDao {
	static {
		Database.loadDatabaseConfig("/database.cfg.properties");
	}
	
	public NativePropertiesDao() {
	}
	
	@Override
	public List<NativeModel> getNatives() {
		List<NativeModel> nativeList = new ArrayList<>();
		
		Set<String> nativeKeys = PropertiesParser.keySet();
		Iterator<String> iter = nativeKeys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (key.startsWith("native.") )  {
				String id = key;
				String name = PropertiesParser.value(id);
				nativeList.add(new NativeModel(id.substring(7), name));
			}
		}
		nativeList.sort(new Comparator<NativeModel>() {
			@Override
			public int compare(NativeModel one, NativeModel other) {
				return one.getId().compareTo(other.getId());
			}
		});
		
		return nativeList;
	}

	@Override
	public List<NationModel> getNations() {
		List<NationModel> nationList = new ArrayList<>();
		
		Set<String> nativeKeys = PropertiesParser.keySet();
		Iterator<String> iter = nativeKeys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (key.startsWith("nation.") )  {
				String id = key;
				String name = PropertiesParser.value(id);
				nationList.add(new NationModel(id.substring(7), name));
			}
		}
		nationList.sort(new Comparator<NationModel>() {
			@Override
			public int compare(NationModel one, NationModel other) {
				return one.getId().compareTo(other.getId());
			}
		});
		
		return nationList;
	}

}
