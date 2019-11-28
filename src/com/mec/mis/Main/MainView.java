package com.mec.mis.Main;

import com.mec.mis.view.StudentMisView;
import com.mec.util.ClassTableFactory;
import com.mec.util.Database;

public class MainView {

	public static void main(String[] args) {
		Database.loadDatabaseConfig("/database.cfg.properties");
		ClassTableFactory ctf = new ClassTableFactory();
		ctf.loadMapping("/classtable.mapping.xml");
		new StudentMisView().showView();
	}

}
