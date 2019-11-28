package com.mec.mis.dao;

import java.util.List;

import com.mec.mis.model.NationModel;
import com.mec.mis.model.NativeModel;

public interface INativeDao {
	List<NativeModel> getNatives();
	List<NationModel> getNations();
}
