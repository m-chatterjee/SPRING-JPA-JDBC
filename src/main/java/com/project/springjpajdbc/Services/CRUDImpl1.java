package com.project.springjpajdbc.Services;

import com.project.springjpajdbc.DAOLayer.DAO;
import com.project.springjpajdbc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CRUDImpl1 implements CRUD {

    @Autowired
    private DAO dao;

    @Override
    public void setEmployee(Employee e) throws Exception {
        try{
            dao.save(e);
        }
        catch(NoSuchElementException ex) {
            dao.save(e);
        }
    }

    @Override
    public Employee getEmployee(int id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    @Override
    public void updateEmpName(int id, String name) {

    }

    @Override
    public void updateEmpSal(int id, double salary) {

    }

    @Override
    public void deleteEmployee(int id) {
        dao.deleteById(id);
    }
}
