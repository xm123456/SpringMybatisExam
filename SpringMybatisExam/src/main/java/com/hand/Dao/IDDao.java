package com.hand.Dao;

import java.sql.SQLException;

import com.hand.Entity.EntityWithID;

public interface IDDao {
	/*
	 * ����ID���һ������
	 */
	public EntityWithID getByID(long ID) throws SQLException;

	/*
	 * ����IDɾ��һ������
	 */
	public void delByID(long ID) throws SQLException;
}
