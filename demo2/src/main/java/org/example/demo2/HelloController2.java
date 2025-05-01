package org.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController2 {

    @FXML
    private TableColumn<CommissionReport, Double> AddSalary2;

    @FXML
    private TableColumn<CommissionReport, Double> addComPCT;

    @FXML
    private TableColumn<CommissionReport, Double> addCommi;

    @FXML
    private TableColumn<CommissionReport, String> addFullName;

    @FXML
    private TableView<CommissionReport> addTableView2;

    @FXML
    private TableColumn<CommissionReport, Double> addTotalSalary;

    private ObservableList<CommissionReport> commissionReports = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // Make sure these match the names of the fields in the CommissionReport class
        addFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        AddSalary2.setCellValueFactory(new PropertyValueFactory<>("salary"));
        addComPCT.setCellValueFactory(new PropertyValueFactory<>("commissionPercent"));
        addCommi.setCellValueFactory(new PropertyValueFactory<>("commission"));
        addTotalSalary.setCellValueFactory(new PropertyValueFactory<>("totalSalary"));

        // Load data from database
        loadCommissionData();
        addTableView2.setItems(commissionReports);
    }

    private void loadCommissionData() {
        try {
            // Update with your correct database connection details
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/PraktikumSQL", // Your DB URL
                    "postgres", // Your DB username
                    "......"  // Your DB password
            );

            String sql = "SELECT CONCAT(first_name, ' ', last_name) AS full_name, " +
                    "salary, " +
                    "commission_pct, " +
                    "(commission_pct * salary) AS commission, " +
                    "(salary + salary * commission_pct) AS total_salary " +
                    "FROM employees";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String fullName = rs.getString("full_name");
                double salary = rs.getDouble("salary");
                double commissionPercent = rs.getDouble("commission_pct");
                double commission = rs.getDouble("commission");
                double totalSalary = rs.getDouble("total_salary");

                // Create a CommissionReport object and add it to the ObservableList
                commissionReports.add(new CommissionReport(fullName, salary, commissionPercent, commission, totalSalary));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
