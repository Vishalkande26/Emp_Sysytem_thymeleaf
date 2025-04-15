package com.example.demo.service;

import com.example.demo.entity.Employee;
import java.util.List;

public interface EmpService {

    Employee saveEmp(Employee emp);

    List<Employee> getAllEmp();

    Employee getEmpById(int id);

    boolean deleteEmp(int id);

}
