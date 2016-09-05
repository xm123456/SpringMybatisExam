package com.hand.Util;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DaoCreater {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		List<String> bian = new ArrayList<String>();
		String tp = null;
		while (!(tp = sc.nextLine()).equals("-1")) {
			bian.add(tp);
		}
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < bian.size(); i++) {
			String[] tps;
			tps = bian.get(i).split(" ");
			tps[2] = tps[2].substring(0, tps[2].length() - 1);
			map.put(tps[2], tps[1]);
		}
		String DB = sc.nextLine();
		String TB = sc.nextLine();
		Set<String> set = map.keySet();
		String[] ws = new String[0];
		ws = set.toArray(ws);
		System.out.println("Connection conn = ConnectionFactory.getInstance().openConnection(\"" + DB + "\");");
		System.out.println("PreparedStatement ps = conn.prepareCall(\"select * from " + TB + " where "+TB+"_id=?\");");
		System.out.println("ps.setLong(1, ID);\nResultSet rs = ps.executeQuery();");
		System.out.println(TB + " res = new " + TB + "();\n" + "if(rs.next()){\n"+"res.setID(ID);");
		for (int i = 0; i < ws.length; i++) {
			System.out.println("res.set" + ws[i] + "(rs.get" + map.get(ws[i]) + "(\"" + ws[i] + "\"));");
		}
		
		System.out.println("}\nconn.close()\n;return res;\n\n------------------------\n\n");
		
		System.out.println("Connection conn = ConnectionFactory.getInstance().openConnection(\""+DB+"\");");
		System.out.println("PreparedStatement ps = conn.prepareCall(\"delet from "+TB+" where "+TB+"_id=?\");");
		System.out.println("ps.setLong(1, ID);"+"ps.execute();\nconn.close();");
		
		System.out.println("\n\n------------------------\n\n");
		
		System.out.println("Connection conn = ConnectionFactory.getInstance().openConnection(\""+DB+"\");");
		System.out.print("PreparedStatement ps = conn.prepareCall(");
		System.out.print("\"update "+TB+" set "+ws[0]+"=?");
		for (int i = 1; i < ws.length; i++) {
			System.out.print(","+ws[i]+"=?");
		}
		System.out.println("where "+TB+"_id=?\");");
		int j;
		for (j = 0; j < ws.length; j++) {
			System.out.println("ps.set"+map.get(ws[j])+"("+(j+1)+", s.get"+ws[j]+"());");
		}
		System.out.println("ps.setLong("+j+",s.getID());");
		System.out.println("ps.execute();\nconn.close();");

		System.out.println("\n\n------------------------\n\n");
		
		System.out.println("Connection conn = ConnectionFactory.getInstance().openConnection(\""+DB+"\");");
		System.out.print("PreparedStatement ps = conn.prepareCall(");
		System.out.print("\"insert into  "+TB+"("+ws[0]);
		
		for (int i = 1; i < ws.length; i++) {
			System.out.print(","+ws[i]);
		}
		System.out.print(") values(?");
		for (int i = 1; i < ws.length; i++) {
			System.out.print(",?");
		}
		System.out.println(")\");");
		for (int i = 0; i < ws.length; i++) {
			System.out.println("ps.set"+map.get(ws[i])+"("+(i+1)+", s.get"+ws[i]+"());");
		}
		System.out.println("ps.execute();\nconn.close();");
	}

}
