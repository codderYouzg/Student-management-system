package com.mec.mis.service;

import java.util.ArrayList;
import java.util.List;

import com.mec.mis.dao.SDMDao;
import com.mec.mis.model.SDMModel;

public class SDMService {
	private SDMDao sdmDao;
	private static List<SDMModel> sdmList;
	
	public SDMService() {
		sdmDao = new SDMDao();
	}
	
	private List<SDMModel> getSdmList() {
		if (sdmList == null) {
			sdmList = sdmDao.getSdmList();
		}
		
		return sdmList;
	}
	
	public List<SDMModel> getSchoolList() {
		List<SDMModel> sdmList = getSdmList();
		List<SDMModel> schoolList = new ArrayList<>();
		
		for (SDMModel sdm : sdmList) {
			if (sdm.getId().substring(2).equals("0000")
					&& sdm.isStatus()) {
				schoolList.add(sdm);
			}
		}
		
		return schoolList;
	}
	
	public List<SDMModel> getDepartment(String schoolId) {
		List<SDMModel> sdmList = getSdmList();
		List<SDMModel> departmentList = new ArrayList<>();
		
		for (SDMModel sdm : sdmList) {
			if (!sdm.getId().substring(2).equals("0000")
					&& sdm.getId().substring(4).equals("00")
					&& sdm.getId().substring(0, 2)
							.equals(schoolId.substring(0, 2))
					&& sdm.isStatus()) {
				departmentList.add(sdm);
			}
		}
		
		return departmentList;
	}
	
	public List<SDMModel> getMajor(String departmentId) {
		List<SDMModel> sdmList = getSdmList();
		List<SDMModel> majorList = new ArrayList<>();
		
		for (SDMModel sdm : sdmList) {
			if (!sdm.getId().substring(4).equals("00")
					&& sdm.getId().substring(0, 4)
							.equals(departmentId.substring(0, 4))
					&& sdm.isStatus()) {
				majorList.add(sdm);
			}
		}
		
		return majorList;
	}
	
}
