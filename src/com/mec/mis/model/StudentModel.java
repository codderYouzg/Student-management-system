package com.mec.mis.model;

/**
 * 学生基本信息
 * @author 铁血教主
 *
 */
public class StudentModel {
	private String id;
	private String stuId;
	private String name;
	private String nativer;
	private String national;
	private String sdm;
	private boolean status;
	
	public StudentModel() {
	}

	public StudentModel(String id, 
			String stuId,
			String name, 
			String nativer, 
			String national, 
			String sdm,
			boolean status) {
		this.id = id;
		this.stuId = stuId;
		this.name = name;
		this.nativer = nativer;
		this.national = national;
		this.sdm = sdm;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public String getStuId() {
		return stuId;
	}

	public String getName() {
		return name;
	}

	public String getNativer() {
		return nativer;
	}

	public String getNational() {
		return national;
	}

	public String getSdm() {
		return sdm;
	}

	public boolean isStatus() {
		return status;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNativer(String nativer) {
		this.nativer = nativer;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public void setSdm(String sdm) {
		this.sdm = sdm;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return stuId + (status ? " √ " : " × ") + name;
	}

}
