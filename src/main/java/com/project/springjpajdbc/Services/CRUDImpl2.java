package com.project.springjpajdbc.Services;

import com.project.springjpajdbc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDImpl2 implements CRUD {

    @Autowired
    JdbcTemplate template;

    public CRUDImpl2(){
        System.out.println(template.update
                ("CREATE TABLE IF NOT EXISTS " +
                        "EMPDETAILS" +
                        "(int id primary key ,name varchar(50) ,location varchar(50),salary double  )"));
    }

    @Override
    public void setEmployee(Employee e) throws Exception {
        template.update("insert into empdetails values(?,?,?,?)"
                ,e.getId(),e.getName(),e.getLocation(),e.getSalary());
    }

    @Override
    public Employee getEmployee(int id) {
        Employee e=template.queryForObject
                ("SELECT * FROM empdetails where id=?",new RowMapperImpl());
        return e;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
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
