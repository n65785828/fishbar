package top.study01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import top.study01.pojo.Department;

import java.util.List;

public interface DepartmentMapper {

    @Select("select * from department where id = #{param1}")
    Department getDepartmentById(int id);

    @Options(useGeneratedKeys = true ,keyProperty = "id",keyColumn = "id")
    @Insert("insert into department (departmentName) values (#{departmentName})")
    int addDepartent(Department department);


    @Select("select * from department")
    List<Department> getAllDepartments();


}
