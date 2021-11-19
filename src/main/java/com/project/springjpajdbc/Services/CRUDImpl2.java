package com.project.springjpajdbc.Services;

import com.project.springjpajdbc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CRUDImpl2 implements CRUD {

    @Autowired
    JdbcTemplate template;

    public CRUDImpl2(){

    }

    public void createTable(){
        System.out.println(template.update
                ("CREATE TABLE IF NOT EXISTS " +
                        "EMPDETAILS" +
                        "(id int primary key ,name varchar(50) ,location varchar(50),salary double  )"));
    }

    @Override
    public void setEmployee(Employee e) throws Exception {
        template.update("insert into empdetails values(?,?,?,?)"
                ,e.getId(),e.getName(),e.getLocation(),e.getSalary());
    }

    @Override
    public Employee getEmployee(int id) {
        Employee e=template.queryForObject
                ("SELECT * FROM empdetails where id=?", (rs, rowNum) -> {
                            Employee emp=new Employee();

                            emp.setId(rs.getInt(1));
                            emp.setName(rs.getString(2));
                            emp.setLocation(rs.getString(3));
                            emp.setSalary(rs.getDouble(4));
                            return emp;}, id);
        return e;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list=template.query
                ("SELECT * FROM empdetails", (rs, rowNum) -> {
                    Employee emp=new Employee();

                    emp.setId(rs.getInt(1));
                    emp.setName(rs.getString(2));
                    emp.setLocation(rs.getString(3));
                    emp.setSalary(rs.getDouble(4));
                    return emp;});
        return list;
    }

    @Override
    public void updateEmpName(int id, String name) {

    }

    @Override
    public void updateEmpSal(int id, double salary) {

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
