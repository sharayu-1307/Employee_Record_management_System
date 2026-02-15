package Employee_Details;

public class Employee {
	private int EmpId;
	private String name;
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String name) {
		super();
		EmpId = empId;
		this.name = name;
	}
	
}
