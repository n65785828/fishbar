package top.study01.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.study01.mapper.DepartmentMapper;
import top.study01.pojo.Department;
import top.study01.service.DeparmentService;

import java.util.Collection;

@Service
public class DeparmentServiceImp implements DeparmentService {

    @Autowired
    private DepartmentMapper deparmentMapper;
    @Override
    public Collection<Department> getAllDepartments() {
        return deparmentMapper.getAllDepartments();
    }
}
