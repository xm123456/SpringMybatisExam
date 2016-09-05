package com.sakila.Entity;

import java.sql.Timestamp;

import com.hand.Entity.EntityWithID;

public class Language extends EntityWithID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2082688610470725503L;
	private String name;
	private Timestamp last_update;

	@Override
	public void setID(long ID) {
		this.ID = ID;
	}

	@Override
	public long getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	

	@Override
	public String toString() {
		return "Language [ID=" + ID + ", name=" + name + ", last_update=" + last_update + "]";
	}
}

