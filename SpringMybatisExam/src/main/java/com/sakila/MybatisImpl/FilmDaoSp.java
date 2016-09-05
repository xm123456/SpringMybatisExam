package com.sakila.MybatisImpl;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.AOP.CanAddToDb;
import com.hand.Dao.BasicIdEntityDao;
import com.hand.Entity.EntityWithID;
import com.sakila.Entity.Film;

public class FilmDaoSp extends SqlSessionDaoSupport implements CanAddToDb,BasicIdEntityDao{

	public EntityWithID getByID(long ID) throws SQLException {
		return this.getSqlSession().selectOne("getByID_Film",ID);
	}
	
	public void delByID(long ID) throws SQLException {
		this.getSqlSession().delete("delByID_Film",ID);

	}

	public void ModifyIdEntity(EntityWithID entity) throws SQLException {
		this.getSqlSession().update("ModifyIdEntity_Film", entity);

	}
	
	public void AddIdEntity(EntityWithID entity) throws SQLException {
		this.getSqlSession().insert("AddIdEntity_Film", entity);

	}
	
	public Film[] getByTitle_Film(String title) throws SQLException{
		List<Film> lc=this.getSqlSession().selectList("getByTitle_", title);
		Film[] res=new Film[lc.size()];
		res=lc.toArray(res);
		return res;
	}
	
	public Film getLastCustomer() throws SQLException{
		return this.getSqlSession().selectOne("getLastCustomer_Customer");
	}

	public Film getLastFilm() {
		// TODO Auto-generated method stub
		return null;
	}
}
