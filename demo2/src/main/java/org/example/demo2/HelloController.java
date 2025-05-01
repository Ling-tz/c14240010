package org.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class HelloController {

    @FXML
    private TableColumn<Employee, Double> addCom;

    @FXML
    private TableColumn<Employee, Integer> addDepartment;

    @FXML
    private TableColumn<Employee, String> addEmail;

    @FXML
    private TableColumn<Employee, Integer> addEmployee;

    @FXML
    private TableColumn<Employee, String> addFirstName;

    @FXML
    private TableColumn<Employee, String> addHire;

    @FXML
    private TableColumn<Employee, Integer> addJob;

    @FXML
    private TableColumn<Employee, String> addLastName;

    @FXML
    private TableColumn<Employee, Integer> addManager;

    @FXML
    private TableColumn<Employee, String> addNomor;

    @FXML
    private TableColumn<Employee, Double> addSalary;

    @FXML
    private TableView<Employee> addTableView;

    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Mapping kolom
        addEmployee.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        addFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        addNomor.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addHire.setCellValueFactory(new PropertyValueFactory<>("hireDate"));
        addJob.setCellValueFactory(new PropertyValueFactory<>("jobId"));
        addSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        addCom.setCellValueFactory(new PropertyValueFactory<>("commissionPCT"));
        addManager.setCellValueFactory(new PropertyValueFactory<>("managerId"));
        addDepartment.setCellValueFactory(new PropertyValueFactory<>("departmentId"));

        // Load data dari database
        loadEmployees();
        addTableView.setItems(employeeData);
    }

    private void loadEmployees() {
        try {
            // Ganti URL, username, password sesuai database kamu
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/PraktikumSQL",
                    "postgres",
                    "......"
            );

            String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                employeeData.add(new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("hire_date"),
                        rs.getString("job_id"),
                        rs.getDouble("salary"),
                        rs.getDouble("commission_pct"),
                        rs.getInt("manager_id"),
                        rs.getInt("department_id")
                ));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
