package com.hand.AOP;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.hand.Util.SpringBeanFactory;
import com.sakila.Entity.Film;
import com.sakila.Entity.Language;


public class TransactionTool {
	PlatformTransactionManager ptm;
	TransactionTemplate tt;
	
	public PlatformTransactionManager getPtm() {
		return ptm;
	}

	public void setPtm(PlatformTransactionManager ptm) {
		this.ptm = ptm;
	}

	public TransactionTemplate getTt() {
		return tt;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doFilmAddIdEntityTransaction(final Film aim){
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status){
				try{
					SpringBeanFactory.getBeanFactory().getBean("FilmDao", CanAddToDb.class).AddIdEntity(aim);
				}catch(Exception e){
					ptm.rollback(status);
					System.out.println("添加Customer失败，执行回滚\n原因："+e.getMessage());
				}
				return null;
			}
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doFilmDelByIDTransaction(final int delID){
		tt.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus status){
				try{
					SpringBeanFactory.getBeanFactory().getBean("FilmDao", CanAddToDb.class).delByID(delID);
				}catch(Exception e){
					ptm.rollback(status);
				System.out.println("删除Customer失败，执行回滚\n原因："+e.getMessage());
				}
				return null;
			}
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Film doFilmGetLastFilmTransaction(){
		return (Film) tt.execute(new TransactionCallback() {
			public Film doInTransaction(TransactionStatus status){
				Film res=null;
				try{
					res=(Film)  SpringBeanFactory.getBeanFactory().getBean("FilmDao", CanAddToDb.class).getLastFilm();
				}catch(Exception e){
					ptm.rollback(status);
					System.out.println("获取LastFilm失败，执行回滚\n原因："+e.getMessage());
				}
				return res;
			}
		});
	}

	public void doFilmrAddIdEntityTransaction(Film aim) {
		// TODO Auto-generated method stub
		
	}

	public Film doFilmGetLastCustomerTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	public int doLanguageGetCountByIdTransaction(int addNum) {
		// TODO Auto-generated method stub
		return 0;
	}
}	
