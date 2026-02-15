package Employee_Details;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import EmployeeDatabase.DatabaseOperationOfEmp;
import employee.Attendence.EmployeeAttendenceOperation;

public class EmployeeOperation {
	public static List<Employee> emp = new ArrayList<Employee>();
	
	public static List<Salary_Details> sal = new ArrayList<Salary_Details>();
	Scanner sc = new Scanner(System.in);
	
	public static Boolean checkEmpId(int id) {
		for(Employee e :emp) {
			if(e.getEmpId()==id) {
				return true;
			}
		}
		return false;
	}
	
	public void addEmployee() {
		
		boolean addMore=true;
		while(addMore) {
			Employee employee = new Employee();
			Salary_Details salary = new Salary_Details();
			
			System.out.println("Enter employee Id");
			int id = sc.nextInt();
			
			if(checkEmpId(id)) {
				System.out.println("Employee is already exist..");
			}else {
			//sc.nextLine();
			System.out.println("Enter employee name");
			String name = sc.next();
			System.out.println("Enter ctc");
			int ctc=sc.nextInt();
			System.out.println("Enter pf");
			int pf=sc.nextInt();
			
			int inHandSalary=ctc-pf;
			System.out.println("Your in hand salary is "+inHandSalary);
			
			employee.setEmpId(id);
			employee.setName(name);
			
			salary.setCtc(ctc);
			salary.setEmpId(id);
			salary.setPf(pf);
			
			salary.setInHandSalary(inHandSalary);
			
			emp.add(employee);
			sal.add(salary);
			System.out.println("Enter 1 to stop adding");
			
			if(sc.nextInt()==1) {
				addMore=false;
			}
			}
		}
		System.out.println("Employee added successfully...");
		
	}
	
	public void updateEmployee() {
		System.out.println("Enter employee Id to update:");
		int id=sc.nextInt();
		
		if(!checkEmpId(id)) {
			System.out.println("Employee not found!");
			return;
		}
		sc.nextLine();
		System.out.println("Enter new name:");
		String name = sc.next();
		
		for(Employee e:emp) {
			if(e.getEmpId()==id) {
				e.setName(name);
				break;
			}
		}
		
		System.out.println("Employee update successfully...");
	}
	
	
	public void deleteEmployee() {
		System.out.println("Enter employee Id to delete:");
		int id = sc.nextInt();
		
		if(!checkEmpId(id)) {
			System.out.println("Employee not found!");
			return;
		}
		
		Boolean found = false;
		for (int i = 0; i < emp.size(); i++) {
	        if (emp.get(i).getEmpId() == id) {
	            emp.remove(i);
	            found = true;
	            break;
	        }
	    }

	    
	    for (int i = 0; i < sal.size(); i++) {
	        if (sal.get(i).getEmpId() == id) {
	            sal.remove(i);
	            break;
	        }
	    }

	    if (found) {
	        System.out.println("Employee Deleted Successfully.");
	    } else {
	        System.out.println("Employee not found!");
	    }
		
	}
	
	public void viewEmployee() {
		System.out.println("Enter Employee Id to view employee:");
		int id = sc.nextInt();
		
		boolean found=false;
		
		for(Employee e:emp) {
			if(e.getEmpId()==id) {
				System.out.println("Employee Id:"+e.getEmpId());
				System.out.println("Name:"+e.getName());
				found = true;
				break;
			}
		}
		
		if(!found) {
			System.out.println("Employee not found!");
		}
	}
	 
	public void viewAllEmployees() {
		if(emp.isEmpty()) {
			System.out.println("No Employees available.");
			return;
		}
		
		for(Employee e: emp) {
			System.out.println("Employee Id: "+e.getEmpId());
			System.out.println("Name: "+e.getName());
		}
	}
		
		public static void main(String[] args) {
		EmployeeOperation ob= new EmployeeOperation();
		
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("1. Add Employee");
				System.out.println("2. Update Employee");
				System.out.println("3. Delete Employee");
				System.out.println("4. View Employee");
				System.out.println("5. View All Employees");
				System.out.println("6. Save To Database");
				System.out.println("7. Attendence");
				System.out.println("8. Exit");
				
				int choice=sc.nextInt();
				
				switch(choice) {
				case 1:
					ob.addEmployee();
					break;
					
				case 2:
					ob.updateEmployee();
					break;
					
				case 3:
					ob.deleteEmployee();
					break;
					
				case 4:
					ob.viewEmployee();
					break;
					
				case 5:
					ob.viewAllEmployees();
					break;
					
				case 6:
					DatabaseOperationOfEmp ob1 = new DatabaseOperationOfEmp();
					ob1.saveToDb();
					break;
					
				case 7:
					EmployeeAttendenceOperation eop= new EmployeeAttendenceOperation();
					eop.AttendenceOperation();
					break;
					
				case 8:
					System.out.println("Exiting...");
					System.exit(0);
					
				}
			}
		
			
			
		}
}
