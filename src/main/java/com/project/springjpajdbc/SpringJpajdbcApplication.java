package com.project.springjpajdbc;

import com.project.springjpajdbc.Services.CRUD;
import com.project.springjpajdbc.Services.CRUDImpl1;
import com.project.springjpajdbc.Services.CRUDImpl2;
import com.project.springjpajdbc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJpajdbcApplication {

    public static void main(String[] args) {
        try{
            ConfigurableApplicationContext context=
                    SpringApplication.run(SpringJpajdbcApplication.class, args);

            CRUDImpl2 dao = context.getBean(CRUDImpl2.class);


            Employee e1 = new Employee(1001, "Mainak", "Kolkata", 10500.5);
            Employee e2 = new Employee(1002, "Arjun", "Delhi", 20500.5);
            Employee e3 = new Employee(1003, "Rosy", "Chennai", 30500.5);
//            dao.createTable();
//            dao.setEmployee(e1);
//            dao.setEmployee(e2);
//            dao.setEmployee(e3);
//            dao.deleteEmployee(1002);
//            dao.updateEmpName(1001,"Raveena");
//            dao.updateEmpSal(1002,50500.5);
            dao.getAllEmployees().stream().forEach(System.out::println);
//            System.out.println(dao.getEmployee(1001));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
