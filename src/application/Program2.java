package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.creaDepartmentDao();
		
		System.out.println("=== TEST 1: Departmen findById ===");
		Department department = departmentDao.findById(3);
		
		System.out.println(department);
		
		System.out.println("=== TEST 2: Depatment update ===");
		department = departmentDao.findById(1);
		department.setName("Padaria");
		departmentDao.update(department);
		System.out.println("update completo!" );
		
		System.out.println("=== TEST 3: department insert ===");
		Department newDepartment = new Department(null, "Locadora");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("=== TEST 4: department delete ===");
		System.out.println("Entre com id para deletar" );
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println(id + " Deletado" );
		
		System.out.println("=== TEST 3: seller findAll ===");				 
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}				
	}
}
