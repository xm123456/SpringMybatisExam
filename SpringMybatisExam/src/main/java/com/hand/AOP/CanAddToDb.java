package com.hand.AOP;

import java.sql.SQLException;

import com.hand.Entity.EntityWithID;
import com.sakila.Entity.Film;

public interface CanAddToDb {
	public void AddIdEntity(EntityWithID entity) throws SQLException;
	public void delByID(long ID) throws SQLException;
	public Film getLastCustomer() throws SQLException;
	public Film getLastFilm();
}
