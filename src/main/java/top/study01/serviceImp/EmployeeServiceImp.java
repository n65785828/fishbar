package top.study01.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.study01.mapper.EmployeeMapper;
import top.study01.pojo.Employee;
import top.study01.service.EmployeeService;

import java.util.Collection;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Collection<Employee> getAllEmployee() {
        return employeeMapper.getAllEmps();
    }

    @Override
    public int deleteEmployee(Integer id) {
        int result = employeeMapper.deleEmployeeById(id);
        return result;
    }

    @Override
    public Employee getEmpById(Integer id) {
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int updateEmployeeById(Employee employee) {
        int result = employeeMapper.UpdateEmployee(employee);
        return result;
    }


}
