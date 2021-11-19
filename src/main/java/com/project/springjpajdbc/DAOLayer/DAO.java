package com.project.springjpajdbc.DAOLayer;

import com.project.springjpajdbc.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAO extends JpaRepository<Employee,Integer> {

}
