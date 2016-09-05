package com.sakila.MybatisImpl;

import java.sql.SQLException;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.Dao.IDDao;
import com.hand.Entity.EntityWithID;

public class LanguageDaoSp extends SqlSessionDaoSupport implements IDDao {
	
	public EntityWithID getByID(long ID) throws SQLException {
		return this.getSqlSession().selectOne("getByID_Language",ID);
	}

	public void delByID(long ID) throws SQLException {
		this.getSqlSession().delete("delByID_Language", ID);
	}
	
	public int getCountById(long ID) throws SQLException{
		return this.getSqlSession().selectOne("getCountById_Language",ID);
	}
}
