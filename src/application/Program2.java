package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---> Test 1: department findById <---");
		Department department = departmentDao.findById(3);
		System.out.println(department);
	
		System.out.println("\n---> Test 2: department findAll <---");
		List<Department> list = departmentDao.findAll();
		for (Department dept : list) {
			System.out.println(dept);
		}
		
		System.out.println("\n---> Test 3: department insert <---"); 
		department = new Department(null, "D1");
		departmentDao.insert(department);
		System.out.println("Inserido! Novo ID: " + department.getId());
		
		System.out.println("\n---> Test 4: department update <---");
		department = departmentDao.findById(1);
		department.setName("Technologies");
		departmentDao.update(department);
		System.out.println("Update Completed!");
		
		System.out.println("\n---> Test 5: seller delete <---");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		sc.close();

	}

}
