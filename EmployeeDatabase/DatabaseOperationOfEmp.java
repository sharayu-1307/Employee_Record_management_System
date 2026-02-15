package EmployeeDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import Employee_Details.Employee;
import Employee_Details.EmployeeOperation;
import Employee_Details.Salary_Details;


public class DatabaseOperationOfEmp {
	
	public void saveToDb()  {
		Connection connect =ConnectionOfDatabse.databaseConnection();
		try {
			PreparedStatement ptst =connect.prepareStatement("INSERT INTO employee_data(id,name) VALUES (?,?);");
			PreparedStatement ptst1 =connect.prepareStatement("INSERT INTO salary(empId,ctc,pf,inHanadSalary,monthNumber) VALUES (?,?,?,?,?);");
			List<Salary_Details> salaris = EmployeeOperation.sal;
			Iterator<Salary_Details> listOfSalary =salaris.iterator();
			
			while(listOfSalary.hasNext()) {
				Salary_Details sal = listOfSalary.next();
				ptst1.setInt(1, sal.getEmpId());
				ptst1.setInt(2, sal.getCtc());
				ptst1.setInt(3, sal.getPf());
				ptst1.setInt(4, sal.getSalary());
				ptst1.setInt(4, sal.getInHandSalary());
				ptst1.setInt(5, sal.getMonthNumber());
				ptst1.executeUpdate();
				//ptst1.close();
			}
			List<Employee> employees = EmployeeOperation.emp;
			
			Iterator<Employee> listOfEmp = employees.iterator();
			int count =0;
			while(listOfEmp.hasNext()) {
				Employee empl = listOfEmp.next();
				ptst.setInt(1, empl.getEmpId());
				ptst.setString(2, empl.getName());
				ptst.executeUpdate();
				count++;
				
			}
			System.out.println(count+" employee added......");
			ptst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
