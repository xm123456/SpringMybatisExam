package com.hand.Dao;

import java.sql.SQLException;

import com.hand.Entity.EntityWithID;

public interface BasicIdEntityDao extends IDDao {
	/*
	 * �����ݿ����޸�һ������
	 */
	public void ModifyIdEntity(EntityWithID entity) throws SQLException;
	
	/*
	 * �����ݿ������һ������
	 */
	public void AddIdEntity(EntityWithID entity) throws SQLException;
}
