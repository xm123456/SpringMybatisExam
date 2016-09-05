package com.hand;
import com.sakila.Entity.Language;
import java.sql.Timestamp;
import java.util.Scanner;
import com.hand.AOP.TransactionTool;
import com.hand.Util.SpringBeanFactory;
import com.sakila.Entity.Film;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		TransactionTool tt=SpringBeanFactory.getBeanFactory().getBean("transactionTool",TransactionTool.class);
		Film aim = new Film();
		Scanner sc = new Scanner(System.in);
		System.out.println("Context Start");
		System.out.println("请输入电影名称(title):");
		String input = sc.nextLine();
		aim.settitle(input);
		System.out.println("请输入电影描述(description):");
		input = sc.nextLine();
		aim.setdescription(input);
		System.out.println("请输入语言ID(language_id):");
		input = sc.nextLine();
		aim.setLanguage_id(input);
		System.out.println("context stop");
		Timestamp now = new Timestamp(new java.util.Date().getTime());
		aim.setCreate_date(now);
		aim.setLast_update(now);
		aim.setActive(true);
		
	tt.doFilmrAddIdEntityTransaction(aim);
		aim=tt.doFilmGetLastCustomerTransaction();

	}
}

