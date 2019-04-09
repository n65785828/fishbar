package top.study01.mapper;

import org.apache.ibatis.annotations.*;
import top.study01.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    @Results({
            @Result(column = "d_id",property = "department" ,one=@One(select = "top.study01.mapper.DepartmentMapper.getDepartmentById"))
    })
    @Select("select * from employee where id = #{param1}")
    Employee getEmpById(int id);


    @Results({
            @Result(column = "d_id",property = "department" ,one=@One(select = "top.study01.mapper.DepartmentMapper.getDepartmentById"))
    })

    @Select("select * from employee")
    List<Employee> getAllEmps();

    @Delete("delete from employee where id=#{param1}")
    int deleEmployeeById(int id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into employee values(null,#{lastName},#{email},#{gender},#{department.id},#{birth})")
    int addEmployee(Employee employee);


    @Update("update employee set lastName = #{lastName},email=#{email},gender=#{gender},d_id=#{department.id},birth=#{birth} where id=#{id}")
    int UpdateEmployee(Employee employee);
}
