package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.studentDao;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Welcome to Student Management System !");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("press 1 to ADD Student");
			System.out.println("press 2 to DELETE Student");
			System.out.println("press 3 to UPDATE Student");
			System.out.println("press 4 to DISPLAY Student");
			System.out.println("press 5 to EXIT Student");
			
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
//				press 1 to ADD Student
				System.out.println("Enter Student Name : ");
				String name = br.readLine();
				
				System.out.println("Enter Student Phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter Student City : ");
				String city = br.readLine();
				
				Student student = new Student(name, phone, city); 
				
				if(studentDao.insertStudentToDB(student)) {
					System.out.println("Added");
				}
				
			}else if(choice == 2) {
//				press 2 to DELETE Student
				
				System.out.println("Enter Student Name (Student data will be deleted from record) : ");
				String name = br.readLine();
				
				if(studentDao.deleteStudentFromDB(name)) {
					System.out.println("Deleted");
				}
				
			}else if(choice == 3) {
//				press 3 to UPDATE ALL Student
				System.out.println("Enter Student Name (UPDATED) : ");
				String name = br.readLine();
				
				if(studentDao.updateStudentFromDB(name)) {
					System.out.println("updated");
				}

			}else if(choice == 4) {
//				press 4 to DISPLAY ALL Student
				
				if(studentDao.displayStudentFromDB()) {
					System.out.println("Selected");
				}

			}else {
				System.out.println("Thank You! Visit Again!");	
				break;
			}
			
		}
	}

}
