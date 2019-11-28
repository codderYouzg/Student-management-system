package com.mec.mis.model;

public class SDMModel {
	private String id;
	private String name;
	private boolean status;
	
	public SDMModel() {
	}

	public SDMModel(String id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isStatus() {
		return status;
	}

	public SDMModel setId(String id) {
		this.id = id;
		return this;
	}

	public SDMModel setName(String name) {
		this.name = name;
		return this;
	}

	public SDMModel setStatus(boolean status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return id + (status ? " √ " : " × ") + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		SDMModel other = (SDMModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
