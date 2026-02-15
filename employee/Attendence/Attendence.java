package employee.Attendence;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendence {
	private int empId;
	private LocalDate date;
	private LocalTime punchIn;
	private LocalTime punchOut;
	private int totalHours;
	private boolean leaves;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getPunchIn() {
		return punchIn;
	}
	public void setPunchIn(LocalTime punchIn) {
		this.punchIn = punchIn;
	}
	public LocalTime getPunchOut() {
		return punchOut;
	}
	public void setPunchOut(LocalTime punchOut) {
		this.punchOut = punchOut;
	}
	public int getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}
	public boolean isLeaves() {
		return leaves;
	}
	public void setLeaves(boolean leaves) {
		this.leaves = leaves;
	}
	public Attendence(int empId, LocalDate date, LocalTime punchIn, LocalTime punchOut, int totalHours,
			boolean leaves) {
		super();
		this.empId = empId;
		this.date = date;
		this.punchIn = punchIn;
		this.punchOut = punchOut;
		this.totalHours = totalHours;
		this.leaves = leaves;
	}
	public Attendence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
