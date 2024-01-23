package com.user.entity;

import java.util.List;

public class User {

	private int id;
	private String name;
	
	List<Contact> cList;

	public User(int id, String name, List<Contact> cList) {
		super();
		this.id = id;
		this.name = name;
		this.cList = cList;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cList
	 */
	public List<Contact> getcList() {
		return cList;
	}

	/**
	 * @param cList the cList to set
	 */
	public void setcList(List<Contact> cList) {
		this.cList = cList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", cList=" + cList + "]";
	}
	
	
	
}
