package Employee_Details;

public class Salary_Details {
	private int EmpId;
	private int ctc;
	private int pf;
	private int salary;
	private int inHandSalary;
	private int monthNumber;
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public int getInHandSalary() {
		return inHandSalary;
	}
	public void setInHandSalary(int inHandSalary) {
		this.inHandSalary = inHandSalary;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getMonthNumber() {
		return monthNumber;
	}
	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}
	
	public Salary_Details(int empId, int ctc, int pf, int salary, int inHandSalary, int monthNumber) {
		super();
		EmpId = empId;
		this.ctc = ctc;
		this.pf = pf;
		this.salary = salary;
		this.inHandSalary = inHandSalary;
		this.monthNumber = monthNumber;
	}
	public Salary_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
