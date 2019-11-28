package com.mec.mis.dao;

import java.util.List;

import com.mec.mis.model.SDMModel;

public interface ISDMDao {
	List<SDMModel> getSdmList();
	SDMModel getSdmById(String id);
	int saveSdm(SDMModel sdm);
	int removeSdm(String id);
}
