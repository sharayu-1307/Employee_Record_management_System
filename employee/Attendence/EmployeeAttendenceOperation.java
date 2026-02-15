package employee.Attendence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import EmployeeDatabase.ConnectionOfDatabse;

public class EmployeeAttendenceOperation {

    Scanner sc = new Scanner(System.in);

    public void AttendenceOperation() {

        System.out.println("Enter employee Id:");
        int empId = sc.nextInt();

        if (!checkEmpId(empId)) {
            System.out.println("Enter valid employee Id.");
            return;
        }

        System.out.println("Enter 1 for Punch In");
        System.out.println("Enter 2 for Punch Out");
        System.out.println("Enter 3 for Leave");

        int choice = sc.nextInt();

        Connection connect = ConnectionOfDatabse.databaseConnection();
        Date todayDate = Date.valueOf(LocalDate.now());

        try {

            // Check if record already exists for today
            PreparedStatement checkStmt = connect.prepareStatement(
                    "SELECT * FROM attendence WHERE empId=? AND todaysDate=?");
            checkStmt.setInt(1, empId);
            checkStmt.setDate(2, todayDate);

            ResultSet rs = checkStmt.executeQuery();
            boolean recordExists = rs.next();

            if (choice == 1) { // Punch In

                if (recordExists) {
                    System.out.println("Already punched in today.");
                } else {
                    PreparedStatement insertStmt = connect.prepareStatement(
                            "INSERT INTO attendence(empId, todaysDate, punchIn) VALUES (?, ?, ?)");
                    insertStmt.setInt(1, empId);
                    insertStmt.setDate(2, todayDate);
                    insertStmt.setTime(3, Time.valueOf(LocalTime.now()));
                    insertStmt.executeUpdate();
                    insertStmt.close();

                    System.out.println("Punch in success.");
                }

            } else if (choice == 2) { // Punch Out

                if (!recordExists) {
                    System.out.println("You have not punched in yet.");
                } else {
                    PreparedStatement updateStmt = connect.prepareStatement(
                            "UPDATE attendence SET punchOut=? WHERE empId=? AND todaysDate=?");
                    updateStmt.setTime(1, Time.valueOf(LocalTime.now()));
                    updateStmt.setInt(2, empId);
                    updateStmt.setDate(3, todayDate);
                    updateStmt.executeUpdate();
                    updateStmt.close();

                    System.out.println("Punch out success.");
                }

            } else if (choice == 3) { // Leave

                if (recordExists) {
                    System.out.println("Attendance already marked for today.");
                } else {
                    PreparedStatement leaveStmt = connect.prepareStatement(
                            "INSERT INTO attendence(empId, todaysDate, leaves) VALUES (?, ?, ?)");
                    leaveStmt.setInt(1, empId);
                    leaveStmt.setDate(2, todayDate);
                    leaveStmt.setBoolean(3, true);
                    leaveStmt.executeUpdate();
                    leaveStmt.close();

                    System.out.println("Leave marked successfully.");
                }

            } else {
                System.out.println("Invalid choice.");
            }

            checkStmt.close();
            connect.close();

        } catch (Exception e) {
            System.out.println("Database error occurred.");
        }
    }

    // Replace this with DB validation if needed
    public static boolean checkEmpId(int empId) {
        try {
            Connection con = ConnectionOfDatabse.databaseConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id FROM employee_data WHERE id=?");
            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();
            boolean exists = rs.next();

            ps.close();
            con.close();

            return exists;

        } catch (Exception e) {
            System.out.println("Error validating employee ID.");
        }
        return false;
    }
}
