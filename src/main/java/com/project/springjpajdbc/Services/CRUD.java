package com.project.springjpajdbc.Services;

import com.project.springjpajdbc.models.Employee;

import java.util.List;

public interface CRUD {

    void setEmployee(Employee e) throws Exception;
    Employee getEmployee(int id) ;
    List<Employee> getAllEmployees() ;
    void updateEmpName(int id, String name) ;
    void updateEmpSal(int id, double salary);
    void deleteEmployee(int id) ;
}
