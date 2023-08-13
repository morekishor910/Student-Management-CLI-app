package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class studentDao {
	public static boolean insertStudentToDB(Student student) {
		boolean flag = false;

		try {

			// jdbc connection and query
			Connection con = ConnectionConfig.createConnection();
			String query = "insert into students(name , phone, city) values (?,?,?)";

			// PreparedStatement for ? marked values
			PreparedStatement ps = con.prepareStatement(query);

			// inserting values
			ps.setString(1, student.getName());
			ps.setString(2, student.getPhone());
			ps.setString(3, student.getCity());

			// execute
			ps.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public static boolean deleteStudentFromDB(String name) {
		boolean flag = false;

		try {
			// jdbc connection and query
			Connection con = ConnectionConfig.createConnection();
			String query = "delete from students where name = ? ";

			// PreparedStatement for ? marked values
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, name);

			// execute
			ps.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public static boolean displayStudentFromDB() {
		boolean flag = false;
		try {
			// jdbc connection and query
			Connection con = ConnectionConfig.createConnection();
			String query = "select * from students";

			// Statement for no arguments
			Statement ps = con.createStatement();

			// execute
			ResultSet set = ps.executeQuery(query);

			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				System.out
						.println("Student [id=" + id + ", name=" + name + ", Phone=" + phone + ", city=" + city + "]");
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}

			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateStudentFromDB(String name) throws IOException {
	    boolean flag = false;
	    try {
	        Connection con = ConnectionConfig.createConnection();
	        String query = "SELECT * FROM students WHERE name = ?";

	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, name);
	        ResultSet set = ps.executeQuery();

	        while (set.next()) {
	            int id = set.getInt(1);
	            String name1 = set.getString(2);
	            String phone = set.getString(3);
	            String city = set.getString(4);
	            System.out.println("Student [id=" + id + ", name=" + name1 + ", Phone=" + phone + ", city=" + city + "]");
	            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	        }

	        int choice = 0;
	        while (choice == 0) {
	            System.out.println("Press 1 to UPDATE Student name");
	            System.out.println("Press 2 to UPDATE Student phone");
	            System.out.println("Press 3 to UPDATE Student city");

	            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            choice = Integer.parseInt(br.readLine());

	            String query1 = "";
	            String updatedvalue = "";
	            if (choice == 1) {
	                System.out.println("Enter Student Name (TO BE UPDATED): ");
	                updatedvalue = br.readLine();
	                query1 = "UPDATE students SET name = ? WHERE name = ?";
	            } else if (choice == 2) {
	                System.out.println("Enter Student phone (TO BE UPDATED): ");
	                updatedvalue = br.readLine();
	                query1 = "UPDATE students SET phone = ? WHERE name = ?";
	            } else if (choice == 3) {
	                System.out.println("Enter Student city (TO BE UPDATED): ");
	                updatedvalue = br.readLine();
	                query1 = "UPDATE students SET city = ? WHERE name = ?";
	            }

	            PreparedStatement ps1 = con.prepareStatement(query1);
	            ps1.setString(1, updatedvalue); // Set the updated value
	            ps1.setString(2, name); // Set the condition
	            ps1.executeUpdate(); // Execute the update
	            flag = true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return flag;
	}
}

//	public static boolean updateStudentFromDB(String name) throws IOException {
//		boolean flag = false;
//		try {
//			Connection con = ConnectionConfig.createConnection();
//			String query = "select * from students where name = '" +name+ "'";
//
//			// Statement for no arguments
//			Statement ps = con.createStatement();
//
//			// execute
//			ResultSet set = ps.executeQuery(query);
//
//			while (set.next()) {
//				int id = set.getInt(1);
//				String name1 = set.getString(2);
//				String phone = set.getString(3);
//				String city = set.getString(4);
//				System.out
//						.println("Student [id=" + id + ", name=" + name1 + ", Phone=" + phone + ", city=" + city + "]");
//				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//			}
//			
//			int choice = 0;
//			while (choice == 0) {
//				System.out.println("press 1 to UPDATE Student name");
//				System.out.println("press 2 to UPDATE Student phone");
//				System.out.println("press 3 to UPDATE Student city");
//
//				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//				choice = Integer.parseInt(br.readLine());
//				
//				if(choice == 1) {
//					
//					System.out.println("Enter Student Name (TO BE UPDATED): ");
//					String name1 = br.readLine();
//					
//					String query1 = "update students set name = ? where name = ?";
//					
//					PreparedStatement ps1 = con.prepareStatement(query1);
//					ps1.setString(1, name1);
//					ps1.setString(2, name);
//
//					flag = true;
//				}else if(choice ==2) {
//					
//					System.out.println("Enter Student phone (TO BE UPDATED): ");
//					String name1 = br.readLine();
//					String query1 = "update students set phone = ? where name = ?";
//					
//					PreparedStatement ps1 = con.prepareStatement(query1);
//					ps1.setString(1, name1);
//					ps1.setString(2, name);
//					flag = true;
//				}else if(choice ==3) {
//					System.out.println("Enter Student city (TO BE UPDATED): ");
//					String name1 = br.readLine();
//					String query1 = "update students set city = ? where name = ?";
//					
//					PreparedStatement ps1 = con.prepareStatement(query1);
//					ps1.setString(1, name1);
//					ps1.setString(2, name);
//					
//					flag = true;
//				}
//				
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
//}
