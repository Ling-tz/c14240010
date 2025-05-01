package org.example.demo2;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private String jobId;
    private double salary;
    private double commissionPCT;
    private int managerId;
    private int departmentId;

    public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, double salary, double commissionPCT, int managerId, int departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPCT = commissionPCT;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getHireDate() { return hireDate; }
    public double getSalary() { return salary; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getJobId() { return jobId; }
    public double getCommissionPCT() { return commissionPCT; }
    public int getManagerId() { return managerId; }
    public int getDepartmentId() { return departmentId; }
}
