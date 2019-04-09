package top.study01.service;

import top.study01.pojo.Employee;

import java.util.Collection;

public interface EmployeeService {
    Collection<Employee> getAllEmployee();

    int deleteEmployee(Integer id);

    Employee getEmpById(Integer id);

    int addEmployee(Employee employee);

    int updateEmployeeById(Employee employee);
}
