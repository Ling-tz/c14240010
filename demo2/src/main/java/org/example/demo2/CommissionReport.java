package org.example.demo2;

public class CommissionReport {
    private String fullName;
    private double salary;
    private double commissionPercent;
    private double commission;
    private double totalSalary;

    public CommissionReport(String fullName, double salary, double commissionPercent,
                            double commission, double totalSalary) {
        this.fullName = fullName;
        this.salary = salary;
        this.commissionPercent = commissionPercent;
        this.commission = commission;
        this.totalSalary = totalSalary;
    }

    public String getFullName() { return fullName; }
    public double getSalary() { return salary; }
    public double getCommissionPercent() { return commissionPercent; }
    public double getCommission() { return commission; }
    public double getTotalSalary() { return totalSalary; }


}