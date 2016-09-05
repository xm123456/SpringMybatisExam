package com.sakila.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.hand.Entity.EntityWithID;

public class Film extends EntityWithID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1764969125543032413L;
	private String title;
	private String description;
	private int language_id;
	private boolean active;
	private Timestamp create_date;
	private Timestamp last_update;
	
	


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	



	@Override
	public String toString() {
		return "Film [title=" + title + ", description="
				+description + ",language_id=" + language_id + ", active=" + active
				+ ", create_date=" + create_date + ", last_update=" + last_update + "]";
	}

	@Override
	public void setID(long ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLanguage_id(String input) {
		// TODO Auto-generated method stub
		
	}

	public void setdescription(String input) {
		// TODO Auto-generated method stub
		
	}

	public void settitle(String input) {
		// TODO Auto-generated method stub
		
	}

	

	
}
