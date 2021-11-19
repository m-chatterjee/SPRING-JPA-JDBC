package com.project.springjpajdbc.Services;

import com.project.springjpajdbc.models.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee e=new Employee();

        e.setId(rs.getInt(1));
        e.setName(rs.getString(2));
        e.setLocation(rs.getString(3));
        e.setSalary(rs.getDouble(4));
        return e;
    }
}
