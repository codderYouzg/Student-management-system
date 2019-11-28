package com.mec.mis.model;

/**
 * 学生基本信息
 * @author 铁血教主
 *
 */
public class StudentDetailModel {
	private String id;
	private String stuId;
	private String name;
	private NativeModel nativer;
	private NationModel national;
	private SDMModel sdm;
	private boolean status;
	
	public StudentDetailModel() {
	}

	public StudentDetailModel(String id, String stuId, String name, 
			NativeModel nativer, NationModel national, 
			SDMModel sdm, boolean status) {
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

	public StudentDetailModel setId(String id) {
		this.id = id;
		return this;
	}

	public String getStuId() {
		return stuId;
	}

	public StudentDetailModel setStuId(String stuId) {
		this.stuId = stuId;
		return this;
	}

	public String getName() {
		return name;
	}

	public StudentDetailModel setName(String name) {
		this.name = name;
		return this;
	}

	public NativeModel getNativer() {
		return nativer;
	}

	public StudentDetailModel setNativer(NativeModel nativer) {
		this.nativer = nativer;
		return this;
	}

	public NationModel getNational() {
		return national;
	}

	public StudentDetailModel setNational(NationModel national) {
		this.national = national;
		return this;
	}

	public SDMModel getSdm() {
		return sdm;
	}

	public StudentDetailModel setSdm(SDMModel sdm) {
		this.sdm = sdm;
		return this;
	}

	public boolean isStatus() {
		return status;
	}

	public StudentDetailModel setStatus(boolean status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return stuId + " " + id + " " + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stuId == null) ? 0 : stuId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDetailModel other = (StudentDetailModel) obj;
		if (stuId == null) {
			if (other.stuId != null)
				return false;
		} else if (!stuId.equals(other.stuId))
			return false;
		return true;
	}
}
